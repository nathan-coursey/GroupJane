import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from '../../models/dto/LoginDTO';
import { NgForm } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  private userUrl: string;
  incorrectPassword: boolean;
  cookieValue;

  constructor(private http: HttpClient,
              private router: Router, 
              private cookieService: CookieService) 
              { 
    this.userUrl = 'http://localhost:8080/api/login';
    // cookie tests
    this.cookieService.set('Test', 'Hello World');
    this.cookieValue = this.cookieService.get('Test');
  }


  ngOnInit(): void {
  }

  login(userInformation: NgForm ) {
      
      this.incorrectPassword = false;
      let loginInfo: LoginDTO = {
        userName: userInformation.value.userName,
        password: userInformation.value.password
      }

      this.http.post(this.userUrl, loginInfo).subscribe((res) => {
        console.log(res)
          for (const k in res){
            if (k == "failed"){
              this.incorrectPassword = true;
            }
            else if (k == "userName"){

              // wish list: localStorage.setItem(loginInfo.userName.toString(), loginInfo.password.toString());
              localStorage.setItem(k, loginInfo.userName)
              console.log(k);
              this.router.navigate(["/myProfile"])
            }
          }
      });

  }
}
