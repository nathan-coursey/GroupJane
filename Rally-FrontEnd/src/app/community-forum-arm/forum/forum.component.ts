import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
currentUser: String;
logInStatus: Boolean;

constructor(private http: HttpClient, private router: Router) {
  this.logInStatus = false;
 }

ngOnInit(): void {
  this.verifyLoggedIn();
}

verifyLoggedIn() {

  if (localStorage.getItem('userName') != null) {
    this.currentUser = localStorage.getItem('userName');
    this.logInStatus = true;
  }

}

logOut() {
  localStorage.clear();
  console.log(localStorage.getItem('userName'))
  this.logInStatus = false;
}
}
