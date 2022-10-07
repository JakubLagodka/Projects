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

import { PageProductDto } from '../models/page-product-dto';
import { PageUserDto } from '../models/page-user-dto';

@Injectable({
  providedIn: 'root',
})
export class HistoryControllerService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation getUserHistory
   */
  static readonly GetUserHistoryPath = '/api/histories/users/{id}';

  /**
   * get user history
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getUserHistory()` instead.
   *
   * This method doesn't expect any request body.
   */
  getUserHistory$Response(params: {
    id: number;
    page: number;
    size: number;
  }): Observable<StrictHttpResponse<PageUserDto>> {

    const rb = new RequestBuilder(this.rootUrl, HistoryControllerService.GetUserHistoryPath, 'get');
    if (params) {
      rb.path('id', params.id, {});
      rb.query('page', params.page, {});
      rb.query('size', params.size, {});
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<PageUserDto>;
      })
    );
  }

  /**
   * get user history
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `getUserHistory$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getUserHistory(params: {
    id: number;
    page: number;
    size: number;
  }): Observable<PageUserDto> {

    return this.getUserHistory$Response(params).pipe(
      map((r: StrictHttpResponse<PageUserDto>) => r.body as PageUserDto)
    );
  }

  /**
   * Path part for operation getProductHistory
   */
  static readonly GetProductHistoryPath = '/api/histories/products/{id}';

  /**
   * get produ history
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getProductHistory()` instead.
   *
   * This method doesn't expect any request body.
   */
  getProductHistory$Response(params: {
    id: number;
    page: number;
    size: number;
  }): Observable<StrictHttpResponse<PageProductDto>> {

    const rb = new RequestBuilder(this.rootUrl, HistoryControllerService.GetProductHistoryPath, 'get');
    if (params) {
      rb.path('id', params.id, {});
      rb.query('page', params.page, {});
      rb.query('size', params.size, {});
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<PageProductDto>;
      })
    );
  }

  /**
   * get produ history
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `getProductHistory$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getProductHistory(params: {
    id: number;
    page: number;
    size: number;
  }): Observable<PageProductDto> {

    return this.getProductHistory$Response(params).pipe(
      map((r: StrictHttpResponse<PageProductDto>) => r.body as PageProductDto)
    );
  }

}
