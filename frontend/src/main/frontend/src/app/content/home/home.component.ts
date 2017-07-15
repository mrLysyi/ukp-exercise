import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";

import {Router} from "@angular/router";
import {RestService} from "../../services/rest.service";
import {RoutineDto} from "../../model/routine";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  private routineRaws : RoutineDto[] = [];
  private routineResults : RoutineDto[] = [];
  private testdata: any;
  private selectedId:number;

  constructor(private restService: RestService,  private router: Router) {
  }

  ngOnInit() {
    this.getRawRoutine();
  }


  getRawRoutine(){
    this.restService.getData('./api/routine/list')
      .subscribe((data : RoutineDto[]) => {
      this.routineRaws.push(data[0]);
        let prevId : number = data[0].id;
        for (let i = 0; i < data.length; i++) { // filter duplicates, we need only deistic Id's
          if(prevId != data[i].id){
            this.routineRaws.push(data[i])
          }
          prevId = data[i].id;
        }

      }, ()=>console.log('err')); //todo: add Alert service
  }

  resetView(){
    this.testdata = "";
   this.routineResults = [];
  }

  selectRoutineId(id : number){
    this.selectedId = id;

    this.restService.getData('./api/routine/unitedlist', `/${id}`)
        .subscribe((data : RoutineDto[]) => {
          this.routineResults = data;
        }, ()=>console.log('err')); //todo: add Alert service

  }




}

// http://stackoverflow.com/questions/36076700/what-is-the-proper-use-of-an-eventemitter
// Mission Service
// https://angular.io/docs/ts/latest/cookbook/component-communication.html
