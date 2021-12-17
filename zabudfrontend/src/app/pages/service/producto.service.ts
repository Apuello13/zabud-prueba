import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import { GenericService } from "src/app/core/utils/genericService";
import { HandleHttpError } from "src/app/core/utils/HandleHttpError";
import { environment } from "src/environments/environment";
import { Producto } from "../models/producto";

@Injectable()
export class ProductoService implements GenericService{
    url : string = `${environment.apiUrl}/producto`;
    constructor(
        private http : HttpClient
    ){}

    save(entity: Producto) {
        return this.http.post(this.url, entity)
            .pipe(catchError(HandleHttpError));
    }
    getAll() {
        return this.http.get<Producto[]>(this.url)
            .pipe(catchError(HandleHttpError));
    }
    getById(id: number) {
        return this.http.get<Producto>(`${this.url}/${id}`)
            .pipe(catchError(HandleHttpError));
    }
    deleteById(id: number) {
        return this.http.delete(`${this.url}/${id}`)
            .pipe(catchError(HandleHttpError));
    }
}