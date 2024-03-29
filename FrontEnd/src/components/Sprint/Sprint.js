import React from 'react'
import { Outlet,Link, Navigate} from 'react-router-dom'
import ManagerService from '../../services/ManagerService'
import {useState,useEffect} from 'react';
import { useNavigate } from 'react-router-dom';
import '../Sprint/Sprint.css'
import Welcome from './welcome/Welcome';



const Sprint=()=>{
    return(
        <div className=".container" id="Sprint">
            <div className="container-fluid" id="Header">
                <h1 className='Heading'>Create and Manage Your sprints !!!</h1>
            </div>
            <Outlet></Outlet>
        </div>
    )
}
export default Sprint;