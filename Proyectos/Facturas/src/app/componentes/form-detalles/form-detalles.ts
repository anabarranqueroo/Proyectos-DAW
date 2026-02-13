import { Component } from '@angular/core';
import { ServicioFacturas } from '../../servicios/servicio-facturas';
import { Detalle } from '../../modelos/detalle';
import { FormBuilder, FormGroup, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ActivatedRoute, RouterLink, Router } from '@angular/router';
import { Validators } from '@angular/forms';
import { Location } from '@angular/common';

@Component({
  selector: 'app-form-detalles',
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './form-detalles.html',
  styleUrl: './form-detalles.css',
})
export class FormDetalles {
  form: FormGroup;
  public detalle: Detalle = <Detalle>{};
  idFactura!: number;
  public titulo: string ="Añadir detalle";

  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private servicioFacturas: ServicioFacturas,
    private ruta: Router,
  ) {
    this.form = this.fb.group({
      id: this.fb.control(-1),
      cantidad: this.fb.control('', [Validators.required]),
      concepto: this.fb.control('', [Validators.required, Validators.minLength(2)]),
      precio: this.fb.control('', [Validators.required]),
      tipo_iva: this.fb.control('', [Validators.required]),
    });
  }

  envio() {
    console.log('Aqui añado detalles, ', this.form.value);

    const detalle = {
      id: this.form.value.id,
      id_factura: this.idFactura,
      cantidad: this.form.value.cantidad,
      concepto: this.form.value.concepto,
      precio: this.form.value.precio,
      tipo_iva: this.form.value.tipo_iva,
    };
    console.log('Detalle enviado:', detalle);

    if (this.form.value.id == -1) {
      this.titulo = "Añadir detalle";

      this.servicioFacturas.añadirDetalle(detalle).subscribe({
        next: (datos) => {
          console.log('Detalle', datos);
          this.ruta.navigate(['/factura', this.idFactura]);
        },
        error: (error) => console.log('Error', error),
      });
    } else {
      this.titulo = "Modificar detalle";
      this.servicioFacturas.modificarDetalle(detalle).subscribe({
        next: (datos) => {
          console.log('Detalle modificado: ', datos);
          this.ruta.navigate(['/factura', this.idFactura]);
        },
        error: (error) => console.log('Error', error),
      });
    }
  }

  volver() {
    this.location.back();
  }

  ngOnInit() {
    //idFactura desde la url
    this.route.params.subscribe((params) => {
      this.idFactura = +params['idFactura'];
      const detalleId = +params['idDetalle'];

      if (detalleId == -1) {
        console.log('Añadiendo detalle');
        this.titulo = "Añadir detalle";
      } else {
        this.titulo = "Modificar detalle";
        this.servicioFacturas.seleccionarDetallePorId(detalleId).subscribe({
          next: (datos) => {
            this.form.patchValue(datos);
          },
          error: (error) => console.log('Error', error),
        });
      }
    });
  }
}
