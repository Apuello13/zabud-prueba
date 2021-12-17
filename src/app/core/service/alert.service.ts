import { Injectable } from "@angular/core";
import { Observable, Subject } from "rxjs";

//JQuery
declare var $ : any;

@Injectable({ providedIn: 'root' })
export class AlertService{
    private message$: Subject<any> = new Subject<any>();

    getAlert() : Observable<string>{
        return this.message$.asObservable();
    }

    success(message : string){
        this.message$.next({ class: 'bg-success', text: message });
    }

    error(message : string){
        this.message$.next({ class: 'bg-danger', text: message });
    }

    info(message : string){
        this.message$.next({ class: 'bg-primary', text: message });
    }

    showAlert(){
        $('.toast').toast('show');
    }
}