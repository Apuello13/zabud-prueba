import { HttpErrorResponse } from "@angular/common/http";
import { throwError } from "rxjs";

export function HandleHttpError(error : HttpErrorResponse){
    if(error.error){
        return throwError(error.error['mensaje']);
    }else{
        return throwError('Upps, algo ha salido mal');
    }
}