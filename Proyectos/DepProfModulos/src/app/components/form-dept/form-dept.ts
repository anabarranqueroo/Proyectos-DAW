import { Component } from '@angular/core';
import { Departamento } from '../../models/departamento';
import { Location } from '@angular/common';
import { FormGroup, FormsModule, FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink, Router, ActivatedRoute } from '@angular/router';
import { ServicioDepartamentos } from '../../services/servicio-dept';

@Component({
  selector: 'app-form-dept',
  standalone: false,
  templateUrl: './form-dept.html',
  styleUrl: './form-dept.css',
})
export class FormDept {
  //Formulario reactivo
 form: FormGroup;
 public departamento: Departamento = <Departamento>{};
 idDept!: number;
 public titulo: string = "Añadir Departamento";

 constructor(private location: Location, private route: ActivatedRoute, private fb: FormBuilder, private servicioDept: ServicioDepartamentos, private ruta: Router){
  this.form = this.fb.group({
    id: this.fb.control(-1),
    nombre: this.fb.control("", [Validators.required, Validators.minLength(2)]),
    descripcion: this.fb.control("", [Validators.required, Validators.minLength(2)])
  });
 }

 envio(){
  console.log("Aquí añado departamentos: ", this.form.value);
  const dept={
    id: this.form.value.id,
    nombre: this.form.value.nombre,
    descripcion: this.form.value.descripcion
  }

  if(this.form.value.id == -1){
    this.titulo = "Añadir departamento";

    this.servicioDept.anadirDept(dept).subscribe({
      next: dep => {
        console.log("dep,", dep);
        this.ruta.navigate(['/']);
      },
      error: error => console.log("Error", error)
  });
  }else{
    this.titulo = "Modificar departamento";
    this.servicioDept.modificarDept(dept).subscribe({
      next: dep =>{
        console.log("Departamento modificado", dep);
        this.ruta.navigate(['/'])
      },
      error: (error) => console.log('Error', error),
    });
  }

 }

 volver(){
  this.location.back();
 }

 ngOnInit(){
  const deptId = this.route.snapshot.params["idDept"];

  if(deptId == -1){
    this.titulo = "Añadir departamento";
  }else{
    this.titulo = "Modificar departamento";
    this.servicioDept.selDeptID(deptId).subscribe({
      next: datos =>{
        this.form.patchValue(datos);
      },
      error: error => console.log("Error", error)
    });
  }
 }
}
