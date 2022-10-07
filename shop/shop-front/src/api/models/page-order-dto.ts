/* tslint:disable */
/* eslint-disable */
import { OrderDto } from './order-dto';
import { PageableObject } from './pageable-object';
import { Sort } from './sort';
export interface PageOrderDto {
  content?: Array<OrderDto>;
  empty?: boolean;
  first?: boolean;
  last?: boolean;
  number?: number;
  numberOfElements?: number;
  pageable?: PageableObject;
  size?: number;
  sort?: Sort;
  totalElements?: number;
  totalPages?: number;
}
