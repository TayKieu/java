import logo from './logo.svg';
import './App.css';
import {ToastContainer} from "react-toastify";
import {Route, Routes} from "react-router-dom";
import {List} from "./component/List";
import {Create} from "./component/Create";

function App() {
  return (
      <>
        <Routes>
          <Route path="/" element={<List/>}></Route>
          <Route path="/create" element={<Create/>}></Route>
        </Routes>
        <ToastContainer/>
      </>
  );
}

export default App;
