import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {shareReplay, take} from 'rxjs/operators';
import {Parameter} from '../_models/parameter';

@Injectable({
  providedIn: 'root'
})
export class ParametersService {

  status = null;
  constructor( private http: HttpClient) { }

  getParameters(): Observable< Parameter[]> {
    return this.http.get< Parameter[]>(`${environment.apiUrl}/parameter/all`);
  }


  getParameterById(id: number): Observable< Parameter[]> {
    return this.http.get< Parameter[]>(`${environment.apiUrl}/parameter?id=` + id);
  }

  addParameter(parameter: Parameter): Observable< Parameter> {
    const returnedParameter = this.http.post< Parameter>(`${environment.apiUrl}/parameter/add`, parameter).pipe(shareReplay());

    returnedParameter.pipe(take(1)).subscribe(x => {
      },
      err => {
        this.status = err.status;
      });

    return returnedParameter;
  }

  deleteParameter(id: number): Observable<any> {
    const returnedParameter = this.http.delete<any>(`${environment.apiUrl}/parameter/?id=` + id).pipe(shareReplay());
    returnedParameter.pipe(take(1)).subscribe(x => {
      },
      err => {
        this.status = err.status;
      });

    return returnedParameter;
  }

/* deleteParameterAndColumn(id: number, type: number, typeId: number): Observable<any> {
   const returnedParameter = this.http.delete<any>(`${environment.apiUrl}/parameter/?id=` + id + '&type=' + type + '&typeId=' + typeId).pipe(shareReplay());
   returnedParameter.pipe(take(1)).subscribe(x => {
     },
     err => {
       this.status = err.status;
     });

   return returnedParameter;
 }*/
 updateParameter(id: number, parameter: Parameter): Observable< Parameter> {
   const returnedParameter =  this.http.patch<Parameter>(`${environment.apiUrl}/parameter?id=` + id, parameter).pipe(shareReplay());
   returnedParameter.pipe(take(1)).subscribe(x => {
     },
     err => {
       this.status = err.status;
     });

   return returnedParameter;
 }
}

