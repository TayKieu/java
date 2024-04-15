
import axios from "axios";

export const findAll = async () =>{
    try{
        const result = await axios.get("http://localhost:8080/products")
        return result.data
    }catch (e){
        console.log(e)
    }
}
export const save = async (newProduct) =>{
    try{
        await axios.post('http://localhost:8080/products' , newProduct)
    }catch (e){
        console.log(e)}
}
export const deleteById = async(id)=>{
    try{
        await axios.delete('http://localhost:8080/products/'+id)
    }catch (e){
        console.log(e)}
}
export const findById = async(id)=>{
    try{
        const result = await axios.get('http://localhost:8080/products/' +id)
        return result.data
    }catch (e){
        console.log(e)}
}
export const edit = async(id, productEdit)=>{
    try{
        await axios.put(`http://localhost:8080/products/`+id,productEdit)
    }catch (e) {
        console.log(e)
    }
}
export const findByKey = async(key)=>{
    try{
        const result =await axios.get('http://localhost:8080/products')
        return result.data.filter((product)=>product.name.includes(key) || product.description.includes(key) )
    }catch (e){
        console.log(e)}
}