/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';
import { RequestBuilder } from '../request-builder';
import { Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';


@Injectable({
  providedIn: 'root',
})
export class FileControllerService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation testFlyweight
   */
  static readonly TestFlyweightPath = '/api/file';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `testFlyweight()` instead.
   *
   * This method doesn't expect any request body.
   */
  testFlyweight$Response(params: {
    fileType: 'PDF' | 'CSV' | 'JSON' | 'XLS';
  }): Observable<StrictHttpResponse<Array<string>>> {

    const rb = new RequestBuilder(this.rootUrl, FileControllerService.TestFlyweightPath, 'get');
    if (params) {
      rb.query('fileType', params.fileType, {});
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<Array<string>>;
      })
    );
  }

  /**
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `testFlyweight$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  testFlyweight(params: {
    fileType: 'PDF' | 'CSV' | 'JSON' | 'XLS';
  }): Observable<Array<string>> {

    return this.testFlyweight$Response(params).pipe(
      map((r: StrictHttpResponse<Array<string>>) => r.body as Array<string>)
    );
  }

}
