import { Injectable } from '@angular/core';
import { Hobbit } from './hobbit';

@Injectable({
  providedIn: 'root',
})
export class Datos {
  private lista: Hobbit[];
  
  constructor(){
    this.lista = [
      { nombre: "Frodo", apellidos: "Bolsón", fechaNacimiento: new Date(1968, 8, 22), estatura: 106 },
      { nombre: "Samwise", apellidos: "Gamyi", fechaNacimiento: new Date(1980, 3, 6), estatura: 102 },
      { nombre: "Meriadoc", apellidos: "Brandigamo", fechaNacimiento: new Date(1982, 10, 4), estatura: 120 },
      { nombre: "Peregrin", apellidos: "Tuk", fechaNacimiento: new Date(1990, 2, 18), estatura: 119 },
      { nombre: "Rosie", apellidos: "Cottom", fechaNacimiento: new Date(2006, 6, 30), estatura: 98 }
    ];

  }

  listar(){
    return this.lista;
  }

  insertar(hobbit: Hobbit){
    this.lista.push(hobbit);
  }

  obtenerHobbit(indice: number){
    return this.lista[indice];
  }

  modificar(hobbit: Hobbit, indice: number){
    this.lista[indice] = hobbit;
  }

  eliminar(indice: number){
    this.lista.splice(indice,1);
  }
  
}
