import axios from "axios";

export const findAllCategories = async ()=>{
    try{
        const result = await axios.get("http://localhost:8082/categories")
        return result.data
    }catch (e){
        console.log(e)}
}