import { Component, OnInit } from '@angular/core';
import { UserEntity } from '../../models/UserEntity';
import { UserService } from './user.service';

@Component({
  selector: 'app-search-user',
  templateUrl: './search-user.component.html',
  styleUrls: ['./search-user.component.css']
})
export class SearchUserComponent implements OnInit {

  userList: UserEntity[]; 

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUserList().subscribe((data: UserEntity[]) => {
      console.log(data);
      this.userList = data;
    })
  }

}
