import logo from './logo.svg';
import './App.css';
import {NavLink, Route, Routes} from "react-router-dom";
import {Create} from "./component/book_management/Create";
import {List} from "./component/book_management/List";
import {Update} from "./component/book_management/Update";

function App() {
    return (
        <>
            <Routes>
                <Route path="/" element={<List/>}></Route>
                <Route path="/create" element={<Create/>}></Route>
                <Route path="/update/:id" element={<Update/>}></Route>
            </Routes>
        </>)

}
    export default App;
