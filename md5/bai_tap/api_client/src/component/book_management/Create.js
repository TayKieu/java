import {useNavigate} from "react-router-dom";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from 'yup'
import * as bm_service from "../../service/Book_management_service"
import {toast} from "react-toastify";
import {Dna} from "react-loader-spinner";
export function Create() {
    const navigate = useNavigate()
    return (
        <>
            <Formik initialValues={{
                id: 0,
                title: "",
                quantity: 0
            }}
                    validationSchema={Yup.object({
                        title: Yup.string().required()
                    })}
                    onSubmit={(values, {setSubmitting}) => {
                        const create = async() =>{
                            setSubmitting(false)
                            await bm_service.save(values)
                            toast(`New book with title ${values.title} was added`)
                            navigate("/")
                        }
                        create()
                    }}>
                {({isSubmitting}) => (
                    <div className='container'>
                        <h1>Add new book</h1>
                        <Form>
                            <div className='mb-3'>
                                <label htmlFor='title' className='form-label'>
                                    Title
                                </label>
                                <Field type='text' className='form-control' id='title' name='title'></Field>
                                <ErrorMessage name='title' component='span' className=' text-danger'></ErrorMessage>
                            </div>
                            <div className='mb-3'>
                                <label htmlFor='quantity' className='form-label'>
                                    Quantity
                                </label>
                                <Field type='text' className='form-control' id='quantity' name='quantity'></Field>
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
            )
            }