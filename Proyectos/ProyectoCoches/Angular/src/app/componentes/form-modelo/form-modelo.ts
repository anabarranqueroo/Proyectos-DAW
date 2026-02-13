import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CommonModule, Location } from '@angular/common';
import { ModeloService } from '../../servicios/modelo-servicio';
import { Modelo } from '../../modelos/modelo';

@Component({
  selector: 'app-form-modelo',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './form-modelo.html',
  styleUrls: ['./form-modelo.css']
})
export class FormModelo implements OnInit {

  form: FormGroup;
  titulo: string = 'Añadir Modelo';
  idCoche!: number;
  idModelo!: number;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private modeloService: ModeloService,
    private location: Location
  ) {
    this.form = this.fb.group({
      nombre: this.fb.control('', [Validators.required, Validators.minLength(2)])
    });
  }

  ngOnInit(): void {
    this.idCoche = Number(this.route.snapshot.paramMap.get('idCoche'));
    const idModParam = this.route.snapshot.paramMap.get('idModelo');
    this.idModelo = idModParam ? Number(idModParam) : -1;

    if (this.idModelo !== -1) {
      this.titulo = 'Editar Modelo';
      this.modeloService.obtenerModelo(this.idCoche, this.idModelo).subscribe({
        next: data => {
          this.form.patchValue({ nombre: data.nombre });
        },
        error: err => console.error('Error al cargar modelo', err)
      });
    }
  }

  envio(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const modeloParaEnviar: Modelo = {
      nombre: this.form.value.nombre
    } as Modelo;

    if (this.idModelo === -1) {
      this.modeloService.crearModelo(this.idCoche, modeloParaEnviar).subscribe({
        next: () => this.router.navigate(['/detalle', this.idCoche]),
        error: err => console.error('Error al crear', err)
      });
    } else {
      modeloParaEnviar.id = this.idModelo;
      this.modeloService.editarModelo(this.idCoche, this.idModelo, modeloParaEnviar).subscribe({
        next: () => this.router.navigate(['/detalle', this.idCoche]),
        error: err => console.error('Error al editar', err)
      });
    }
  }

  volver(): void {
    this.location.back();
  }
}