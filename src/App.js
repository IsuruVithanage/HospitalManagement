import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import NavBar from "./layout/NavBar";
import Home from "./pages/Home";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom"
import AddUser from "./User/AddUser";
import UpdateUser from "./User/UpdateUser";

function App() {
    return (
        <div className="App">
            <Router>
                <NavBar/>
                <Routes>
                    <Route path={"/"} element={<Home/>}/>
                    <Route path={"/adduser"} element={<AddUser/>}/>
                    <Route path={`/update/:id`} element={<UpdateUser/>}/>
                </Routes>
            </Router>
        </div>
    );
}

export default App;
