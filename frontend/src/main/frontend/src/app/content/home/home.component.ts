import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";

import {Router} from "@angular/router";
import {RestService} from "../../services/rest.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

 // private news : News[] = [];
  private testdata: any;

  constructor(private restService: RestService,  private router: Router) {

  }


  ngOnInit(): void {
    this.getNews();
  }


  getNews(){
    this.restService.getDataAny('./api/routine/list')
      .subscribe((data) => {
      this.testdata = data;
        console.log(data);
      }, ()=>console.log('err')); //todo: add Alert service
  }



}

// http://stackoverflow.com/questions/36076700/what-is-the-proper-use-of-an-eventemitter
// Mission Service
// https://angular.io/docs/ts/latest/cookbook/component-communication.html
