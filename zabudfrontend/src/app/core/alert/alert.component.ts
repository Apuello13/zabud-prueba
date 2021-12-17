import { Component } from "@angular/core";
import { Subscription } from "rxjs";
import { AlertService } from "../service/alert.service";

@Component({
    selector: 'app-alert',
    templateUrl: './alert.component.html'
})
export class AlertComponent{
    message : any = { class: 'bg-success', text: '' };
    private subscription: Subscription;
    constructor(private _alert : AlertService){}

    ngOnInit(){
        this.subscription = this._alert.getAlert()
            .subscribe(alert => {
                this.message = alert
                this._alert.showAlert()
            })
    }

    ngOnDestroy(){
        this.subscription.unsubscribe();
    }
}