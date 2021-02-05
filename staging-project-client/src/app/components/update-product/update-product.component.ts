import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  
  closeResult = '';
  @Input() product: Product;
  @Input() productId: number;



  constructor(private modal: NgbModal, private productService: ProductService) { }

  ngOnInit(): void {
  }

  // addProductForm = this.formBuilder.group({
  //   name: '',
  //   type: '',
  //   technology: '',
  //   size: '',
  //   gender: '',
  //   inventory: '',
  //   price: '',
  //   image: '',
  //   description: '',
  // })

  openXl(content) {
    this.modal.open(content, {size: 'lg'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });

  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  updateProduct() {
    console.log(this.productId);
    this.productService.updateProduct(this.product, this.productId)
      .subscribe(data => console.log(data), error =>
      console.log(error));
  }
}
