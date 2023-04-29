import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from '../../models/dto/LoginDTO';
import { NgForm } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { ViewUserService } from '../../user-profile/user-services/view-user.service';
import { UserEntity } from '../../models/UserEntity';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  userList: UserEntity[];
  private userUrl: string;
  incorrectPassword: boolean;
  userEntity: UserEntity;

  constructor(private http: HttpClient,
              private router: Router, 
              private findUser: ViewUserService) 
              { 
    this.userUrl = 'http://localhost:8080/api/login';
  }


  ngOnInit(): void {
    this.findUser.getUserList().subscribe((response: UserEntity[]) => {
      this.userList = response;
    })
  }

  login(userInformation: NgForm ) {
      
    this.incorrectPassword = false;

    let loginInfo: LoginDTO = {
      userName: userInformation.value.userName,
      password: userInformation.value.password
    }

    for (let i = 0; i < this.userList.length; i++) {
      if (this.userList[i].userName === loginInfo.userName) {
        localStorage.setItem('id', this.userList[i].id)
      }
    }

    this.http.post(this.userUrl, loginInfo).subscribe((res) => {
      for (const k in res){
        if (k == "failed"){
          this.incorrectPassword = true;
          localStorage.removeItem('id');
          return;
        }
        else if (k == "userName"){            
          localStorage.setItem(k, loginInfo.userName)
          this.router.navigate(["/myProfile"]);
        }
      } 
    });
    
    
  }
}
