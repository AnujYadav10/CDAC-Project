import '../welcome/Welcome.css'
import sprintservice from '../../../services/Sprintservice'
import React,{useState,useEffect} from 'react'
import Sprint1 from '../../../services/Sprint1'
import { Outlet,Link} from 'react-router-dom'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { useSelector } from 'react-redux'
import {useDispatch} from 'react-redux';
import addSprint from '../../../redux/action/addSprint1'


const Welcome = ()=>{

  const [sparray,setsparray] = useState([]);
  const [change,setchng] = useState(0);
  //const [show,setsh] = useState('');
let managerid=useSelector((state)=>state.managerid);
  const [pid,setpid] = useState();
  const dispatch=useDispatch();
  const navigate = useNavigate();  

  useEffect(()=>{
    console.log("it works with id  " + managerid);
    sprintservice.getAllsprints(managerid).then(Response => {
      console.log(Response.data);
      setsparray(Response.data);
    })
  },[change])

  const HandleView = ()=>{
    navigate('/sprint/sprintview');
  };

  const Handleadd = () =>{
    navigate('/sprint/addform');
  };

  const deletesprint = (id) =>{
    sprintservice.deletesprint(id).then(Response =>{
      console.log(JSON.stringify(Response.data));
      console.log(change);
      setchng(Date.now());
      console.log(change);
      }).catch(Error =>{
    console.log(Error)
    });
  };

  /*
  const updatesprint = (sprint) =>{
    sprintservice.updatesprint(sprint).then(Response =>{
      setsh(Response.data)
      }).catch(Error =>{
      console.log(Error)
      });
  } */

  const update = (sprint) =>{
    let action2=  addSprint(sprint); 
    console.log(action2);
    dispatch(action2);
    navigate('/sprint/updateform');
  }

    return (
        <div>
            <div className="container-fluid" id='Innercontainer' style={{ height: '100%' }}>
                <div className='row align-items-start' id='row'>
                    <div className='col-2' id='Dashboard' style={{ height: '621.1' }}>
                    <nav class="vertical-nav">
                      <ul>
                        <li><button><a onClick={Handleadd} > Add a Sprint</a></button></li>
                        <br></br>
                        <br></br>
                        <li><a href="http://localhost:3000/home">Logout</a></li>
                        <br></br>
                        <li><a href="http://localhost:3000/home">Home</a></li>
                        <br></br>
                        <li><a href="http://localhost:3000/home">Back</a></li>
                        </ul>
                    </nav>
                    </div>
                    <div className="col-10" id='Sprint_space'>
                      <h2>Welcome Manager name !</h2>
                      <h6> Here are your sprints , if you dont have one then create one by clicking add a sprint</h6>
                      <br></br>
                      <br></br>
                      <div className='container-fluid' id='sprintcontainer'>
                        <div className='row' style={{ height: '500px' }}> 
                        {sparray.map((sprint) => (
                          <div className='col-3' id='spintcolumn' key={sprint.id} style={{ height: '500px' }}>
                              <div >
                              <p>{sprint.name}</p>
                              {/* Other product details */}
                              <ul>
                                <li className='inner'>Domain :{sprint.domain}</li>
                                <br></br>
                                <li className='inner'>Priority :{sprint.priority}</li>
                                <br></br>
                                <li className='inner'>Deadline :{sprint.last_date_to_submit}</li>
                                <br></br>
                                <li className='inner'>No of Employees :{sprint.number_emp}</li>
                                <br></br>
                                <div><button onClick={HandleView}>View</button></div>&nbsp;&nbsp;&nbsp;&nbsp;
                                <div><button onClick={()=>{update(sprint)}}>Update</button></div>
                                <div><button type="button" name="btn" id="delete" className="btn btn-danger" onClick={()=>{deletesprint(sprint.id)}}>Delete</button></div>

                              </ul>
                              </div>
                          </div>
                          ))}
                        </div>

                      </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Welcome;