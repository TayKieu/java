import {Component} from "react";

class StudentInfoComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            students: [],
            form:{name: '',phone: '', email:''},
            isValid: false,
            indexSelected: -1
        }
    }
    handleChange = (event) =>{
        this.setState((state) =>{
            const form = state.form
            form[event.target.name] = event.target.value
            console.log(event.target.name)
            return {form}
        },() => this.checkInvalidForm())
    }
    handleSelect = (studentSelected, index) => {
        this.setState({
            form: JSON.parse(JSON.stringify(studentSelected)),
            indexSelected: index
        })
    }
    checkInvalidForm = () => {
        const { name, phone, email } = this.state.form
        const value = name && phone && email
        this.setState({
            isValid: value
        })
    }
    handleSubmit = () => {
        if(this.state.isValid){
            const newList = this.state.students
            if (this.state.indexSelected > -1) {
                newList.splice(this.state.indexSelected)
            } else {
                newList.push(this.state.form)
            }
            // newList.push()
            this.setState({students: newList, form: {name:"", phone:"",email:""},
            })
        }
    }
    render() {
        return(

                <div>
                    <h1>Student List</h1>
                    <div>
                        <label>Name: </label>
                        <input type={"text"} name="name"  onChange={this.handleChange} />
                    </div>
                    <div>
                        <label>Phone: </label>
                        <input type="number" name="phone"  onChange={this.handleChange} />
                    </div>
                    <div>
                        <label>Email: </label>
                        <input name="email"  onChange={this.handleChange} />
                    </div>
                    <button onClick={this.handleSubmit}>Submit</button>
                    <table border={1}>
                        <thead><tr>
                            <td>Name</td>
                            <td>phone</td>
                            <td>email</td>
                        </tr></thead>
                        <tbody>{this.state.students.map(student =>(
                            <tr>
                                <td>{student.name}</td>
                                <td>{student.phone}</td>
                                <td>{student.email}</td>
                            </tr>
                        ))}</tbody>
                    </table>
                </div>
        )

    }

}
export default StudentInfoComponent