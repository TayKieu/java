import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import async from "async";
import * as product_service from "../service/product_service"
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import {Dna} from "react-loader-spinner";
import {toast, ToastContainer} from "react-toastify";
import * as category_service from "../service/category_service";

export function Update(){
    const {id} = useParams()
    const [productEdit,setProductEdit] = useState({
        name:'',
        quantity:0,
        description:'',
        category:0,
        price:0
    })
    const [categories, setCategories] = useState([])
    const navigate = useNavigate()
    useEffect(() => {
        const findById = async () =>{
            const result = await product_service.findById(id)
            setProductEdit(result)
        }
        findById()
        const findAllCate = async () => {
            const res = await category_service.findAllCategories()
            setCategories(res)
        }
        findAllCate()
    }, []);
    return productEdit.name !== "" ?(
        <>
            <Formik initialValues={{
                name: productEdit.name,
                quantity: productEdit.quantity,
                description: productEdit.description,
                category:productEdit.category,
                price: productEdit.price
            }}
                    validationSchema={Yup.object(
                        {
                            name: Yup.string().required(),
                            quantity: Yup.string().required(),
                            description: Yup.string().required(),
                            price: Yup.string().required()
                            // name: Yup.string()
                            //     .required("Tên không được để trống")
                            //     .matches(/^[A-Za-z ]{3,100}$/, "Tên không đúng định dạng"),
                            // age: Yup.number()
                            //     .min(18)
                        })}
                        onSubmit={(values,{setSubmitting})=>{
                            const edit = async ()=>{
                                setSubmitting(false)
                                await product_service.edit(id,values)
                                toast("Update success")
                                navigate("/")
                            }
                            edit()
                        }}>
                {({isSubmitting})=>(
                    <div className='container'>
                        <h1>Add new product</h1>
                        <Form>
                            <div className='mb-3'>
                                <label htmlFor='name' className='form-label'>
                                    Name
                                </label>
                                <Field type='text' className='form-control' id='name' name='name'></Field>
                                <ErrorMessage name='name' component='span' className=' text-danger'></ErrorMessage>
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='quantity' className='form-label'>
                                    Quantity
                                </label>
                                <Field type='text' className='form-control' id='quantity' name='quantity'></Field>
                                <ErrorMessage name='quantity' component='span' className=' text-danger'></ErrorMessage>
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='description' className='form-label'>
                                    Description
                                </label>
                                <Field type='text' className='form-control' id='description' name='description'></Field>
                                <ErrorMessage name='description' component='span' className=' text-danger'></ErrorMessage>
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='price' className='form-label'>
                                    Price
                                </label>
                                <Field type='text' className='form-control' id='price' name='price'></Field>
                                <ErrorMessage name='price' component='span' className=' text-danger'></ErrorMessage>
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='category' className='form-label'>
                                    Category
                                </label>
                                <Field as="select" name="category" id="category">
                                    {categories.map((cate) => (
                                        <option value={cate.id}>{cate.name}</option>
                                    ))
                                    }
                                </Field>
                            </div>
                            {isSubmitting ?
                                <Dna
                                    visible={true}
                                    height="80"
                                    width="80"
                                    ariaLabel="dna-loading"
                                    wrapperStyle={{}}
                                    wrapperClass="dna-wrapper"
                                ></Dna>
                                :
                                <button type='submit' className='btn btn-primary'>Submit</button>
                            }
                            <ToastContainer/>
                        </Form>

                    </div>
                    )}
            </Formik>
        </>
    ): ""
}