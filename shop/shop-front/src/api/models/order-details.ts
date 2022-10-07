/* tslint:disable */
/* eslint-disable */
import { User } from './user';
export interface OrderDetails {
  date?: string;
  id?: number;
  orderNumber?: string;
  status?: 'CREATED' | 'SEND' | 'DONE';
  user?: User;
}
