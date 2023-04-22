import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from '../../models/dto/LoginDTO';
import { AuthenticationFailed } from '../../exception/AuthenticationFailed';
import { UserEntity } from '../../models/UserEntity';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  private userUrl: string;
  incorrectPassword: boolean;
  currentUser: UserEntity;
  private response: AuthenticationFailed[];

  constructor(private http: HttpClient, private router: Router) { 
    this.userUrl = 'http://localhost:8080/api/login';
    this.response = [];
    this.incorrectPassword = false;
    this.currentUser = new UserEntity("Nope", "2")
  }

  ngOnInit(): void {
  }

  login(userInformation: NgForm ) {
      
      this.incorrectPassword = false;
      let loginInfo: LoginDTO = {
        userName: userInformation.value.userName,
        password: userInformation.value.password
      }

      this.http.post(this.userUrl, loginInfo).subscribe((res) => 
        {console.log(res)
        for (const k in res){
          if (k == "failed"){
            this.incorrectPassword = true;
          }
          else if (k == "userName"){
            this.router.navigate(["/myProfile"], {state: {data: res}})
          }
        }
      });

  }
}
