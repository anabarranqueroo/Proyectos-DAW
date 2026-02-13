import { Component } from '@angular/core';
import { Persona } from '../../modelos/persona';
import { ListaPersonas } from '../../servicios/lista-personas';
import { RouterLink, Router } from "@angular/router"; //router es para navegar programáticamente con navigate


@Component({
  selector: 'app-listado',
  imports: [RouterLink], 
  templateUrl: './listado.html',
  styleUrl: './listado.css',
})

export class Listado {
  public listaPer: Persona[] = [];

  //Inyecta el servicio ListaPersonas (hacer la petición Ajax) y Router (navegar)
  constructor(private peticion: ListaPersonas, private ruta: Router) { 
    this.peticion.listar().subscribe({
      next: personas => {
        console.log("personas", personas);
        this.listaPer = personas; 
      },
      error: error => console.error('Error al obtener la lista de personas', error)
    });

  }

  //Navega al formulario, usa -1 como id nuevo para no editar.
  irNuevaPersona() {
    this.ruta.navigate(['/formulario-personas', -1]);
  }

}
