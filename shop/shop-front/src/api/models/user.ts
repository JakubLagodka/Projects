/* tslint:disable */
/* eslint-disable */
import { Role } from './role';
export interface User {
  createdBy?: string;
  createdDate?: string;
  firstName?: string;
  id?: number;
  lastModifiedBy?: string;
  lastModifiedDate?: string;
  lastName?: string;
  login?: string;
  mail?: string;
  password?: string;
  roles?: Array<Role>;
}
