import { Component } from "@angular/core";
import { Cricketer } from "../../types/Cricketer";

@Component({
    selector:'app-cricketer',
    standalone:true,
    templateUrl:'./cricketersample.component.html',
    styleUrls: ['/cricketersample.component.scss']
})
export class CricketerSampleComponent {
  cricketer:Cricketer;
  constructor(){
    this.cricketer = new Cricketer(1,1,'Virat',32,'Indian',14,'Batsman',580,50);
  }
}
