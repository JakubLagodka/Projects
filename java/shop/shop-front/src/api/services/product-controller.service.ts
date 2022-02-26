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
import { ProductDto } from '../models/product-dto';

@Injectable({
  providedIn: 'root',
})
export class ProductControllerService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation getProductById
   */
  static readonly GetProductByIdPath = '/api/products/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getProductById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getProductById$Response(params: {
    id: number;
  }): Observable<StrictHttpResponse<ProductDto>> {

    const rb = new RequestBuilder(this.rootUrl, ProductControllerService.GetProductByIdPath, 'get');
    if (params) {
      rb.path('id', params.id, {});
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<ProductDto>;
      })
    );
  }

  /**
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `getProductById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getProductById(params: {
    id: number;
  }): Observable<ProductDto> {

    return this.getProductById$Response(params).pipe(
      map((r: StrictHttpResponse<ProductDto>) => r.body as ProductDto)
    );
  }

  /**
   * Path part for operation updateProduct
   */
  static readonly UpdateProductPath = '/api/products/{id}';

  /**
   * update given product
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateProduct()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateProduct$Response(params: {
    id: number;
    body?: {
'productDto': ProductDto;
'image': Blob;
}
  }): Observable<StrictHttpResponse<ProductDto>> {

    const rb = new RequestBuilder(this.rootUrl, ProductControllerService.UpdateProductPath, 'put');
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
        return r as StrictHttpResponse<ProductDto>;
      })
    );
  }

  /**
   * update given product
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `updateProduct$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateProduct(params: {
    id: number;
    body?: {
'productDto': ProductDto;
'image': Blob;
}
  }): Observable<ProductDto> {

    return this.updateProduct$Response(params).pipe(
      map((r: StrictHttpResponse<ProductDto>) => r.body as ProductDto)
    );
  }

  /**
   * Path part for operation deleteProduct
   */
  static readonly DeleteProductPath = '/api/products/{id}';

  /**
   * delete given product
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteProduct()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteProduct$Response(params: {
    id: number;
  }): Observable<StrictHttpResponse<void>> {

    const rb = new RequestBuilder(this.rootUrl, ProductControllerService.DeleteProductPath, 'delete');
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
   * delete given product
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `deleteProduct$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteProduct(params: {
    id: number;
  }): Observable<void> {

    return this.deleteProduct$Response(params).pipe(
      map((r: StrictHttpResponse<void>) => r.body as void)
    );
  }

  /**
   * Path part for operation getProductPage
   */
  static readonly GetProductPagePath = '/api/products';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getProductPage()` instead.
   *
   * This method doesn't expect any request body.
   */
  getProductPage$Response(params: {
    page: number;
    size: number;
  }): Observable<StrictHttpResponse<PageProductDto>> {

    const rb = new RequestBuilder(this.rootUrl, ProductControllerService.GetProductPagePath, 'get');
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
        return r as StrictHttpResponse<PageProductDto>;
      })
    );
  }

  /**
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `getProductPage$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getProductPage(params: {
    page: number;
    size: number;
  }): Observable<PageProductDto> {

    return this.getProductPage$Response(params).pipe(
      map((r: StrictHttpResponse<PageProductDto>) => r.body as PageProductDto)
    );
  }

  /**
   * Path part for operation saveProduct
   */
  static readonly SaveProductPath = '/api/products';

  /**
   * create new product
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `saveProduct()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveProduct$Response(params?: {
    body?: {
'productDto': ProductDto;
'image': Blob;
}
  }): Observable<StrictHttpResponse<ProductDto>> {

    const rb = new RequestBuilder(this.rootUrl, ProductControllerService.SaveProductPath, 'post');
    if (params) {
      rb.body(params.body, 'application/json');
    }

    return this.http.request(rb.build({
      responseType: 'blob',
      accept: '*/*'
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<ProductDto>;
      })
    );
  }

  /**
   * create new product
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `saveProduct$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveProduct(params?: {
    body?: {
'productDto': ProductDto;
'image': Blob;
}
  }): Observable<ProductDto> {

    return this.saveProduct$Response(params).pipe(
      map((r: StrictHttpResponse<ProductDto>) => r.body as ProductDto)
    );
  }

}
