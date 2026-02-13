import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Cabecera } from './componentes/cabecera/cabecera';

//Importamos el componete cabecera y añadimos la etiqueta <app-cabecera></app-cabecera> en el app.html
@Component({
  selector: 'app-root',
  imports: [RouterOutlet,Cabecera],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ListaPersonas');
}
