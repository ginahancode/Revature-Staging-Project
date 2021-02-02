import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  items = this.cartService.getItems();

  constructor(private cartService: CartService) {
    console.log(this.items + "in cart c");
   }

  ngOnInit(): void {
    
  }

  deleteItem(product) {
    this.cartService.deleteItem(product);
    console.log(this.items);
    console.log(product);
  }

}
