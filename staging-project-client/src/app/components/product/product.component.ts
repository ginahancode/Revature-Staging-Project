import { Component, Input, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products = [];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {

    this.productService.getProducts().subscribe((data: any[]) => {
      console.log(data);
      this.products = data;
    })

    
  }

}
