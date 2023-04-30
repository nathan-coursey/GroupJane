import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserEntity } from '../../models/UserEntity';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ViewUserService {

  private getUserListUrl = 'http://localhost:8080/user/search'
  private searchUserByIdUrl = 'http://localhost:8080/user/searchid/';
  private searchUserByUserNameUrl = 'http://localhost:8080/user/searchUserName/';
  private searchUserInformationByIdUrl = 'http://localhost:8080/user/userinfo/';
  private searchUserInformationByUserIdUrl= 'http://localhost:8080/user/getUserInformationByUserId/'

  constructor(private http: HttpClient, private router: Router) { }

  getUserList(): Observable<UserEntity[]>{
    return this.http.get<UserEntity[]>(`${this.getUserListUrl}`);
  }

  getUserById(id: string) {
    return this.http.get(`${this.searchUserByIdUrl}` + id);
  }

  getUserByUserName(userName: string) {
    return this.http.get(`${this.searchUserByUserNameUrl}` + userName);
  }

  getClassUserInformation(id: string) {
    return this.http.get(`${this.searchUserInformationByIdUrl}` + id);
  }

  getUserInformationByUserId(id: string) {
    return this.http.get(`${this.searchUserInformationByUserIdUrl}` + id);
  }



  redirectWhenViewingSelf(userName) {
    if (localStorage.getItem('userName') === userName) {
      this.router.navigate(["/myProfile"])
      return;
    }
  }

}
