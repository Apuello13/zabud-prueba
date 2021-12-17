import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { HandleHttpError } from "src/app/core/utils/HandleHttpError";
import { environment } from "src/environments/environment";
import { Auth } from "../models/auth";
import { catchError } from "rxjs/operators";
import { Cajero } from "../models/cajero";
import { UserLogIn } from "src/app/core/models/userLogIn";

@Injectable()
export class AuthService{
    url : string = `${environment.apiUrl}/auth`;
    constructor(
        private http : HttpClient
    ){}

    login(auth : Auth){
        return this.http.post<UserLogIn>(`${this.url}/login`, auth)
            .pipe(catchError(HandleHttpError));
    }

    register(cajero : Cajero){
        return this.http.post<UserLogIn>(`${this.url}/register`, cajero)
            .pipe(catchError(HandleHttpError));
    }
}