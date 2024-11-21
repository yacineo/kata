// app.component.ts
import {Component} from '@angular/core';
import {CommonModule} from '@angular/common';
import {KataComponent} from './kata/kata.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, KataComponent],
  providers: [],
  templateUrl: 'app.component.html',
})
export class AppComponent {
  title = "Frontend KATA";

  constructor() {
  }

}


