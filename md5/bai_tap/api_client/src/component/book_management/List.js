import * as bm_service from "../../service/Book_management_service"
import React, {useEffect, useState} from "react";
import {NavLink} from "react-router-dom";
import ReactPaginate from 'react-paginate';

export function List() {
    const [books, setBooks] = useState([])
    const [key,setkey] = useState('')
    const [totalProducts,setTotalProducts] = useState(0)
    const [totalPages,setTotalPages] = useState(0)
    const changeSearch = (event) =>{
        console.log(event.target.value);
        setkey(event.target.value)
    }
    const handleSearch =() =>{
        const params = {
            // page:
            key: key
        }

        console.log(params.key)
        const fetchApi1 = async () => {
            const result = await bm_service.findByKey(params.key)
            setBooks(result)
        }
        fetchApi1();
        console.log(books)
    }
    useEffect(() => {
        if(key === ""){
        const fetchApi = async (page) => {
                const result = await bm_service.findAll(page)
            if(result && result.data){
                setTotalProducts(result.total)
                setBooks(result.data)
                setTotalPages(result.total_page)
            }
            }
        fetchApi(2)}
    }, []);

    console.log(books);
    const handlePageClick = (event) => {
        fe
    };
    return (
        <>
            <h1>Library</h1>
            <div>
                <div>
                    <input type="search"
                           className="form-control"
                           id="form1"
                           value={key}
                           onChange={changeSearch}
                    />
                    <button className="btn btn-success" onClick={handleSearch}>Find </button>
                </div>

            </div>
            <NavLink to='/create' className='btn btn-success'>Add new book</NavLink>
            <table className="table">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                {
                    books.map((b,index) =>(
                        <tr>
                            <td>{b.title}</td>
                            <td>{b.quantity}</td>
                            <td>
                                <NavLink to={`/update/${b.id}`} className='btn btn-primary'>Edit</NavLink>
                                <NavLink to={`/delete/${b.id}`} className='btn btn-danger'>Delete</NavLink>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
            <ReactPaginate
                breakLabel="..."
                nextLabel="next >"
                onPageChange={handlePageClick}
                pageRangeDisplayed={2}
                marginPagesDisplayed={2}
                pageCount={totalPages}
                previousLabel="< previous"
                pageClassName="page-item"
                pageLinkClassName="page-link"
                previousClassName="page-item"
                previousLinkClassName="page-link"
                nextClassName="page-item"
                nextLinkClassName="page-link"
                breakClassName="page-item"
                breakLinkClassName="page-link"
                containerClassName="pagination"
                activeClassName="active"
            />
        </>
    )
}