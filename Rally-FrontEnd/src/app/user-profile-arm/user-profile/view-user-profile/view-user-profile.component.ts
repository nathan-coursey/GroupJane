import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserEntity } from '../../models/UserEntity';
import { ViewUserService } from './view-user.service';
import { VerifyLogoutService } from '../../security/verify-logout.service';
@Component({
  selector: 'app-view-user-profile',
  templateUrl: './view-user-profile.component.html',
  styleUrls: ['./view-user-profile.component.css']
})
export class ViewUserProfileComponent implements OnInit, OnDestroy {

  logInStatus: Boolean;
  user: UserEntity;
  userName: string;
  private sub: any;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router, 
              private viewUser: ViewUserService,
              private verifyService: VerifyLogoutService) {
      this.logInStatus = false;
   }

  ngOnInit() {
    this.logInStatus = this.verifyService.verifyLoggedIn();

    /* Allows me to view a page with a specific username from link from search-user.component.html */
    this.sub = this.activatedRoute.paramMap.subscribe(params => {
    this.userName = params.get('userName');
    });

    this.viewUser.redirectWhenViewingSelf(this.userName);
    
    /* Temp Solution, need to find out how to get only target user */
    this.viewUser.getUserList().subscribe((data) => {
      for (let i = 0; i < data.length; i++) {
        if (data[i].userName === this.userName) {
          this.user = data[i];
        }
      }
    }) 

  }

  logOut() {
    localStorage.clear();
    this.logInStatus = false;
    this.router.navigate(["/login"])
    return;
  }

  

  ngOnDestroy() {
      this.sub.unsubscribe();
  }

}
