import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ThemeserviceService {
  constructor() { 
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
}
