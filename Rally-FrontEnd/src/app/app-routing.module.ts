import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginUserComponent } from './user-profile-arm/login-register/login-user/login-user.component';
import { RegisterUserComponent } from './user-profile-arm/login-register/register-user/register-user.component';
import { UserProfileComponent } from './user-profile-arm/user-profile/user-profile/user-profile.component';
<<<<<<< HEAD
import { EventViewComponent } from './event-view/event-view.component';

=======
import { DropdownMenuComponent } from './user-profile-arm/experiments/dropdown-menu/dropdown-menu.component';
import { ForumComponent } from './community-forum-arm/forum/forum.component';
import { CommunityHomeComponent } from './community-forum-arm/community-home/community-home.component';
>>>>>>> f3e149a3e2bed74073d596ae0b3af9e310d0d3ab


const routes: Routes = [
  {path: 'login', component: LoginUserComponent},
  {path: 'register', component: RegisterUserComponent},
  {path: 'myProfile', component: UserProfileComponent},
<<<<<<< HEAD
  {path: 'events', component: EventViewComponent}
=======
  {path: 'testing', component: DropdownMenuComponent},
  {path: 'forum', component: ForumComponent},
  {path: 'communityHomeForum', component: CommunityHomeComponent}
>>>>>>> f3e149a3e2bed74073d596ae0b3af9e310d0d3ab

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
