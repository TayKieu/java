
import {useIncreasement} from "./Add";
export function Counter1(){
    const [count, setCount] = useIncreasement(1)
    return(
        <>
            <h3>Count: {count}</h3>
            <button onClick={setCount}>Add 1</button>
        </>
    )
}