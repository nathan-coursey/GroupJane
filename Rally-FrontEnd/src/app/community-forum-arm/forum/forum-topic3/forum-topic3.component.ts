import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ThemeserviceService } from '../../../services/themeservice.service';
import { NgForm } from '@angular/forms';
import { ForumPost } from '../../models/ForumPost';

@Component({
  selector: 'app-forum-topic3',
  templateUrl: './forum-topic3.component.html',
  styleUrls: ['./forum-topic3.component.css']
})
export class ForumTopic3Component implements OnInit {
  currentUser: String;
  logInStatus: Boolean;
  darktheme: Boolean;
  testArray: String[];
  createPostBoolean: boolean;
  constructor(private http: HttpClient, private router: Router, private themeservice: ThemeserviceService) {
    this.logInStatus = false;
    this.createPostBoolean = false;
    this.darktheme = false;
    this.testArray = ["Hello", "this", "is", "a", "test"];
   }
  
  ngOnInit(): void {
    this.verifyLoggedIn();
    this.checkTheme();
  }
  checkTheme(){
      if (localStorage.getItem('theme') == 'dark'){
          this.Dark();
      }
  }
  createPostButton(){
      this.createPostBoolean = true;
  }
  verifyLoggedIn() {
  
    if (localStorage.getItem('userName') != null) {
      this.currentUser = localStorage.getItem('userName');
      this.logInStatus = true;
    }
  
  }
  createPost(postInformation: NgForm){
      this.createPostBoolean = false;
      let postDetails: ForumPost = {
        title: postInformation.value.title,
        description: postInformation.value.description
      }
      this.http.post('http://localhost:8080/posts', postDetails).subscribe((res) => {
        console.log(res)
    });
  }
  Light(){
      this.themeservice.switchToLightTheme();
      this.darktheme = false;
  }
  Dark(){
    this.themeservice.switchToDarkTheme();
    this.darktheme = true;
  }
  logOut() {
    localStorage.removeItem('username');
    console.log(localStorage.getItem('userName'))
    this.logInStatus = false;
  }
}
