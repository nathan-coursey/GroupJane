import { TestBed } from '@angular/core/testing';

import { ValidateViewUserService } from './validate-view-user.service';

describe('ValidateViewUserService', () => {
  let service: ValidateViewUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ValidateViewUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
