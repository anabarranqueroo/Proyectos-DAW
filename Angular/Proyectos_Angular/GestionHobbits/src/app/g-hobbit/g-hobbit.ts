import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Hobbit } from '../hobbit';
import { RouterLink } from "@angular/router";
import {Datos} from '../datos';


@Component({
  selector: 'app-g-hobbit',
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './g-hobbit.html',
  styleUrl: './g-hobbit.css',
})
export class GHobbit {
  public lista: Hobbit[];
  public hobbit: Hobbit;
  public accion: { id: number, nombre: string, indice: number };
  public fechaStr: string = "";

  constructor(private datos:Datos) {
    this.hobbit = {} as Hobbit;
/*
    this.lista = [
      { nombre: "Frodo", apellidos: "Bolsón", fechaNacimiento: new Date(1968, 8, 22), estatura: 106 },
      { nombre: "Samwise", apellidos: "Gamyi", fechaNacimiento: new Date(1980, 3, 6), estatura: 102 },
      { nombre: "Meriadoc", apellidos: "Brandigamo", fechaNacimiento: new Date(1982, 10, 4), estatura: 120 },
      { nombre: "Peregrin", apellidos: "Tuk", fechaNacimiento: new Date(1990, 2, 18), estatura: 119 },
      { nombre: "Rosie", apellidos: "Cottom", fechaNacimiento: new Date(2006, 6, 30), estatura: 98 }
    ];
*/
    this.accion = { id: 1, nombre: "Añadir", indice: -1 };
    this.lista = this.datos.listar();
  }

  calculoEdad(fechaNacimiento: Date): number {
    const hoy = new Date();
    let edad = new Date().getTime() - fechaNacimiento.getTime();
    edad = edad / (1000 * 60 * 60 * 24 * 365.25);

    return Math.trunc(edad);
  }

  AMohobbit(hobbitForm: NgForm) {

    if (this.hobbit.nombre.trim().length == 0) {
      this.hobbit.nombre = "";
      return;
    }

    if (this.hobbit.apellidos.trim().length == 0) {
      this.hobbit.apellidos = "";
      return;
    }

    if (typeof this.hobbit.fechaNacimiento === "string") {
      this.hobbit.fechaNacimiento = new Date(this.hobbit.fechaNacimiento);
    }

    if (isNaN(this.hobbit.estatura)) {
      return;
    }

    if (this.accion.id == 1) {
      this.lista.push(this.hobbit);
    } else {
      this.lista[this.accion.indice] = this.hobbit;
    }

    this.accion = { id: 1, nombre: "Añadir", indice: -1 };
    console.log(this.hobbit);
    this.hobbit = {} as Hobbit;
    hobbitForm.resetForm();
  }

  delHobbit(hobbit: Hobbit) {
    if (confirm("¿Eliminar a '" + hobbit.nombre + " " + hobbit.apellidos + "'?")) {
      const indice = this.lista.indexOf(hobbit);
      this.lista.splice(indice, 1);
    }
  }

  obtenerFechaStr(fecha: Date){
    const offset = fecha.getTimezoneOffset();
    fecha = new Date(fecha.getTime() - (offset*60*1000));
    console.log("Fecha.toString: ", fecha.toISOString());
    return fecha.toISOString().split('T')[0];
  }

  editHobbit(hobbit: Hobbit, indice: number) {
    this.hobbit = hobbit;
    this.accion.id = 2;
    this.accion.nombre = "Modificar";
    this.fechaStr = this.obtenerFechaStr(this.hobbit.fechaNacimiento);
    this.accion.indice = indice;
  }

  public mostrarForm = false;

  Form() {
    this.mostrarForm = !this.mostrarForm;
  }

}
