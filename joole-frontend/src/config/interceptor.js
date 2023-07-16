import axios from 'axios';
import {loadUser} from '../utilities/local-storage'


export const setupAxiosInterceptor = (store, pathname) =>{
    axios.interceptors.request.use(
        config => {
            const user = loadUser();
            console.log("HERE I AM INSIDE INTERCEPTOR  user: ", user);
            console.log("HERE I AM INSIDE INTERCEPTOR  user:", pathname);
            if(user && pathname!=="/login" && pathname!=="/signup"){
                
                const token = user.jwt;
                console.log("HERE I AM INSIDE INTERCEPTOR", token);
                config.headers['Authorization'] = 'Bearer ' + token;
            }
            config.headers['Content-Type'] = 'application/json';
            return config;
        },
        error => {
            if (error.response.status === 401 || error.response.status === 403) {
                //store.dispatch(logoutUser());
              }
            Promise.reject(error);
        }
    );
};

export default axios;