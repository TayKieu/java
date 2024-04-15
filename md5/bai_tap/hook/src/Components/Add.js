import { useState} from "react";
export function useIncreasement(addAmount){
    const [count,setCount] = useState(0)
    function increase(){
        setCount(prevState => prevState + addAmount)
    }
    return(
        [count, increase]
    )

}
