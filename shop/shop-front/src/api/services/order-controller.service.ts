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

import { OrderDto } from '../models/order-dto';
import { PageOrderDto } from '../models/page-order-dto';

@Injectable({
  providedIn: 'root',
})
export class OrderControllerService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation getOrderById
   */
  static readonly GetOrderByIdPath = '/api/orders/{id}';

  /**
   * get order by given id
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getOrderById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getOrderById$Response(params: {
    id: number;
  }): Observable<StrictHttpResponse<OrderDto>> {

    const rb = new RequestBuilder(this.rootUrl, OrderControllerService.GetOrderByIdPath, 'get');
    if (params) {
      rb.path('id', params.id, {});
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<OrderDto>;
      })
    );
  }

  /**
   * get order by given id
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `getOrderById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getOrderById(params: {
    id: number;
  }): Observable<OrderDto> {

    return this.getOrderById$Response(params).pipe(
      map((r: StrictHttpResponse<OrderDto>) => r.body as OrderDto)
    );
  }

  /**
   * Path part for operation updateOrder
   */
  static readonly UpdateOrderPath = '/api/orders/{id}';

  /**
   * update given order
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateOrder()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateOrder$Response(params: {
    id: number;
    body: OrderDto
  }): Observable<StrictHttpResponse<OrderDto>> {

    const rb = new RequestBuilder(this.rootUrl, OrderControllerService.UpdateOrderPath, 'put');
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
        return r as StrictHttpResponse<OrderDto>;
      })
    );
  }

  /**
   * update given order
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `updateOrder$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateOrder(params: {
    id: number;
    body: OrderDto
  }): Observable<OrderDto> {

    return this.updateOrder$Response(params).pipe(
      map((r: StrictHttpResponse<OrderDto>) => r.body as OrderDto)
    );
  }

  /**
   * Path part for operation deleteOrder
   */
  static readonly DeleteOrderPath = '/api/orders/{id}';

  /**
   * delete given order
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteOrder()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteOrder$Response(params: {
    id: number;
  }): Observable<StrictHttpResponse<void>> {

    const rb = new RequestBuilder(this.rootUrl, OrderControllerService.DeleteOrderPath, 'delete');
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
   * delete given order
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `deleteOrder$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteOrder(params: {
    id: number;
  }): Observable<void> {

    return this.deleteOrder$Response(params).pipe(
      map((r: StrictHttpResponse<void>) => r.body as void)
    );
  }

  /**
   * Path part for operation getOrderPage
   */
  static readonly GetOrderPagePath = '/api/orders';

  /**
   * get all orders
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getOrderPage()` instead.
   *
   * This method doesn't expect any request body.
   */
  getOrderPage$Response(params: {
    page: number;
    size: number;
  }): Observable<StrictHttpResponse<PageOrderDto>> {

    const rb = new RequestBuilder(this.rootUrl, OrderControllerService.GetOrderPagePath, 'get');
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
        return r as StrictHttpResponse<PageOrderDto>;
      })
    );
  }

  /**
   * get all orders
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `getOrderPage$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getOrderPage(params: {
    page: number;
    size: number;
  }): Observable<PageOrderDto> {

    return this.getOrderPage$Response(params).pipe(
      map((r: StrictHttpResponse<PageOrderDto>) => r.body as PageOrderDto)
    );
  }

  /**
   * Path part for operation saveOrder
   */
  static readonly SaveOrderPath = '/api/orders';

  /**
   * create new order
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `saveOrder()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveOrder$Response(params: {
    body: OrderDto
  }): Observable<StrictHttpResponse<OrderDto>> {

    const rb = new RequestBuilder(this.rootUrl, OrderControllerService.SaveOrderPath, 'post');
    if (params) {
      rb.body(params.body, 'application/json');
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<OrderDto>;
      })
    );
  }

  /**
   * create new order
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `saveOrder$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveOrder(params: {
    body: OrderDto
  }): Observable<OrderDto> {

    return this.saveOrder$Response(params).pipe(
      map((r: StrictHttpResponse<OrderDto>) => r.body as OrderDto)
    );
  }

}
