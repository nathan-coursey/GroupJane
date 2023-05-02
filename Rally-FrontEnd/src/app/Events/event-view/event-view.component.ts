import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventDTO } from '../models/DTO/EventDTO';

@Component({
  selector: 'app-event-view',
  templateUrl: './event-view.component.html',
  styleUrls: ['./event-view.component.css']
})
export class EventViewComponent implements OnInit {

  isLoading: boolean = true;

  currentUser;
  logInStatus: Boolean;
  // private eventsUrl: string;

  eventList: EventDTO[] = [];


  constructor(private http: HttpClient, private router: Router) {
    this.logInStatus = false;
    // this.eventsUrl = 'http://localhost:8080/events/'
    this.eventList;
   }

  ngOnInit(): void {
    this.verifyLoggedIn();
    // this.getEvents();
    this.fetchEvents();
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

  async fetchEvents() {

    let response = await fetch('http://localhost:8080/api/events', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': 'http://localhost:4200',
      }
    });

    let payload: EventDTO[] = await response.json();

    console.log("Response received with payload", payload);

    payload.forEach(obj => {
      let event = new EventDTO(obj.eventHost, obj.contactEmail, obj.eventTitle, obj.datetime, obj.eventAddress, obj.eventCategory, obj.description, obj.imageId)
      this.eventList.push(event);
    })
  }




  // getEvents() {
  //   this.http.get(this.eventsUrl).subscribe((res)=>{
  //     console.log(res);
  //   });
  // }
  

  }


  

