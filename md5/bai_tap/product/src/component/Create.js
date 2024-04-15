import {useNavigate} from "react-router-dom";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import * as product_service from "../service/product_service"
import * as category_service from "../service/category_service"
import {toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import {Dna} from "react-loader-spinner";
import {useEffect, useState} from "react";

export function Create() {
    const navigate = useNavigate()

    const [categories, setCategories] = useState([])

    useEffect(() => {
        const findAllCate = async () => {
            const res = await category_service.findAllCategories()
            setCategories(res)
        }
        findAllCate()
    }, [])

    return (
        <Formik initialValues={
            {
                id: 0,
                name: "",
                quantity: 0,
                description: "",
                category: 0,
                price: 0
            }
        } validationSchema={Yup.object(
            {
                name: Yup.string().required(),
                quantity: Yup.number().required(),
                description: Yup.string().required(),
                price: Yup.number().required()
                // name: Yup.string()
                //     .required("Tên không được để trống")
                //     .matches(/^[A-Za-z ]{3,100}$/, "Tên không đúng định dạng"),
                // age: Yup.number()
                //     .min(18)
            }
        )}
                onSubmit={(values, {setSubmitting}) => {
                    const create = async () => {
                        setSubmitting(false)
                        await product_service.save(values)
                        toast('🦄 New product was added')
                        navigate("/")
                    }
                    create()
                }}>
            {({isSubmitting}) => (
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
                    </Form>

                </div>
            )}
        </Formik>
    )
}