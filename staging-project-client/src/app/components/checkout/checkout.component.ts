import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { Items } from 'src/app/models/items';

import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

declare var paypal;

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  @ViewChild('paypal', { static: true}) paypalElement: ElementRef;


  items = this.cartService.getItems();

  @Input() cartItems;

  cost: number[];

  totalCost: number = 0;

  constructor(private cartService: CartService, private productService: ProductService) {
    console.log(this.items + " items from cart")
    this.cartItems = this.cartService.getItems();
  }

  ngOnInit(): void {
    this.getPrices();
    
    paypal
    .Buttons({
      createOrder: (data, actions) => {
        return actions.order.create({
          purchase_units: [
            {
             name: this.cartItems.name,
             description: this.cartItems.description,
             amount: {
               currency_code: 'USD',
               value: this.totalCost
             }
            }
          ]
        });
      },
      onApprove: async (data, actions) => {
        const order = await actions.order.capture();
        // Send data to backend server and process the charge there
        // Also persist order data/information
        // this.paidFor = true;
        console.log(order);
        window.alert("payment processed!");
      },
      onError: err => {
        console.log(err);
      }
    })
    .render(this.paypalElement.nativeElement);
  }

  getPrice(item) {
    var price = item.price;
    return price;
  }

  getPrices() {
    const cost:number[] = this.items.map(this.getPrice);
    console.warn(cost + "PRICES");
    var total = 0;
    for (var value in cost) {
      total += cost[value];
    }
    console.log(total + " TOTAL")
    let roundedTotal = (Math.round((total + Number.EPSILON) * 100) / 100)

    this.totalCost = roundedTotal;
    
  }

}
