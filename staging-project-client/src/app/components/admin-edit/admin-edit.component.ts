import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-admin-edit',
  templateUrl: './admin-edit.component.html',
  styleUrls: ['./admin-edit.component.css']
})
export class AdminEditComponent implements OnInit {

  products = [];

  showDeletedAlert: boolean = false;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getProducts();

  }

  getProducts() {
    this.productService.getProducts().subscribe((data: any[]) => {
      this.products = data;
      console.log(data);
    })
  }

  deleteProduct(productId: number) {
    this.productService.deleteProduct(productId)
      .subscribe(data => {
        this.products = this.products.filter(product => product.productId !== productId);
        this.getProducts();
        this.showDeletedAlert = true;
      });
      
  }

  closeAlert() {
    this.showDeletedAlert=false;
  }

}
