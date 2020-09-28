import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { environment } from './../environments/environment';
declare let gtag;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'dyson-angular';
  constructor(public router: Router) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        gtag('config', environment.GA_id, {'page_path':event.urlAfterRedirects});
      }
    });
  }

}
