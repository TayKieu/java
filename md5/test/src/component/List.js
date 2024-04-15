import React, {useEffect, useState} from "react";
import * as product_service from "../service/product_service";
import {toast, ToastContainer} from "react-toastify";
import {NavLink} from "react-router-dom";
import * as category_service from "../service/category_service";
import {Field, Form, Formik} from "formik";
import {Dna} from "react-loader-spinner";

export function List() {
    const [products, setProducts] = useState([])
    const [categories, setCategories] = useState([])
    const [key, setKey] = useState('')
    useEffect(() => {
        const fetchApi = async () => {
            if (key === "") {
                const result = await product_service.findAll()
                setProducts(result)
            }
            const result2 = await category_service.findAllCategories()
            setCategories(result2)
        }
        fetchApi()
    }, []);
    const changeSearch = (event) => {
        setKey(event.target.value)
    }
    const handleSearch = () => {
        const params = {
            key: key
        }
        const fetchApi = async () => {
            const result = await product_service.findByKey(params.key)
            if (result.toString()) {
                toast('Danh sách cần tìm')
                setProducts(result)
            }
            else {toast('Không có sản phẩm nào')}

        }
        fetchApi()
    }
    return (
        <>
            <div>
                <h1>Product list</h1>
                <div>
                    <div>
                        <input type="search"
                               id="form1"
                               value={key}
                               onChange={changeSearch}
                        />
                        <button className="btn btn-success" onClick={handleSearch}>Find</button>
                    </div>
                    <div className='container'>
                        <Formik initialValues={{id: "", name: ""}} onSubmit={(values, {setSubmitting}) => {
                        }}>
                            <Form>
                                <div><Field as="select" name="category" id="category">
                                    {categories.map((cate) => (
                                        <option value={cate.id}>{cate.name}</option>
                                    ))
                                    }
                                </Field></div>
                            </Form></Formik>
                    </div>
                </div>
                <div>
                    <ToastContainer/>
                </div>
                <NavLink to='/create' className='btn btn-success'>Add new product</NavLink>
                <table className='table'>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Category</th>
                        <th>Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    {products.map((p) => (
                        <tr>
                            <td>{p.id}</td>
                            <td>{p.name}</td>
                            <td>{p.quantity}</td>
                            <td>{p.description}</td>
                            <td>{p.price}</td>
                            <td>{
                                categories.find(category => String(category.id) === String(p.category))?.name
                            }</td>
                            <td>{p.date}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
            <ToastContainer></ToastContainer>
        </>
    )
}