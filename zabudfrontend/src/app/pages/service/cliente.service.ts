import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import { GenericService } from "src/app/core/utils/genericService";
import { HandleHttpError } from "src/app/core/utils/HandleHttpError";
import { environment } from "src/environments/environment";
import { Cliente } from "../models/cliente";

@Injectable()
export class ClienteService implements GenericService{
    url : string = `${environment.apiUrl}/cliente`;
    constructor(
        private http : HttpClient
    ){}

    save(entity: Cliente) {
        return this.http.post(this.url, entity)
            .pipe(catchError(HandleHttpError));
    }

    getAll() {
        return this.http.get<Cliente[]>(this.url)
            .pipe(catchError(HandleHttpError));
    }
    getById(id: number) {
        return this.http.get<Cliente>(`${this.url}/${id}`)
            .pipe(catchError(HandleHttpError));
    }

    getByNumeroDocumento(numeroDocumento : string){
        return this.http.get<Cliente>(`${this.url}/numeroDocumento/${numeroDocumento}`)
            .pipe(catchError(HandleHttpError));
    }

    deleteById(id: number) {
        return this.http.delete(`${this.url}/${id}`)
            .pipe(catchError(HandleHttpError));
    }
    
}