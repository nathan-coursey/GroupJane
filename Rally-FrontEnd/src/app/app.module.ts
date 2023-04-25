import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterUserComponent } from './user-profile-arm/login-register/register-user/register-user.component';
import { LoginUserComponent } from './user-profile-arm/login-register/login-user/login-user.component';
import { UserProfileComponent } from './user-profile-arm/user-profile/user-profile/user-profile.component';
import { FormsModule } from '@angular/forms';
import { SearchUserComponent } from './user-profile-arm/user-profile/search-user/search-user.component';
import { HttpClientModule } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { ExperimentalComponent } from './user-profile-arm/experiments/experimental/experimental.component';
<<<<<<< HEAD
import { EventViewComponent } from './event-view/event-view.component';
=======
import { DropdownMenuComponent } from './user-profile-arm/experiments/dropdown-menu/dropdown-menu.component';
import { ForumComponent } from './community-forum-arm/forum/forum.component';
import { CommunityHomeComponent } from './community-forum-arm/community-home/community-home.component';
>>>>>>> f3e149a3e2bed74073d596ae0b3af9e310d0d3ab

@NgModule({
  declarations: [
    AppComponent,
    RegisterUserComponent,
    LoginUserComponent,
    UserProfileComponent,
    SearchUserComponent,
    ExperimentalComponent,
<<<<<<< HEAD
    EventViewComponent,
=======
    DropdownMenuComponent,
    ForumComponent,
    CommunityHomeComponent,
>>>>>>> f3e149a3e2bed74073d596ae0b3af9e310d0d3ab
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }