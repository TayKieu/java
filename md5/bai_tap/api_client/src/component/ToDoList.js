import {useNavigate} from "react-router-dom";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from 'yup'
import * as listService from "../service/ToDoService"
import {toast, ToastContainer} from "react-toastify";
import {Dna} from "react-loader-spinner";
import {useEffect, useState} from "react";


export function Create() {
    const navigate = useNavigate()
    const [lists, setLists] = useState([])
    useEffect(() => {
            const fetchApi = async () => {
                const result = await listService.findAll()
                setLists(result)
            }
            fetchApi()
        }, [lists]

    )
    return (
        <>
            <Formik
                initialValues={
                    {name: ""}
                }
                validationSchema={
                    Yup.object({
                        name: Yup.string().required()
                    })
                }
                onSubmit={(values, {setSubmitting}) => {
                    const create = async () => {
                        console.log("da submit")
                        await listService.save(values)
                        setSubmitting(false)
                        // toast('new work added')
                        // navigate("/")
                        // window.location.reload()
                    }
                    create()
                }}>
                {({isSubmitting}) => (
                    <div className='container'>
                        <h1>To do List</h1>
                        <Form>
                            <div className='mb-3'>
                                <Field type='text' className='form-control' name='name'></Field>
                                <ErrorMessage name='name' component='span' className=' text-danger'></ErrorMessage>
                            </div>
                            {isSubmitting
                                ?
                                <Dna
                                    visible={true}
                                    height="80"
                                    width="80"
                                    ariaLabel="dna-loading"
                                    wrapperStyle={{}}
                                    wrapperClass="dna-wrapper"
                                >

                                </Dna>
                                :
                                <button type="submit" className='btn btn-primary'>Submit</button>
                            }
                        </Form>
                    </div>

                )}
            </Formik>
            <ToastContainer></ToastContainer>
            <ul>
                {
                    lists.map((li) => (
                        <li>{li.name}</li>
                    ))
                }
            </ul>
        </>
    )
}

