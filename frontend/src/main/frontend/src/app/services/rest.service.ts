import {Injectable} from "@angular/core";
import {Http, Headers, Response} from "@angular/http";
import {Observable} from "rxjs";
import "rxjs/add/operator/map";

@Injectable()
export class RestService {

  private headers = new Headers({
    'Content-Type': 'application/json'
  });


  constructor(private http: Http) {
  }

  getData(restPath: string, param?: string): Observable<any> {
    return this.http.get(restPath + (param ? param : ''),   {headers: this.headers})
      .map(res => res.json())
      .catch(this.handleError);
  }
  getDataAny(restPath: string, param?: string): Observable<any> {
    return this.http.get(restPath + (param ? param : ''),   {headers: this.headers})
      .map(res => res.text())
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    //in a real world app, we may send the error to some remote logging infrastructure
    //instead of just logging it to the console
    console.error(error);
    return Observable.throw(error);
  }
}

//return this.http.put('/api/users/' + user.id, user, this.jwt()).map((response: Response) => response.json());
