import { Component } from "@angular/core";
import { Team } from "../../types/Team";
@Component({
    selector:'app-team',
    standalone:true,
    templateUrl:'./teamsample.component.html',
    styleUrls:['./teamsample.component.scss']
})

export class TeamSampleComponent  {
team:Team;
  constructor(){
    this.team=new Team(1,'CSK','Chennai','Dhoni M S',2015);
  }
}
