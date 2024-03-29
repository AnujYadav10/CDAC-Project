import React from 'react'
import './Form.css'
import { Outlet,Link, Navigate} from 'react-router-dom'
import ManagerService from '../../services/ManagerService'
import {useState,useEffect} from 'react';
import { useNavigate } from 'react-router-dom';
import {useDispatch} from 'react-redux';
import managerlogin from '../../redux/action/loginaction'


const Form = ()=>{

    const [email,setemail] = useState('');
    const [password,setpassword] = useState('');   
    const navigate = useNavigate();  
    const dispatch=useDispatch();


    const Handlelogin = ()=>{
        if(email !== '' && password !== '')
        console.log(email,password);
        var man=ManagerService.getByName(email,password).then(response =>{
            console.log(JSON.stringify(response.data) + "and the email is" +  response.data.email);
            if(response.data.email==email && response.data.password == password)
            {
                console.log("dispatching id " + response.data.id)
                let action1=  managerlogin(response.data.id); 
                console.log(action1);
                dispatch(action1);
                navigate('/sprint');
            }
        });

    }

    return(
        <div>
            <div class="wrapper">
                <h1>Hello Again!</h1>
                <p>Welcome back you've been missed</p>
                    <form>
                    <input type="text" placeholder="Enter username" onChange={e=>setemail(e.target.value)}></input>
                        <input type="password" placeholder="Password" onChange={e=>setpassword(e.target.value)}></input>
                    </form>
                    
                    
                <button onClick={Handlelogin}>Sign in</button>
                <div class="not-member">
                Not a member?   <Link to="/home/register"> Register Now </Link>
                </div>
            </div>
        </div>
    )
}

export default Form;
