import {useEffect, useState} from "react";
import * as bm_service from "../../service/Book_management_service"
import {useNavigate} from "react-router-dom";
import {useParams} from "react-router";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import {Dna} from "react-loader-spinner";

export function Update() {
    const {id} = useParams()
    const [bookEdit, setBookEdit] = useState({
        id: '',
        title: '',
        quantity: ''
    })
    const navigate = useNavigate()
    useEffect(() => {
        const findById = async () => {
            const result = await bm_service.findById(id)
            setBookEdit(result)
            console.log(result)
        }
        findById()
    }, [])
    return bookEdit.title !== "" ? (
        <>
            <Formik initialValues={{
                id: bookEdit.id,
                title: bookEdit.title,
                quantity: bookEdit.quantity
            }}
                    validationSchema={Yup.object({
                        title: Yup.string().required()
                    })}
                    onSubmit={(values, {setSubmitting}) => {
                        const edit = async () => {
                            setSubmitting(false)
                            await bm_service.edit(id, values)
                            navigate("/")
                        }
                        edit()
                    }}>
                {({isSubmitting}) => (
                    <div className='container'>
                        <h1>Add new book</h1>
                        <Form>
                            <div className='mb-3'>
                                <label htmlFor='title' className='form-label'>
                                    Title
                                </label>
                                <Field type='text' className='form-control' id='title'
                                       name='title'></Field>
                                <ErrorMessage name='title' component='span' className=' text-danger'></ErrorMessage>
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='quantity' className='form-label'>
                                    Quantity
                                </label>
                                <Field type='text' className='form-control' id='quantity'
                                       name='quantity'></Field>
                                <ErrorMessage name='quantity' component='span' className=' text-danger'></ErrorMessage>
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
        </>

    ): " "
}