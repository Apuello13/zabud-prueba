import { Injectable } from "@angular/core";
import { UserLogIn } from "../models/userLogIn";

const userKey : string = 'user';

@Injectable({ providedIn: 'root' })
export class UserService{

    saveUser(user : UserLogIn){
        sessionStorage.setItem(userKey, JSON.stringify(user));
    }

    getUser() : UserLogIn{
        return JSON.parse(sessionStorage.getItem(userKey));
    }

    isLoginUser() : boolean{
        return sessionStorage.getItem(userKey) ? true : false;
    }

    deleteUser(){
        sessionStorage.removeItem(userKey);
    }
}