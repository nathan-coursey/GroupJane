import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css']
})
export class OfferComponent implements OnInit {

  private userUrl: string;
  currentUser;
  logInStatus: Boolean;

  constructor(private http: HttpClient, private router: Router) {
    this.logInStatus = false;
    this.userUrl = 'http://localhost:8080/service/offer';
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

  onSubmit(f: NgForm ) {//attempting to send form to Back End but not working
    this.http.post(this.userUrl, f.value).subscribe((res => {
      this.ngOnInit() //reload form
    }))

}
}
