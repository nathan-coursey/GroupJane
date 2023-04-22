import { Component, OnInit } from '@angular/core';
import { UserEntity } from '../../models/UserEntity';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
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
    this.loggedIn = false;
    this.http.get('http://localhost:8080/api/currentUser')
    .pipe(map((response) => {
      let user = [];
      for (let key in response){
        user.push(response[key]);
      }
      console.log(user + " array from what was pulled from response")
      return user;
    }))
    .subscribe((response) => {
      if(response.length != 0) {
        this.currentUser = response;
        this.loggedIn = true;
      }
    })
  }

  logOut() {
    this.http.get('http://localhost:8080/api/logout').subscribe((response) => {
      console.log(response)
    })
    this.loggedIn = false;
  }

}
