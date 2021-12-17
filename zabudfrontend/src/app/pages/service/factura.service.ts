import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import { GenericService } from "src/app/core/utils/genericService";
import { HandleHttpError } from "src/app/core/utils/HandleHttpError";
import { environment } from "src/environments/environment";
import { FacturaForm } from "../models/facturaPost";
import { Factura } from "../models/factura";

@Injectable()
export class FacturaService implements GenericService{
    url : string = `${environment.apiUrl}/factura`;
    constructor(
        private http : HttpClient
    ){}

    save(entity: FacturaForm) {
        return this.http.post(this.url, entity)
            .pipe(catchError(HandleHttpError));
    }
    getAll() {
        return this.http.get<Factura[]>(this.url)
            .pipe(catchError(HandleHttpError));
    }
    getById(id: number) {
        return this.http.get<Factura>(`${this.url}/${id}`)
            .pipe(catchError(HandleHttpError));
    }
    deleteById(id: number) {
        return this.http.delete(`${this.url}/${id}`)
            .pipe(catchError(HandleHttpError));
    }
}