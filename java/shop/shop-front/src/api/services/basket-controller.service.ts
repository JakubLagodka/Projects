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

import { BasketDto } from '../models/basket-dto';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root',
})
export class BasketControllerService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation getBasket
   */
  static readonly GetBasketPath = '/api/basket';

  /**
   * get all products in basket
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getBasket()` instead.
   *
   * This method doesn't expect any request body.
   */
  getBasket$Response(params?: {
  }): Observable<StrictHttpResponse<Array<Product>>> {

    const rb = new RequestBuilder(this.rootUrl, BasketControllerService.GetBasketPath, 'get');
    if (params) {
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<Array<Product>>;
      })
    );
  }

  /**
   * get all products in basket
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `getBasket$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getBasket(params?: {
  }): Observable<Array<Product>> {

    return this.getBasket$Response(params).pipe(
      map((r: StrictHttpResponse<Array<Product>>) => r.body as Array<Product>)
    );
  }

  /**
   * Path part for operation addProduct
   */
  static readonly AddProductPath = '/api/basket';

  /**
   * add product to basket
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `addProduct()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  addProduct$Response(params: {
    body: BasketDto
  }): Observable<StrictHttpResponse<void>> {

    const rb = new RequestBuilder(this.rootUrl, BasketControllerService.AddProductPath, 'post');
    if (params) {
      rb.body(params.body, 'application/json');
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
   * add product to basket
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `addProduct$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  addProduct(params: {
    body: BasketDto
  }): Observable<void> {

    return this.addProduct$Response(params).pipe(
      map((r: StrictHttpResponse<void>) => r.body as void)
    );
  }

  /**
   * Path part for operation clearBasket
   */
  static readonly ClearBasketPath = '/api/basket';

  /**
   * remove basket
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `clearBasket()` instead.
   *
   * This method doesn't expect any request body.
   */
  clearBasket$Response(params?: {
  }): Observable<StrictHttpResponse<void>> {

    const rb = new RequestBuilder(this.rootUrl, BasketControllerService.ClearBasketPath, 'delete');
    if (params) {
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
   * remove basket
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `clearBasket$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  clearBasket(params?: {
  }): Observable<void> {

    return this.clearBasket$Response(params).pipe(
      map((r: StrictHttpResponse<void>) => r.body as void)
    );
  }

  /**
   * Path part for operation deleteProductByProductId
   */
  static readonly DeleteProductByProductIdPath = '/api/basket/{productId}';

  /**
   * remove specified product in basket
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteProductByProductId()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteProductByProductId$Response(params: {
    productId: number;
  }): Observable<StrictHttpResponse<void>> {

    const rb = new RequestBuilder(this.rootUrl, BasketControllerService.DeleteProductByProductIdPath, 'delete');
    if (params) {
      rb.path('productId', params.productId, {});
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
   * remove specified product in basket
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `deleteProductByProductId$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteProductByProductId(params: {
    productId: number;
  }): Observable<void> {

    return this.deleteProductByProductId$Response(params).pipe(
      map((r: StrictHttpResponse<void>) => r.body as void)
    );
  }

}
