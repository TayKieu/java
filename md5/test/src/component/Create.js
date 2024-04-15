import {useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import * as category_service from "../service/category_service";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import * as product_service from "../service/product_service";
import {toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import {Dna} from "react-loader-spinner";
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
                id: "",
                name: "",
                quantity: 1,
                description: "",
                category: 0,
                price: 0,
                date: ""
            }
        } validationSchema={Yup.object(
            {
                id: Yup.string().required().matches(/^PROD-[0-9]{4}$/),
                name: Yup.string().required(),
                quantity: Yup.number().required().min(1),
                description: Yup.string().required(),
                price: Yup.number().required(),
                date: Yup.date().required()
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
                            <label htmlFor='id' className='form-label'>
                                ID
                            </label>
                            <Field type='text' className='form-control' id='id' name='id'></Field>
                            <ErrorMessage name='id' component='span' className=' text-danger'></ErrorMessage>
                        </div>
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
                        <div className='mb-3'>
                            <label htmlFor='date' className='form-label'>
                                Date
                            </label>
                            <Field type='date'  className='form-date'  id='date' name='date' ></Field>
                            <ErrorMessage name='date' component='span' className=' text-danger'></ErrorMessage>
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