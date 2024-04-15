import logo from './logo.svg';
import './App.css';

function fibonacci(n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

function getFiboList(length) {
    let fib = []
    for (let i = 0; i < length; i++) {
        fib[i] = fibonacci(i)
    }
    return fib
}

function calculateFibonacciSum(length) {
    let sum = 0;
    for (let i = 0; i < length; i++) {
        sum += fibonacci(i);
    }
    return sum;
}
const sequenceLength = 15;
const fiboList = getFiboList(sequenceLength)

 export default function Result(){
     return(
         fiboList.map(element => <p>{element}</p>),
         calculateFibonacciSum(sequenceLength)
     )
 }


