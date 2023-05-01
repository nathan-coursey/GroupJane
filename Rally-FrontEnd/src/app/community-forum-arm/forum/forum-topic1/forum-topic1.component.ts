import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ThemeserviceService } from 'src/app/services/themeservice.service';

@Component({
  selector: 'app-forum-topic1',
  templateUrl: './forum-topic1.component.html',
  styleUrls: ['./forum-topic1.component.css']
})
export class ForumTopic1Component implements OnInit {
  forumTopic: string;
  currentUser: String;
  logInStatus: Boolean;
  darktheme: Boolean;
  testArray;
  createPostBoolean: boolean;
  constructor(private http: HttpClient, private router: Router, private themeservice: ThemeserviceService) {
    this.logInStatus = false;
    this.createPostBoolean = false;
    this.darktheme = false;
    this.testArray;
    this.forumTopic = "ForumTopic1";
   }
  
  ngOnInit(): void {
    this.verifyLoggedIn();
    this.checkTheme();
    this.getPosts();
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
      this.themeservice.createAPost(postInformation, this.forumTopic);
  }
  getPosts(){
    this.http.get(`http://localhost:8080/${this.forumTopic}`).subscribe((res)=>{
      console.log(res);
      this.testArray = res;
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
    console.log(localStorage.getItem('userName'));
    this.logInStatus = false;
  }

}
