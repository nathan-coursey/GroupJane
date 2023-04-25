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
  logInStatus: Boolean;

  constructor(private http: HttpClient, private router: Router) {
    this.logInStatus = false;
   }

  ngOnInit(): void {
    this.verifyLoggedIn();
  }

  verifyLoggedIn() {

    if (localStorage.getItem('userName') === null) {
      this.router.navigate(["/login"])
      return;
    }

    this.currentUser = localStorage.getItem('userName');
    this.logInStatus = true;
  }

  logOut() {
    localStorage.clear();
    this.logInStatus = false;
    this.router.navigate(["/login"])
    return;
  }


}
