import {Component} from "react";
import {getValue} from "@testing-library/user-event/dist/utils";
class Calculate extends Component{
    constructor(props) {
        super(props);
        this.state={
            valueA: '',
            valueB: '',
            res:''
        }
    }
    inputValueA = (event)=>{this.setState({valueA: event.target.value})}
    inputValueB = (event)=>{this.setState({valueB: event.target.value})}


    handlePlus = () =>{
        return (
           this.setState({res: parseInt(this.state.valueA) + parseInt(this.state.valueB)})
        )
    }
    handleMinus = () =>{
        return (
            this.setState({res:parseInt(this.state.valueA) - parseInt(this.state.valueB)})
        )
    }
    handleMulti = () =>{
        return (
            this.setState({res:parseInt(this.state.valueA) * parseInt(this.state.valueB)})
        )
    }
    handleDivide = () =>{
        return (
            this.setState({res:parseInt(this.state.valueA) / parseInt(this.state.valueB)})
        )
    }

    render() {
        return (
            <div>
                <input type={"text"} onChange={(valueA => this.inputValueA(valueA))} value={this.state.valueA} />
                <input type={"text"} onChange={(valueB => this.inputValueB(valueB))} value={this.state.valueB}/>
                <p>result: <span>{this.state.res} </span></p>
                <button onClick={this.handlePlus}>+</button>
                <button onClick={this.handleMinus}>-</button>
                <button onClick={this.handleMulti}>x</button>
                <button onClick={this.handleDivide}>/</button>
            </div>
        );
    }
}
export default Calculate