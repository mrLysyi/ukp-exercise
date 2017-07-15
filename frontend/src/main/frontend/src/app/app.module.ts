import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {AlertService} from "./services/alert.service";
import {Router} from "@angular/router";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {AppRoutingModule} from "./routing/app-routing.module";
import {FAQsComponent} from "./content/FAQs/faqs.component";
import {HomeComponent} from "./content/home/home.component";
import {PageNotFoundComponent} from "./routing/not-found.component";
import {RestService} from "./services/rest.service";

@NgModule({
  declarations: [
    AppComponent,
    FAQsComponent,
    HomeComponent,
    PageNotFoundComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    FormsModule,
    HttpModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [AlertService, RestService],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(router: Router) { // Diagnostic only: inspect router configuration

  } }
