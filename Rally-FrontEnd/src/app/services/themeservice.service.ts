import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ForumPostDTO } from '../community-forum-arm/models/ForumPostDTO';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ThemeserviceService {
  constructor(private http: HttpClient) { 
  }

switchToLightTheme(){
    let background = document.getElementById('theme');
    let sections = document.querySelectorAll("body");
    sections.forEach((section) => {section.setAttribute('class', 'white-theme')});
    background.setAttribute('class', 'white');
    localStorage.setItem('theme', 'light');
}
switchToDarkTheme(){
  let background = document.getElementById('theme');
  let sections = document.querySelectorAll("body");
  sections.forEach((section) => {section.setAttribute('class', 'black-background')});
  background.setAttribute('class', 'black');
  localStorage.setItem('theme', 'dark');
}
createAPost(postInfo: NgForm, forumTopic: string){
  let postDetails: ForumPostDTO = {
    title: postInfo.value.title,
    description: postInfo.value.description,
    username: localStorage.getItem('userName')
  }
  this.http.post(`http://localhost:8080/${forumTopic}`, postDetails).subscribe((res) => {
    console.log(res)
});
window.location.reload();
}

}
