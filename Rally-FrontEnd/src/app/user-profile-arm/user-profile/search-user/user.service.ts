import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserEntity } from '../../models/UserEntity';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = 'http://localhost:8080/user/search'

  constructor(private http: HttpClient) { }

  getUserList(): Observable<UserEntity[]>{
    return this.http.get<UserEntity[]>(`${this.url}`)
  }

}
