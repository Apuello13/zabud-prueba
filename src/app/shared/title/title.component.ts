import { Component, Input } from "@angular/core";

@Component({
    selector: 'app-shared-title',
    templateUrl: './title.component.html'
})
export class TitleComponent{
    @Input() title : string = '';
}