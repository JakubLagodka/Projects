/* tslint:disable */
/* eslint-disable */
export interface UserDto {
  confirmPassword?: string;
  createdBy?: string;
  createdDate?: string;
  firstName: string;
  id?: number;
  lastModifiedBy?: string;
  lastModifiedDate?: string;
  lastName: string;
  login: string;
  mail: string;
  password: string;
  revisionNumber?: number;
  revisionType?: 'UNKNOWN' | 'INSERT' | 'UPDATE' | 'DELETE';
}
