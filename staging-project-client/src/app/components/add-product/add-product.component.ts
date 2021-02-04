import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  product: Product;

  showAddedAlert: boolean = false;

  productName: string = '';
  

  constructor(private productService: ProductService,
     private formBuilder: FormBuilder, private http: HttpClient
    ) { }

  ngOnInit(): void {
    
  }

  addProductForm = this.formBuilder.group({
    name: '',
    type: '',
    technology: '',
    size: '',
    gender: '',
    inventory: '',
    price: '',
    image: '',
    description: '',
  })


  onSubmit() {
    // this.product = new Product();
    this.product = this.addProductForm.value;
    this.productService.addProduct(this.product)
      .subscribe(data => console.log(data), error =>
      console.log(error));
    // console.log(this.addProductForm.value);
    // console.warn(this.product);
    this.productName = this.addProductForm.value.name;
    console.log(this.productName);
    this.showAddedAlert = true;
    this.addProductForm.reset();
  }

  closeAlert() {
    this.showAddedAlert=false;
  }

}
