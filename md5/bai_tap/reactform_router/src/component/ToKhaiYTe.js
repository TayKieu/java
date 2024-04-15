import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from 'yup'
import {toast, ToastContainer} from "react-toastify";
import {Dna} from "react-loader-spinner";
export function ToKhaiYTe(){
    return(
        <>
        <Formik initialValues={{
            name:'',
            CMND:'',
            yob:'',
            gender:'0',
            nationality:'',
            company:'',
            position:'',
            province:'',
            district:'',
            phone_number:'',
            email:''
        }}      validationSchema={Yup.object({
            name:Yup.string().required().matches(/[a-z,A-Z]+$/),
            CMND: Yup.string().required().matches(/^048_[0-9]+$/),
            yob:Yup.string().required().min(1900),
            nationality:Yup.string().required(),
            province:Yup.string().required(),
            district:Yup.string().required(),
            phone_number:Yup.string().required(),
            email:Yup.string("Invalid email").required().matches(/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/)

        })}
                onSubmit={(values,{setSubmitting})=>{
                    setTimeout(()=>{
                        console.log(values)
                        //call api
                        setSubmitting(false)
                        toast("Submited")
                    },1000)
                }}>
            {({isSubmitting})=>(
                <div className='container'>
                    <h1>Tờ khai y tế</h1>
                    <Form>
                        <div className='mb-3'>
                            <label htmlFor='name' className='form-label'>
                                Họ tên
                            </label>
                            <Field type='text' className='form-control' id='name' name='name'></Field>
                            <ErrorMessage name='name' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='CMND' className='form-label'>
                                Hộ chiếu/CMND
                            </label>
                            <Field type='text' className='form-control' id='CMND' name='CMND'></Field>
                            <ErrorMessage name='CMND' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='yob' className='form-label'>
                                Năm sinh
                            </label>
                            <Field type='text' className='form-control' id='yob' name='yob'></Field>
                            <ErrorMessage name='yob' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label  className='form-label'>
                                Giới tính
                            </label>
                            <div className="form-check form-check-inline">
                                <Field className="form-check-input" type="radio" id="inlineRadio1"
                                       value="1"
                                       name="gender"
                                >
                                </Field>
                                <label className="form-check-label" htmlFor="inlineRadio1">Nam</label>
                            </div>
                            <div className="form-check form-check-inline">
                                <Field className="form-check-input" type="radio" id="inlineRadio2"
                                       value="0"
                                       name="gender"
                                >
                                </Field>
                                <label className="form-check-label" htmlFor="inlineRadio2">Nữ</label>
                            </div>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='nationality' className='form-label'>
                                Quốc tịch
                            </label>
                            <Field type='text' className='form-control' id='nationality' name='nationality'></Field>
                            <ErrorMessage name='nationality' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='company' className='form-label'>
                                Công ty làm việc
                            </label>
                            <Field type='text' className='form-control' id='company' name='company'></Field>
                            <ErrorMessage name='company' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='position' className='form-label'>
                                Bộ phận làm việc
                            </label>
                            <Field type='text' className='form-control' id='position' name='position'></Field>
                            <ErrorMessage name='position' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label  className='form-label'>
                                Có thẻ bảo hiểm y ế
                            </label>
                            <Field type={"checkbox"}/>
                        </div>
                        <h2>Địa chỉ liên lạc tại Việt Nam</h2>
                        <div className='mb-3'>
                            <label htmlFor='province' className='form-label'>
                                TỈnh thành
                            </label>
                            <Field type='text' className='form-control' id='province' name='province'></Field>
                            <ErrorMessage name='province' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='district' className='form-label'>
                                Quận/huyện
                            </label>
                            <Field type='text' className='form-control' id='district' name='district'></Field>
                            <ErrorMessage name='district' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='phone_number' className='form-label'>
                                Điện thoại
                            </label>
                            <Field type='text' className='form-control' id='phone_number' name='phone_number'></Field>
                            <ErrorMessage name='phone_number' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='email' className='form-label'>
                                Email
                            </label>
                            <Field type='text' className='form-control' id='email' name='email'></Field>
                            <ErrorMessage name='email' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        {isSubmitting ?
                            <Dna
                                visible={true}
                                height="80"
                                width="80"
                                ariaLabel="dna-loading"
                                wrapperStyle={{}}
                                wrapperClass="dna-wrapper"></Dna>
                            :<button type='submit' className='btn btn-primary'>Submit</button>
                        }
                    </Form>
                </div>
            )}

        </Formik>
            <ToastContainer/>
        </>
    )
}