import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  currentUser;
  loggedIn: Boolean;

  constructor(private http: HttpClient, private router: Router) {
    this.loggedIn = false;
   }

  ngOnInit(): void {
    this.verifyLoggedIn();
  }

  verifyLoggedIn() {
    this.currentUser = localStorage.getItem('userName');
    this.loggedIn = true;
  }

  logOut() {
    localStorage.clear();
    console.log(localStorage.getItem('userName'))
    this.loggedIn = false;
  }

}
