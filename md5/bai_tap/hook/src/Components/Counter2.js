import {useIncreasement} from "./Add";
export function Counter2(){
    const [count, setCount] = useIncreasement(2)
    return(
        <>
            <h3>Count: {count}</h3>
            <button onClick={setCount}>Add 2</button>
        </>
    )
}