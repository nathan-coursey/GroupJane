import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserEntity } from '../../models/UserEntity';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ViewUserService {

  private url = 'http://localhost:8080/user/search'

  constructor(private http: HttpClient, private router: Router) { }

  getUserList(): Observable<UserEntity[]>{
    return this.http.get<UserEntity[]>(`${this.url}`)
  }

  redirectWhenViewingSelf(userName) {
    if (localStorage.getItem('userName') === userName) {
      this.router.navigate(["/myProfile"])
      return;
    }
  }

}
