import { createStore } from "redux";
import {sprintmanagerstore} from './reducers/myreducers'
const store=createStore(sprintmanagerstore,{},
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

export default store;
    