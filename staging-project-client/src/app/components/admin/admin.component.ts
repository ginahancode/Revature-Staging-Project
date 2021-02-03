import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FirebaseService } from 'src/app/services/firebase.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {


  constructor(private firebaseService: FirebaseService, private router: Router) { }

  ngOnInit(): void {
  }

  signOut() {
    this.firebaseService.signOut();
    return this.router.navigate([ '' ]);
  }

}
