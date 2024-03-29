
export const managemanagerid=(managerid = 0,action)=>{
    switch(action.type){
        case "managerlogin":
            return  parseFloat(action.payload.managerid)
        default:
            return managerid;
    }
}

// Reducer
export const sprint1Reducer = (state = [], action) => {
  switch (action.type) {
    case "ADD_SPRINT1":
      return [action.payload];
    default:
      return state;
  }
};

export default managemanagerid;

