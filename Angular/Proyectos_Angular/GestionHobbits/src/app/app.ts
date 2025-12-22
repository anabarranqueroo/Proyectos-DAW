import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GHobbit } from "./g-hobbit/g-hobbit";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, GHobbit],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('GestionHobbits');

  
}
