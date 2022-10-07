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

import { PageTemplateDto } from '../models/page-template-dto';
import { TemplateDto } from '../models/template-dto';

@Injectable({
  providedIn: 'root',
})
export class TemplateControllerService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation getTemplateById
   */
  static readonly GetTemplateByIdPath = '/api/templates/{id}';

  /**
   * get template by id
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getTemplateById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getTemplateById$Response(params: {
    id: number;
  }): Observable<StrictHttpResponse<TemplateDto>> {

    const rb = new RequestBuilder(this.rootUrl, TemplateControllerService.GetTemplateByIdPath, 'get');
    if (params) {
      rb.path('id', params.id, {});
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<TemplateDto>;
      })
    );
  }

  /**
   * get template by id
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `getTemplateById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getTemplateById(params: {
    id: number;
  }): Observable<TemplateDto> {

    return this.getTemplateById$Response(params).pipe(
      map((r: StrictHttpResponse<TemplateDto>) => r.body as TemplateDto)
    );
  }

  /**
   * Path part for operation updateTemplate
   */
  static readonly UpdateTemplatePath = '/api/templates/{id}';

  /**
   * update given template
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateTemplate()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateTemplate$Response(params: {
    id: number;
    body: TemplateDto
  }): Observable<StrictHttpResponse<TemplateDto>> {

    const rb = new RequestBuilder(this.rootUrl, TemplateControllerService.UpdateTemplatePath, 'put');
    if (params) {
      rb.path('id', params.id, {});
      rb.body(params.body, 'application/json');
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<TemplateDto>;
      })
    );
  }

  /**
   * update given template
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `updateTemplate$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateTemplate(params: {
    id: number;
    body: TemplateDto
  }): Observable<TemplateDto> {

    return this.updateTemplate$Response(params).pipe(
      map((r: StrictHttpResponse<TemplateDto>) => r.body as TemplateDto)
    );
  }

  /**
   * Path part for operation deleteTemplate
   */
  static readonly DeleteTemplatePath = '/api/templates/{id}';

  /**
   * delete given template
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteTemplate()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteTemplate$Response(params: {
    id: number;
  }): Observable<StrictHttpResponse<void>> {

    const rb = new RequestBuilder(this.rootUrl, TemplateControllerService.DeleteTemplatePath, 'delete');
    if (params) {
      rb.path('id', params.id, {});
    }

    return this.http.request(rb.build({
      responseType: 'text',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return (r as HttpResponse<any>).clone({ body: undefined }) as StrictHttpResponse<void>;
      })
    );
  }

  /**
   * delete given template
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `deleteTemplate$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteTemplate(params: {
    id: number;
  }): Observable<void> {

    return this.deleteTemplate$Response(params).pipe(
      map((r: StrictHttpResponse<void>) => r.body as void)
    );
  }

  /**
   * Path part for operation getTemplatePage
   */
  static readonly GetTemplatePagePath = '/api/templates';

  /**
   * get page of templates
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getTemplatePage()` instead.
   *
   * This method doesn't expect any request body.
   */
  getTemplatePage$Response(params: {
    page: number;
    size: number;
  }): Observable<StrictHttpResponse<PageTemplateDto>> {

    const rb = new RequestBuilder(this.rootUrl, TemplateControllerService.GetTemplatePagePath, 'get');
    if (params) {
      rb.query('page', params.page, {});
      rb.query('size', params.size, {});
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<PageTemplateDto>;
      })
    );
  }

  /**
   * get page of templates
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `getTemplatePage$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getTemplatePage(params: {
    page: number;
    size: number;
  }): Observable<PageTemplateDto> {

    return this.getTemplatePage$Response(params).pipe(
      map((r: StrictHttpResponse<PageTemplateDto>) => r.body as PageTemplateDto)
    );
  }

  /**
   * Path part for operation saveTemplate
   */
  static readonly SaveTemplatePath = '/api/templates';

  /**
   * create new template
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `saveTemplate()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveTemplate$Response(params: {
    body: TemplateDto
  }): Observable<StrictHttpResponse<TemplateDto>> {

    const rb = new RequestBuilder(this.rootUrl, TemplateControllerService.SaveTemplatePath, 'post');
    if (params) {
      rb.body(params.body, 'application/json');
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<TemplateDto>;
      })
    );
  }

  /**
   * create new template
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `saveTemplate$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveTemplate(params: {
    body: TemplateDto
  }): Observable<TemplateDto> {

    return this.saveTemplate$Response(params).pipe(
      map((r: StrictHttpResponse<TemplateDto>) => r.body as TemplateDto)
    );
  }

}
