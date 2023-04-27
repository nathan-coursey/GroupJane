import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { VerifyLogoutService } from 'src/app/user-profile-arm/security/verify-logout.service';
import { UserDetailsDTO } from '../../models/dto/UserDetailsDTO';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  currentUser;
  logInStatus: Boolean;
  changeInfo: boolean;

  constructor(private http: HttpClient, private router: Router, private verifyService: VerifyLogoutService) {
    this.logInStatus = false;
    this.currentUser = localStorage.getItem('userName');
   }

  ngOnInit(): void {
    this.logInStatus = this.verifyService.verifyLoggedIn();
  }

  updateUserInfo( userDetails: NgForm ) {

    this.changeInfo = false;
    let userInfo: UserDetailsDTO = {
      firstName: userDetails.value.firstName,
      lastName: userDetails.value.lastName
    }
  }

  logOut() {
    localStorage.removeItem('userName');
    this.logInStatus = false;
    this.router.navigate(["/login"])
    return;
  }

}
