/* tslint:disable */
/* eslint-disable */
import { OrderDetails } from './order-details';
import { Product } from './product';
export interface OrderDto {
  id?: number;
  orderDetails?: OrderDetails;
  product?: Product;
  quantity?: number;
}
