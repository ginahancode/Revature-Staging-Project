import { Component, OnInit, Output } from '@angular/core';
import { Items } from 'src/app/models/items';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  items = []; 

  showRemovedAlert: boolean;

  @Output() cartItems: Items[] = [];

  constructor(private cartService: CartService) {
    console.log(this.items + "in cart c");
   }

  ngOnInit(): void {
   this.items = this.cartService.getItems();
   this.cartItems = this.cartService.getItems();
  }

  deleteItem(product) {
    this.cartService.deleteItem(product);
    console.log(this.items);
    console.log(product);
    this.showRemovedAlert = true;
  }

  closeAlert() {
    this.showRemovedAlert = false;
  }

}
