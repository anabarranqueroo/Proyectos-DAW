import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-mi-componente',
  imports: [FormsModule],
  templateUrl: './mi-componente.html',
  styleUrl: './mi-componente.css',
})
export class MiComponente {
  public entrada: string;

  constructor(){
    this.entrada = "Mi entrada";
  }

  eventoEntrada(){
    this.entrada = "Valor nuevo de la entrada";
  }
  

}
