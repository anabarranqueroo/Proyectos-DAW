import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MiComponente } from "./mi-componente/mi-componente";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MiComponente],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('bootcamp-angular');

  variable = "Mi Variable";

  eventoClick(){
    console.log("Llega al evento click");

    this.variable = "Valor nuevo";
  }


}
