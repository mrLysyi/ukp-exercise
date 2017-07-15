import { NgModule }     from '@angular/core';
import {  RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "../content/home/home.component";
import {FAQsComponent} from "../content/FAQs/faqs.component";
import {PageNotFoundComponent} from "app/routing/not-found.component";



const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'faqs', component: FAQsComponent},
  {path: '',   redirectTo: '/home', pathMatch: 'full' },
  {path: '**', component: PageNotFoundComponent }
  //{ path: '', component: HomeComponent, canActivate: [AuthGuard] },
];


@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes, { useHash: true }
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}




