import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../models/product';

import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/api/v1/"

  constructor(private http: HttpClient) { }


  getProducts() {
    return this.http.get<Product[]>(`${this.baseUrl}` + 'products')
  }

  addProduct(product: Product) {
    return this.http.post<Product>(`${this.baseUrl}` + 'products', product)
    .pipe(
      tap(_ => console.log('Add product'))
    );
  }
}
