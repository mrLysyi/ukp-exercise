import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";

import {Router} from "@angular/router";
import {RestService} from "../../services/rest.service";
import {RoutineDto, RsHolder} from "../../model/routine";
import {AlertService} from "../../services/alert.service";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    private routineRaws: RoutineDto[] = [];
    private routineResults: RoutineDto[] = [];
    private allRoutineResults: RoutineDto[][] = [[]]; // array of arrays
    private testdata: any;
    private selectedId: number;
    private sheduleStr: string = "";
    private sheduleStrs: string[] = [];
    private cleanStr : RsHolder[] = [];

    constructor(private restService: RestService, private alertService: AlertService, private router: Router) {
    }

    ngOnInit() {
        this.getRawRoutine();
        this.getAllRoutineUnited();
    }


    getRawRoutine() {
        this.alertService.clearMeessage();
        this.restService.getData('./api/routine/list')
            .subscribe((data: RoutineDto[]) => {
                this.routineRaws = [];
                this.routineRaws.push(data[0]);
                let prevId: number = data[0].id;
                for (let i = 0; i < data.length; i++) { // filter duplicates, we need only deistic Id's
                    if (prevId != data[i].id) {
                        this.routineRaws.push(data[i])
                    }
                    prevId = data[i].id;
                }
                this.routineRaws = this.routineRaws.sort((a, b): number => {   //sor array by
                    if (a.id < b.id) return -1;
                    if (a.id > b.id) return 1;
                    return 0;
                });
            }, () => {
                console.log('err')
                this.alertService.error("server error occurred");
            }); //todo: add Alert service
    }

    resetView() {
        this.testdata = "";
        this.routineResults = [];
    }

    selectRoutineById(id: number) {
        this.selectedId = id;
        this.restService.getData('./api/routine/unitedlist', `/${id}`)
            .subscribe((data: RoutineDto[]) => {
                this.routineResults = data;

            }, () => console.log('err')); //todo: add Alert service
    }

    //RoutineListsDto
    getAllRoutineUnited() {
        this.restService.getData('./api/routine/unitedlist/all')
            .subscribe((data: RoutineDto[][]) => {
                this.allRoutineResults = data; //this.allRoutineResults - didn't work properly

                for (let i = 0; i < data.length; i++) {
                    console.log('------' + data.length);
                    let tempStr: string = "";
                    let t : RoutineDto[]  = [];
                    for (let l of data[i]){
                        t.push(l);
                    }
                    //console.log(t);
                      tempStr = this.formatSheduleString( t );
                     this.sheduleStrs.push(tempStr);
                     this.cleanStr.push(new RsHolder( data[i][0].id,tempStr));
                     this.cleanStr = this.cleanStr.sort((a, b): number => {   //sor array by
                         if (a.id < b.id) return -1;
                         if (a.id > b.id) return 1;
                         return 0;
                     });
                     //console.log(this.sheduleStrs);
                }

            }, () => console.log('err')); //todo: add Alert service
        //for (var i = 0; i < arr.length; i++) let i of


    }

    formatSheduleString(arr: RoutineDto[]): string { // create Shedule from RoutineDto
        let str = arr[0].id + ': ';
        for (let _i = 0; _i < arr.length; _i++) {
            str = str + arr[_i].pnDaynamesByDayofweek.shortName + ' ';
            if (arr[_i].pnDaynamesPeriodTo) // second day to mn-fr
                str = str + '-' + arr[_i].pnDaynamesPeriodTo.shortName + ' ';
            str = str + arr[_i].workfrom + '-' + arr[_i].workto;
            if (arr[_i].intervalActive)
                str = str + ' (' + arr[_i].intervalfrom + '-' + arr[_i].intervalto + ') ';
            str = str + ' ;'
        }
        return str;
    }


}

// http://stackoverflow.com/questions/36076700/what-is-the-proper-use-of-an-eventemitter
// Mission Service
// https://angular.io/docs/ts/latest/cookbook/component-communication.html
