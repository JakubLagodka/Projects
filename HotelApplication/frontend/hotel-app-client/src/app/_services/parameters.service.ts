import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {shareReplay, take} from 'rxjs/operators';
import {Parameters} from '../_models/parameters';

@Injectable({
  providedIn: 'root'
})
export class ParametersService {

  status = null;
  constructor( private http: HttpClient) { }

  getParameters(): Observable< Parameters[]> {
    return this.http.get< Parameters[]>(`${environment.apiUrl}/parameters`);
  }

  getParameterById(id: number): Observable< Parameters[]> {
    return this.http.get< Parameters[]>(`${environment.apiUrl}/parameter?id=` + id);
  }


  addParameter(parameter: Parameters): Observable< Parameters> {
    const returnedParameter = this.http.post< Parameters>(`${environment.apiUrl}/parameter/add`, parameter).pipe(shareReplay());

    returnedParameter.pipe(take(1)).subscribe(x => {
      },
      err => {
        this.status = err.status;
      });

    return returnedParameter;
  }

  deleteParameter(id: number): Observable<Parameters> {
    return this.http.delete<Parameters>(`${environment.apiUrl}/parameter?id=` + id).pipe(shareReplay());

  }

  updateParameter(id: number, parameters: Parameters): Observable< Parameters> {
    return this.http.patch<Parameters>(`${environment.apiUrl}/parameter?id=` + id, parameters).pipe(shareReplay());
  }
}
