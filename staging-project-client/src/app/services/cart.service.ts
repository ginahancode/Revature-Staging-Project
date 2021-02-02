import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  items = [];

  constructor() { }

  addToCart(product) {
    this.items.push(product);
    console.log(this.items);
  }

  getItems() {
    console.log(this.items);

    return this.items;
  }

  clearCart() {
    this.items = [];
    return this.items;
  }

  deleteItem(product) {
    this.items.splice(product, 1);
    // return this.items;
  }

}
