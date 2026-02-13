import { Component, OnInit } from '@angular/core';
import { Profesor } from '../../models/profesor';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { ServicioProfesores } from '../../services/servicio-prof';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form-prof',
  standalone: false,
  templateUrl: './form-prof.html',
  styleUrl: './form-prof.css',
})
export class FormProf implements OnInit {
  form: FormGroup;
  public profesores: Profesor = <Profesor>{};
  public titulo: string = "Nuevo profesor";

  constructor(private location: Location, private route: ActivatedRoute, private fb: FormBuilder, private servicioProf: ServicioProfesores, private ruta: Router) {
    this.form = this.fb.group({
      id_departamento: this.fb.control(-1),
      id: this.fb.control(-1),
      nombre: this.fb.control("", [Validators.required, Validators.minLength(2)]),
      apellidos: this.fb.control("", [Validators.required, Validators.minLength(2)]),
      dni: this.fb.control("", [Validators.required, Validators.minLength(9)]),
    });
  }

  ngOnInit() {
    const profId = this.route.snapshot.params["idProf"];
    const deptId = this.route.snapshot.params["idDept"];

    if (profId) {
      this.titulo = "Editar profesor";
      this.servicioProf.selProfId(profId).subscribe({
        next: datos => {
          this.form.patchValue(datos);
        },
        error: error => console.log("Error", error)
      });
    } else {
      this.titulo = "Nuevo profesor";
      this.form.patchValue({
        id_departamento: Number(deptId)
      });
    }
  }

  envio() {
    if (this.form.invalid) return;

    const prof = this.form.value;
    const idDept = prof.id_departamento;

    if (prof.id == -1) {
      this.servicioProf.insertarProf(prof, idDept).subscribe({
        next: () => {
          this.ruta.navigate(['/list-dept', idDept]);
        },
        error: (error) => console.log('Error', error),
      });
    } else {
      this.servicioProf.modificarProf(prof, idDept).subscribe({
        next: () => {
          this.ruta.navigate(['/list-dept', idDept]);
        },
        error: (error) => console.log('Error', error),
      });
    }
  }

  volver() {
    this.location.back();
  }
}