import React,{useState,useEffect} from 'react'
import Sprint from '../../../services/Sprint1';
import Sprintservice from '../../../services/Sprintservice'
import Manager from '../../../services/Manager';
import {useDispatch} from 'react-redux';
import managerlogin from '../../../redux/action/loginaction'
import { useSelector } from 'react-redux'
import '../Update/update.css'
import { useNavigate } from 'react-router-dom';

const Update = (props)=>{
    let sprint3=useSelector((state)=>state.sprint1);
    let managerid=useSelector((state)=>state.managerid);
    const [show,setshow] = useState('');
    const[domain,setdom]= useState('');
    const[deadline,setdead]= useState('');
    const[priority,setprio]= useState('');
    const[no_of_employees,setemp]= useState('');
    const[changee,setmaneid]= useState('');
    const dispatch=useDispatch();
    const navigate = useNavigate();  

    useEffect(()=>{
        console.log("it works with sprint and manger   " + JSON.stringify(sprint3) +managerid);
        setdom(sprint3[0].domain);
        setdead(sprint3[0].last_date_to_submit);
        setprio(sprint3[0].priority);
        setemp(sprint3[0].number_emp);
      },[])

    const Handlesprint = ()=>{
        console.log("sprint is " + sprint3);
        let sprint = new Sprint(domain,deadline,priority,no_of_employees,managerid);
        console.log(sprint);
        let manadded = Sprintservice.updateSprint(sprint,sprint3[0].id).then((result)=>{
            console.log(result.data);
            if(result.data!==undefined)
            setshow('sprint has been updated')
            var changee = props.change;
           }).catch((Error)=>{
            console.log(Error)
           }
           );
    }

    const nav = () =>{
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
                <p>Update all your details</p>
                    <form>
                    <input type="text"  value={domain} onChange={e=>setdom(e.target.value)}></input>
                    <input type="text"  value={deadline} onChange={e=>setdead(e.target.value)}></input>
                    <input type="text"  value={priority} onChange={e=>setprio(e.target.value)}></input>
                    <input type="text"  value={no_of_employees} onChange={e=>setemp(e.target.value)}></input>
                    </form>
                    
                    
                <button onClick={Handlesprint}>update Sprint</button>
                {show}
            </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Update;