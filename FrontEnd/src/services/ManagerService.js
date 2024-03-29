import Manager from './Manager'
import axios from 'axios';
const baseUrl="http://localhost:7070"

class ManagerService{
    constructor(){
        this.manarr=[new Manager('vaibhav','Pune',500000,'consultant','1234'),
        new Manager('Abhishek','Pune',700000,'manager','2345'),
        new Manager('Laksh','Satara',600000,'lead','3456')];
    }
    getByName(email,password){
        console.log(email + "  " + baseUrl + 'manager' +email) ;
        if(email!=undefined && password!=undefined){
       return axios.get(baseUrl+'/manager/'+ email);
        }
    }


    insertManager(manager){
        console.log("in service add" + manager)
       return axios.post(baseUrl +'/manager', manager, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
    //,{header:{"content-type":"application/json",autherization:"bearer"+<localStorage.jwttoken>}})
    }

}

export default new ManagerService();