import './App.css';
import {BrowserRouter as Router,Route, Routes} from 'react-router-dom'
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import AddEmployeeComponent from './components/AddEmployeeComponent';

function App() {
  return (
    <div>
  <Router>
  <HeaderComponent/>
  <div className='container'>
    <Routes>
    <Route exact path='/' element={< ListEmployeeComponent />}></Route>
      <Route path="/addEmployee" element={<AddEmployeeComponent/>}></Route>
      <Route path = "/employees" element= {< ListEmployeeComponent />}></Route>
        <Route path = "/edit-employee/:id" element= {<AddEmployeeComponent/>}></Route>    
           </Routes>
  </div>
 <FooterComponent/> 
      </Router>
   
    </div>
  );
} 

export default App;
