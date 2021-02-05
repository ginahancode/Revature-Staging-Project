import { Component, Input, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  products = [];

  filteredProducts: Product[] = [];

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

  getFilteredProducts(filteredProducts: Product[] ) {
    this.filteredProducts = filteredProducts;
    console.log(this.filteredProducts);
  }

}
