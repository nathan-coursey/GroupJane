import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserEntity } from '../../models/UserEntity';
import { SearchUserDTO } from '../../models/dto/SearchUserDTO';
import { HttpClient } from '@angular/common/http';

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

  constructor(private activatedRoute: ActivatedRoute, private http: HttpClient) { 
    this.usersUrl = 'http://localhost:8080/user/search/this'
   }

  ngOnInit() {
    this.sub = this.activatedRoute.paramMap.subscribe(params => {
    this.userName = params.get('userName');
    });
    console.log(this.userName)
    
  }


  ngOnDestroy() {
      this.sub.unsubscribe();
  }

}
