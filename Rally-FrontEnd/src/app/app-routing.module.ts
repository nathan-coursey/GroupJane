import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginUserComponent } from './user-profile-arm/login-register/login-user/login-user.component';
import { RegisterUserComponent } from './user-profile-arm/login-register/register-user/register-user.component';
import { UserProfileComponent } from './user-profile-arm/user-profile/user-profile/user-profile.component';
import { DropdownMenuComponent } from './user-profile-arm/experiments/dropdown-menu/dropdown-menu.component';

const routes: Routes = [
  {path: 'login', component: LoginUserComponent},
  {path: 'register', component: RegisterUserComponent},
  {path: 'myProfile', component: UserProfileComponent},
  {path: 'testing', component: DropdownMenuComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
