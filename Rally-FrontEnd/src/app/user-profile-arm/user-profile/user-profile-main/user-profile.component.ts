import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { VerifyLogoutService } from 'src/app/user-profile-arm/security/verify-logout.service';
import { UserInfoDTO } from '../../models/dto/UserInfoDTO';
import { NgForm } from '@angular/forms';
import { UserInformation } from '../../models/UserInformation';
import { ViewUserService } from '../services/view-user.service';
import { UserEntity } from '../../models/UserEntity';
import { MainUserBundle } from '../../models/MainUserBundle';
import { DirectMessage } from '../../models/Directmessage';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  currentUser = localStorage.getItem('userName');
  userEntity: UserEntity;
  userInformation: UserInformation;
  mainUserBundle: MainUserBundle;
  userEntityDmList: UserEntity[];
  allDmHistory: DirectMessage[];
  converstation: DirectMessage[] = [];

  logInStatus = false;
  changeInfo = true;
  userDms = true;

  private userUrl: string = 'http://localhost:8080/user/update-user-information';

  

  constructor(private http: HttpClient, 
              private router: Router, 
              private verifyService: VerifyLogoutService, 
              private activeUserService: ViewUserService) {
   }

  ngOnInit(): void {
    this.logInStatus = this.verifyService.verifyLoggedIn();
    
    if (localStorage.getItem('id') !== null) {

      /* Get user information and user entity data */
      this.activeUserService.getMainUserBundleByUserName(localStorage.getItem('userName')).subscribe((data: MainUserBundle) => {
        this.mainUserBundle = data;
        this.userInformation = this.mainUserBundle.viewUserInformation;
      })

      /* Get user entities that have dm history with active user */
      this.activeUserService.getDmHistoryUsers(localStorage.getItem('id')).subscribe((response: UserEntity[]) => {
        this.userEntityDmList = response;
        let remove: UserEntity;

        for (let i = 0; i < this.userEntityDmList.length; i++) {
          if (localStorage.getItem('userName') === this.userEntityDmList[i].userName) {
            remove = this.userEntityDmList[i];
          }
        }
        this.userEntityDmList = this.userEntityDmList.filter((user: UserEntity) => user !== remove);
      })

      /* Get all user message dm history */
      this.activeUserService.getDmHistoryDirectMessages(localStorage.getItem('id')).subscribe((response: DirectMessage[]) => {
        this.allDmHistory = response;
      })
    }
  }

  displayConversation( userDms: UserEntity) {
    this.converstation = [];
    
    for (let i = 0; i < this.allDmHistory.length; i++) {
      if (userDms.userName == this.allDmHistory[i].sentByUserName) {
        this.converstation.push(this.allDmHistory[i]);
      } else if (userDms.userName == this.allDmHistory[i].receivedByUserName) {
        this.converstation.push(this.allDmHistory[i]);
      }
    }
    this.userDms = false;

  }


  updateUserInfo( userDetails: NgForm ) {

    let userInfo: UserInfoDTO = {
      userId: Number(this.mainUserBundle.mainUser.id),
      firstName: userDetails.value.firstName,
      lastName: userDetails.value.lastName, 
      neigborhood: userDetails.value.neigborhood,
      city: userDetails.value.city,
      state: userDetails.value.state
    }

    this.http.post(this.userUrl, userInfo).subscribe((response: UserInformation) => {
        this.userInformation = response
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
