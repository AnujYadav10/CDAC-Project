import React,{useState,useEffect} from 'react'
import Employee from '../../../../services/Employees'


const EntryDetails = ()=>{

    const [employees,addemployee] = useState([]);
  
    useEffect(()=>{
      const sprintarray = [new Employee('vaibhav'), new Employee('Laksh'), new Employee('Abhishek')];
      console.log(sprintarray);
      addemployee(sprintarray);
    },[]);
  



    return(
        <div>
            <div className="container-fluid" id="Details">
                <div className="row" style={{height : '30%',margin : '2%'}}>
                    <h3 style={{fontSize : '15px'}}>This section has more information about that specific entry<br></br><br></br> Employees list</h3>
                </div>

                <div className="row">
                {employees.map((emp) =>(
                    <div className='row' style={{ height: '45px',width: '50%', margin : '2%', marginLeft : '5%', padding : '0%',borderWidth : '0%', fontSize : '10px', backgroundColor : 'white', border: '2px solid #676676' }}>
                        <h4 style={{fontSize : '15px'}}>{emp.name}</h4>
                        <div style={{marginLeft : 'auto'}}>
                        <button style={{ height: '5%', width: '45%' , color : '#676676' , border : '5px' }}>Delete</button>
                        </div>
                        </div>
                        ))}
                </div>

            </div>
        </div>
    )
}

export default EntryDetails;