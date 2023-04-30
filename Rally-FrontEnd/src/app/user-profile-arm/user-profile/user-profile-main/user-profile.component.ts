import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { VerifyLogoutService } from 'src/app/user-profile-arm/security/verify-logout.service';
import { UserInfoDTO } from '../../models/dto/UserInfoDTO';
import { NgForm } from '@angular/forms';
import { UserInformation } from '../../models/UserInformation';
import { ViewUserService } from '../user-services/view-user.service';
import { UserEntity } from '../../models/UserEntity';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  currentUser;
  userInformation: UserInformation;
  logInStatus: Boolean;
  changeInfo = true;
  private userUrl: string;
  userEntity: UserEntity;
  searchUserByIdUrl: string;
  

  constructor(private http: HttpClient, 
              private router: Router, 
              private verifyService: VerifyLogoutService, 
              private viewUserInformationService: ViewUserService) {
    this.logInStatus = false;
    this.currentUser = localStorage.getItem('userName');
    this.userUrl = 'http://localhost:8080/user/update-user-information';

   }

  ngOnInit(): void {
    this.logInStatus = this.verifyService.verifyLoggedIn();

    this.viewUserInformationService.getUserById(localStorage.getItem('id')).subscribe((data: UserEntity) => {
      this.userEntity = data;
    })  
    this.viewUserInformationService.getUserInformationByUserId(localStorage.getItem('id')).subscribe((data: UserInformation) => {
      this.userInformation = data;
      console.log(this.userInformation)
    })
  }

  updateUserInfo( userDetails: NgForm ) {

    let userInfo: UserInfoDTO = {
      userId: this.userEntity.id,
      firstName: userDetails.value.firstName,
      lastName: userDetails.value.lastName, 
      neigborhood: userDetails.value.neigborhood,
      city: userDetails.value.city,
      state: userDetails.value.state
    }

    this.http.post(this.userUrl, userInfo).subscribe((response: UserInformation) => {
        this.userInformation = response
        console.log(this.userInformation)
        this.changeInfo=true;
    });

  }

  

  editProfileDetails() {
    this.changeInfo=false;
  }


  logOut() {
    localStorage.removeItem('userName');
    localStorage.removeItem('id')
    this.logInStatus = false;
    this.router.navigate(["/login"])
    return;
  }

}
