import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { VerifyLogoutService } from 'src/app/user-profile-arm/security/verify-logout.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  currentUser;
  logInStatus: Boolean;

  constructor(private http: HttpClient, private router: Router, private verifyService: VerifyLogoutService) {
    this.logInStatus = false;
    this.currentUser = localStorage.getItem('userName');
   }

  ngOnInit(): void {
    this.logInStatus = this.verifyService.verifyLoggedIn();
  }

  logOut() {
    localStorage.clear();
    this.logInStatus = false;
    this.router.navigate(["/login"])
    return;
  }

}
