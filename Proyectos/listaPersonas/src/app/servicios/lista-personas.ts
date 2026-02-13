import { Injectable } from '@angular/core';
import { Persona } from '../modelos/persona';
import { HttpClient } from '@angular/common/http';

//Una instancia del servicio disponible en toda la app
@Injectable({
  providedIn: 'root',
})

export class ListaPersonas {

  //Ruta del servidor.php
  private url: string = 'http://localhost/serviciosWeb/servidor.php';

 //Inyecta HttpClient para hacer peticiones
  constructor(private http: HttpClient) {}

  //metodo para obtener la lista de personas
  listar() {
    let pa = JSON.stringify({ 
      servicio: 'listar' 
    });
    //devuelve un observable de un array de Persona
    return this.http.post<Persona[]>(this.url, pa);
  }


  //metodo para insertar una persona 
  insertar(persona: Persona) {
    let pa = JSON.stringify({
      servicio: 'insertar',
      dni: persona.dni,
      nombre: persona.nombre,
      apellidos: persona.apellidos
    });
    console.log('Insertar persona', pa);
    return this.http.post<Persona[]>(this.url, pa);
  }

  //metodo para seleccionar una persona
  selPersonaID(id: number){
    let pa = JSON.stringify({
      servicio: "selPersonaID",
      id: id
    });
    return this.http.post<Persona>(this.url, pa);
  }

}
