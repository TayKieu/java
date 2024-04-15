import logo from './logo.svg';
import './App.css';
import {Route, Routes} from "react-router-dom";
import React from "react";
import {List} from "./component/List";
import {Create} from "./component/Create";
import {Update} from "./component/Update";
import {ToastContainer} from "react-toastify";

function App() {
  return (
      <>
        <Routes>
          <Route path="/" element={<List/>}></Route>
          <Route path="/create" element={<Create/>}></Route>
          <Route path="/update/:id" element={<Update/>}></Route>
        </Routes>
          <ToastContainer/>
      </>)
}

export default App;
