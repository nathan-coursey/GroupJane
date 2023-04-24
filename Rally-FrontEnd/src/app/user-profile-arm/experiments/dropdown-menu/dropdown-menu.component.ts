import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dropdown-menu',
  templateUrl: './dropdown-menu.component.html',
  styleUrls: ['./dropdown-menu.component.css']
})
export class DropdownMenuComponent implements OnInit {

  dropdownBtn;
  dropdownMenu;
  toggleArrow;
  
  constructor() {
    this.dropdownBtn = document.getElementById("btn");
    this.dropdownMenu = document.getElementById("dropdown");
    this.toggleArrow = document.getElementById("arrow");
   }

  ngOnInit(): void {
  }

  toggleDropdown() {
    this.dropdownMenu.classList.toggle("show");
    this.toggleArrow.classList.toggle("arrow");
  };

  dropDown() {
    this.toggleDropdown();
  }

}
