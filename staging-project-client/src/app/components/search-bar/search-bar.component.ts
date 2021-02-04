import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {

  searchField: string = '';
  products: Product[] = [];

  filteredProducts: Product[] = [];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
      this.productService.getProducts().subscribe((data: any[]) => {
      console.log(data);
      this.products = data;
   })
  }

  searchProducts() {  
    this.filteredProducts = this.products.filter(product => 
      product.technology.toLowerCase() === this.searchField.toLowerCase()
    );    
    console.warn(this.filteredProducts);
  }
}
