import Sprint1 from './Sprint1'
import axios from 'axios';
const baseUrl="http://localhost:7070"

class Sprintservice{
    
    constructor(){
        this.sprintarr=[new Sprint1('Marketing','Sales',3,'11/3/2024',15,20),
        new Sprint1('Budget_Planning','Finance',2,'11/3/2024',15,20),
        new Sprint1('Hiring','HR',1,'11/3/2024',15,20)];
    }
    getAllsprints(manid){
        console.log(manid);
       return axios.get(baseUrl + "/sprint" + "/manager/" + manid);
    }


    insertsprint(sprint){
        console.log("in service add" + JSON.stringify(sprint))
       return axios.post(baseUrl +'/sprint', sprint, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
    //,{header:{"content-type":"application/json",autherization:"bearer"+<localStorage.jwttoken>}})
    }

    deletesprint(pid){
        return axios.delete(baseUrl+"/sprint/"+pid)
     }

    updateSprint(sprint, id) {
        console.log(sprint);
        return axios.put(baseUrl + "/sprint/" + id, sprint, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
    }
    

}

export default new Sprintservice();