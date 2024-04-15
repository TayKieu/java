import logo from './logo.svg';
import './App.css';
import Calculate from "./components/calculate";
import StudentInfoComponent from "./components/StudentInfoComponent";
import ToDoList from "./components/ToDoList";

function App() {
  return (
    <div className="App">
      {/*<Calculate></Calculate>*/}
        <StudentInfoComponent></StudentInfoComponent>
      {/*  <ToDoList></ToDoList>*/}
    </div>
  );
}

export default App;
