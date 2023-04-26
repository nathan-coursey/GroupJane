import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserEntity } from '../../models/UserEntity';
import { HttpClient } from '@angular/common/http';
import { ValidateViewUserService } from './validate-view-user.service';
import { SearchUserDTO } from '../../models/dto/SearchUserDTO';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-view-user-profile',
  templateUrl: './view-user-profile.component.html',
  styleUrls: ['./view-user-profile.component.css']
})
export class ViewUserProfileComponent implements OnInit, OnDestroy {

  usersUrl: string;
  viewUser: UserEntity;
  userName: string;
  private sub: any;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router, 
              private http: HttpClient) { 
    this.usersUrl = 'http://localhost:8080/user/search/this'
   }

  ngOnInit() {
    /** Allows me to view a page with a specific username from link*/
    this.sub = this.activatedRoute.paramMap.subscribe(params => {
    this.userName = params.get('userName');
    });

    console.log(this.userName)
    this.getUser(this.userName);
    
  }

  /** Get this get method working! */

  getUser(userName: string){
    console.log("did this run?")
    let userInfo: SearchUserDTO = {
      userName: userName
    }
    return this.http.get(this.usersUrl).subscribe(userInfo => console.log(userInfo))
  }


  ngOnDestroy() {
      this.sub.unsubscribe();
  }

}
