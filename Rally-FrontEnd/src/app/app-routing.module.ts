import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginUserComponent } from './user-profile-arm/login-register/login-user/login-user.component';
import { RegisterUserComponent } from './user-profile-arm/login-register/register-user/register-user.component';
import { UserProfileComponent } from './user-profile-arm/user-profile/user-profile-main/user-profile.component';
import { SearchUserComponent } from './user-profile-arm/user-profile/search-user/search-user.component';
import { ForumComponent } from './community-forum-arm/forum/forum.component';
import { CommunityHomeComponent } from './community-forum-arm/community-home/community-home.component';


const routes: Routes = [
  {path: 'login', component: LoginUserComponent},
  {path: 'register', component: RegisterUserComponent},
  {path: 'myProfile', component: UserProfileComponent},
  {path: 'search', component: SearchUserComponent},
  {path: 'forum', component: ForumComponent},
  {path: 'communityHomeForum', component: CommunityHomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
