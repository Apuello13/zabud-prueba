import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { NgxSpinnerService } from "ngx-spinner";
import { Observable } from "rxjs";
import { finalize } from 'rxjs/operators';

@Injectable()
export class InterceptorService implements HttpInterceptor{
    constructor(private _spinner : NgxSpinnerService){}

    intercept(request: HttpRequest<any>, next: HttpHandler) : Observable<HttpEvent<any>>{
        this._spinner.show();
        return next.handle(request).pipe(
            finalize(() => {
                this._spinner.hide();
            })
        )
    }
}