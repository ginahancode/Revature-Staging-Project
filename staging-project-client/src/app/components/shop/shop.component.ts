import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  products = [];

  constructor(private productService: ProductService) {
    // this.products = this.productService.getProducts();
    // console.log(this.products);
   }

  ngOnInit(): void {
   
    // this.productService.getProducts().subscribe((data: any[]) => {
    //   console.log(data);
    //   this.products = data;
    // })
  }

}
