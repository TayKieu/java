import {Component} from "react";
class ToDoList extends Component{
    constructor(props) {
        super(props);
        this.state ={
            list: [],
            item: ''
        }
    }
    handleChange = (event) =>{
        this.setState({item: event.target.value})
    }
    handleAddItem = () =>{
        if (this.state.item !== '') {
            this.setState({item:this.state.item})
            this.setState({list:[this.state.item, ...this.state.list]})
        }
    }

    render() {
        return (
            <div>
                <input type={"text"} onChange={(event => this.handleChange(event))} value={this.state.item}/>
                <button onClick={this.handleAddItem}>Add</button>
                <table>
                    {this.state.list.map(item=>(
                        <tr>
                            <td>{item}</td>
                        </tr>
                    ))}
                </table>
            </div>
        );
    }
}
export default ToDoList