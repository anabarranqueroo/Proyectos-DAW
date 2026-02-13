import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { RouterLink, Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { CocheService } from '../../servicios/coche-servicio';
import { Coche } from '../../modelos/coche';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-coche',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule, RouterLink],
  templateUrl: './form-coche.html',
  styleUrls: ['./form-coche.css']
})
export class FormCoche implements OnInit {

  form: FormGroup;
  coche: Coche = <Coche>{};
  idCoche!: number;
  titulo: string = 'Añadir Coche';

  constructor(
    private fb: FormBuilder,
    private cocheService: CocheService,
    private router: Router,
    private route: ActivatedRoute,
    private location: Location
  ) {
    this.form = this.fb.group({
      marca: this.fb.control('', [Validators.required, Validators.minLength(2)]),
      anoFabricacion: this.fb.control('', [Validators.required]),
      color: this.fb.control('', [Validators.required, Validators.minLength(2)]),
      precio: this.fb.control(0, [Validators.required, Validators.min(0)])
    });
  }

  ngOnInit(): void {
    this.idCoche = Number(this.route.snapshot.params['idCoche']);

    if (this.idCoche !== -1) {
      this.titulo = 'Modificar Coche';
      this.cocheService.obtenerCoche(this.idCoche).subscribe({
        next: data => {
          this.coche = data;
          this.form.patchValue({
            marca: data.marca,
            anoFabricacion: data.anoFabricacion,
            color: data.color,
            precio: data.precio
          });
        }
      });
    }
  }

  envio(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const cocheParaEnviar: any = {
      id: this.idCoche,
      marca: this.form.value.marca,
      anoFabricacion: this.form.value.anoFabricacion,
      color: this.form.value.color,
      precio: Number(this.form.value.precio),
      modelos: this.idCoche === -1 ? [] : this.coche.modelos
    };

    if (this.idCoche === -1) {
      this.cocheService.crearCoche(cocheParaEnviar).subscribe({
        next: () => this.router.navigate(['/']),
        error: err => console.error(err)
      });
    } else {
      this.cocheService.editarCoche(this.idCoche, cocheParaEnviar).subscribe({
        next: () => this.router.navigate(['/']),
        error: err => {
          console.error(err);
          alert("Error 500: El servidor no permite sobrescribir la lista de modelos. Revisa CocheService.java");
        }
      });
    }
  }

  volver(): void {
    this.location.back();
  }
}