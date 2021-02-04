import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FirebaseService } from 'src/app/services/firebase.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  showAddProduct: boolean = false;
  showEditProduct: boolean = false;
  showHomeUI: boolean = true;

  constructor(private firebaseService: FirebaseService, private router: Router) { }

  ngOnInit(): void {
  }

  signOut() {
    this.firebaseService.signOut();
    return this.router.navigate([ '' ]);
  }

  showAdd() {
    this.showAddProduct = true;
    this.showHomeUI = false;
    this.showEditProduct = false;
  }

  showHome() {
    this.showHomeUI = true;
    this.showAddProduct = false;
    this.showEditProduct = false;
  }

  showEdit() {
    this.showEditProduct = true;
    this.showAddProduct = false;
    this.showHomeUI = false;
  }
}
