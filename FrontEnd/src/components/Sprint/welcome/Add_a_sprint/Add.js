import '../Add_a_sprint/Add.css'
import React,{useState,useEffect} from 'react'
import Sprint from '../../../../services/Sprint1';
import Sprintservice from '../../../../services/Sprintservice'
import Manager from '../../../../services/Manager';
import {useDispatch} from 'react-redux';
import managerlogin from '../../../../redux/action/loginaction'
import { useSelector } from 'react-redux'
import { useNavigate } from 'react-router-dom';

const Add = (props)=>{
    let managerid=useSelector((state)=>state.managerid)
    const [show,setshow] = useState('');
    const[domain,setdom]= useState('');
    const[deadline,setdead]= useState('');
    const[priority,setprio]= useState('');
    const[no_of_employees,setemp]= useState('');
    const[changee,setmaneid]= useState('');
    const dispatch=useDispatch();
    const navigate = useNavigate();  


    const Handlesprint = ()=>{
        console.log("manager id is " + managerid);
        let sprint = new Sprint(domain,deadline,priority,no_of_employees,managerid);
        console.log(sprint);
        let manadded = Sprintservice.insertsprint(sprint).then((result)=>{
            console.log(result.data);
            if(result.data!==undefined)
            setshow('sprint has been added')
            var changee = props.change;
           }).catch((Error)=>{
            console.log(Error)
           }
           );
    }

    const nav = () =>{
        let action1=  managerlogin(managerid); 
            console.log(action1);
            dispatch(action1);
        navigate('/sprint');
    };

    return (
        <div>
            <div className="container-fluid" id='Innercontainer'>
                <div className='row align-items-start' id='row'>
                    <div className='col-2' id='Dashboard'>
                    <nav class="vertical-nav">
                      <ul>
                        <br></br>
                        <br></br>
                        <li><a href="http://localhost:3000/home">Logout</a></li>
                        <br></br>
                        <li><a href="http://localhost:3000/home">Home</a></li>
                        <br></br>
                        <li><a onClick={nav}>Back</a></li>
                        </ul>
                    </nav>

                    </div>
                    <div className="col-10" id='Sprint_space'>
                    <div class="wrapper">
                <h1>Hello Again!</h1>
                <p>Enter all your details</p>
                    <form>
                    <input type="text" placeholder="domain" onChange={e=>setdom(e.target.value)}></input>
                    <input type="text" placeholder="deadline" onChange={e=>setdead(e.target.value)}></input>
                    <input type="text" placeholder="priority" onChange={e=>setprio(e.target.value)}></input>
                    <input type="text" placeholder="no_of_employees" onChange={e=>setemp(e.target.value)}></input>
                    </form>
                    
                    
                <button onClick={Handlesprint}>Add Sprint</button>
                {show}
            </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Add;