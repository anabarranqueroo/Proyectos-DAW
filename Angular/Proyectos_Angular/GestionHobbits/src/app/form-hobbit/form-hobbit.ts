import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Hobbit } from '../hobbit';
import { Router, RouterLink, ActivatedRoute } from "@angular/router";
import { Datos } from '../datos';


@Component({
  selector: 'app-g-hobbit',
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './form-hobbit.html',
  styleUrl: './form-hobbit.css',
})
export class FormHobbit {
  public lista: Hobbit[];
  public hobbit: Hobbit;
  public accion: { id: number, nombre: string, indice: number };
  public fechaStr: string = "";

  constructor(private datos: Datos, private ruta: Router, private rutaActiva: ActivatedRoute) {
    this.hobbit = {} as Hobbit;
    this.accion = { id: 1, nombre: "Añadir", indice: -1 };
    this.lista = this.datos.listar();
  }

  ngOnInit() {
    const indice = this.rutaActiva.snapshot.params["indice"];
    if (indice != -1) {
      this.hobbit = this.datos.obtenerHobbit(indice);
      this.fechaStr = this.obtenerFechaStr(this.hobbit.fechaNacimiento);
      this.accion = { id: 2, nombre: "Modificar", indice: indice }
    }else{
      this.hobbit = {} as Hobbit;
      this.fechaStr = "";
    }
  }

  obtenerFechaStr(fecha: Date){
    const offset = fecha.getTimezoneOffset();
    fecha = new Date(fecha.getTime() - (offset*60*1000));
    console.log("Fecha.toString: ", fecha.toISOString());
    return fecha.toISOString().split('T')[0];
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

    if (this.fechaStr) {
      this.hobbit.fechaNacimiento = new Date(this.fechaStr);
    }

    if (isNaN(this.hobbit.estatura)) {
      return;
    }

    if (this.accion.id == 1) {
      this.datos.insertar(this.hobbit);
    } else {
      this.datos.modificar(this.hobbit, this.accion.indice);
    }

    this.accion = { id: 1, nombre: "Añadir", indice: -1 };
    this.ruta.navigate(['/']);
    console.log(this.hobbit);
    this.hobbit = {} as Hobbit;
    hobbitForm.resetForm();
  }

}
