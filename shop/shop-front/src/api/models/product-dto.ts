/* tslint:disable */
/* eslint-disable */
export interface ProductDto {
  available: boolean;
  createdBy?: string;
  createdDate?: string;
  id?: number;
  imageUrl?: string;
  lastModifiedBy?: string;
  lastModifiedDate?: string;
  name: string;
  price: number;
  quantity?: number;
  revisionNumber?: number;
  revisionType?: 'UNKNOWN' | 'INSERT' | 'UPDATE' | 'DELETE';
}
