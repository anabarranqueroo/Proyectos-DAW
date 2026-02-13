import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Persona } from '../../modelos/persona';
import { ListaPersonas } from '../../servicios/lista-personas';

@Component({
  selector: 'app-form-personas',
  imports: [RouterLink, FormsModule],
  templateUrl: './form-personas.html',
  styleUrl: './form-personas.css',
})

export class FormPersonas {
  //Crea una persona vacía
  public persona: Persona = <Persona>{};

  //metodo enviar, envia una persona llamando al metodo insertar y volviendo directamente al listado
  enviar(persona: Persona) {
    console.log('Formulario enviado', persona);
    this.listaPersonas.insertar(persona).subscribe({
      next: res => {
        console.log("Persona insertada", res);
        this.ruta.navigate(['/']);
      },
      error: error => console.log("Error ", error)  
  });
}

//Inyecta el servicio ListaPersonas, Router (navega), ActivatedRoute (lee el id de la URL)
constructor(private listaPersonas: ListaPersonas, private ruta: Router, private route: ActivatedRoute) {
  const personaId = this.route.snapshot.params['id']; //params id porque en app.routes.ts el path es .../:id
  console.log('Persona ID:', personaId);
 };

ngOnInit(){
}

}
