import * as product_service from "../service/product_service"
import * as category_service from "../service/category_service"
import {useEffect, useState} from "react";
import {Paginate} from "./Paginate";
export function List() {
    const [products, setProducts] = useState([])

    useEffect(() => {
            const fetchApi = async () => {
                const result1 = await product_service.findAll()
                setProducts(result1)
            }
            fetchApi()
    }, []);
    return (
        <>
            <Paginate data={products}></Paginate>

        </>
    )
}