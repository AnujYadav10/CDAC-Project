import { combineReducers} from 'redux';
import managerlogin from './Sprintmanagerreducer'
import { sprint1Reducer } from './Sprintmanagerreducer';
export const sprintmanagerstore=combineReducers({
    managerid:managerlogin,
    sprint1: sprint1Reducer
})