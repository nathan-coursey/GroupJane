import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValidateViewUserService {

  constructor() { }

  checkUserName(data: string) {
    const pattern = /^[a-zA-Z0-9] {3,25}$/i;
    return pattern.test(data);
  }
}
