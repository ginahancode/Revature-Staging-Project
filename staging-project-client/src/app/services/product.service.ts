import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/api/v1/"

  constructor(private http: HttpClient) { }


  getProducts() {
    return this.http.get<Product[]>(`${this.baseUrl}` + 'products')
  }
}
