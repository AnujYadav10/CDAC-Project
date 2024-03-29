import '../Sprint_View/SprintView.css'
import "bootstrap/dist/css/bootstrap.min.css"
import Sprint_Entries from '../../../services/Sprint_Entries'
import { Outlet, useNavigate } from 'react-router-dom';
import React,{useState,useEffect} from 'react'
import EntryDetails from './Entry_Details/EntryDetails';
import './Entry_Details/EntryDetails.css'


const SprintView = ()=>{

    const [sprintentries,setentries] = useState([]);
    const navigate = useNavigate(); 
  
    useEffect(()=>{
      const sprintarray = [new Sprint_Entries('Entry 1','accounting',10,'This is a trial description for entry one'),
      new Sprint_Entries('Entry 1','accounting',10,'This is a trial description for entry one') 
      ,new Sprint_Entries('Entry 1','accounting',10,'This is a trial description for entry one')];
      console.log(sprintarray);
      setentries(sprintarray);
    },[]);
  
    const HandleView = ()=>{
      navigate('/sprint/sprintview/sprintentry');
    };
 
    return (
        <div>
            <div className="container-fluid" id='Innercontainer'>
                <div className='row align-items-start' id='row'>
                    <div className='col-2' id='Dashboard'>
                    <nav class="vertical-nav">
                      <ul>
                        <li><button>Add a Entry</button></li>
                        <br></br>
                        <br></br>
                        <li><a href="#">Search</a></li>
                        <br></br>
                        <li><a href="#">Home</a></li>
                        <br></br>
                        <li><a href="#">Back</a></li>
                        </ul>
                    </nav>
                    </div>
                    <div className="col-10" id='Sprint_space'>
                        <div className='row' id='sprint_views'>
                            <h3>This section will show sprint in more detail</h3>
                        </div>
                        <div className='row' id='show_entries'>
                            <div className='col-6'>
                                {sprintentries.map((entry) =>(
                                    <div className='row' style={{ height: '5%',width: '80%', margin : '8%',padding : '0%',borderWidth : '0%', fontSize : '10px', backgroundColor : 'antiquewhite', border: '2px solid #676676' }}>
                                        <p>{entry.description}</p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <div style={{marginLeft : 'auto'}}>
                                        <button style={{ height: '5%', width: '15%' , color : '#676676' , border : '5px' }}>Delete</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button onClick={HandleView} style={{ height: '5%', width: '15%', color : '#676676', border : '5px' }}>View</button>
                                        </div>
                                    </div>
                                ))}
                            </div>
                            <div className='col-6'>
                                <Outlet></Outlet>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default SprintView;