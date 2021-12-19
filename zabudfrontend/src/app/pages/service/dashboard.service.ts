import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import { HandleHttpError } from "src/app/core/utils/HandleHttpError";
import { environment } from "src/environments/environment";
import { Dashboard } from "../models/dashboard";

@Injectable()
export class DashboardService{
    url : string = `${environment.apiUrl}/dashboard`;
    constructor(private http : HttpClient){}

    getDashboard(){
        return this.http.get<Dashboard>(this.url)
            .pipe(catchError(HandleHttpError));
    }
}