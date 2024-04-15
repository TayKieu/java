import axios from "axios";
export const findAll = async ()=>{
    try{
        const result = await axios.get('http://localhost:8080/lists')
        return result.data
    }catch (e){
        console.log(e)}
}
export const save = async (li)=>{
    try{
        const  result = await axios.post('http://localhost:8080/lists',li)
    }catch (e){
        console.log(e)}
}