import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Factura } from '../../modelos/factura';
import { Location } from '@angular/common';
import { errorContext } from 'rxjs/internal/util/errorContext';
import { ServicioFacturas } from '../../servicios/servicio-facturas';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-facturas',
  imports: [RouterLink, FormsModule, ReactiveFormsModule],
  templateUrl: './form-facturas.html',
  styleUrl: './form-facturas.css',
})
export class FormFacturas {
/*FORMULARIO BÁSICO

  constructor(private servicioFacturas: ServicioFacturas, private route: ActivatedRoute, private ruta: Router){
    const facturaId = this.route.snapshot.params['id'];
    console.log("ID de la fcatura: ", facturaId);
  }

  public factura: Factura = <Factura>{};

  envio(factura: Factura){
    console.log("Formulario enviado: ", factura);
    this.servicioFacturas.insertarFacturas(factura).subscribe({
      next: factura => {
        console.log("Factura insertada: ", factura);
        this.ruta.navigate(['/']);
      },
      error: error => console.error("Error.", error)
    });
  }

  ngOnInit(){
    
  }
  FORMULARIO REACTIVO*/
  form: FormGroup;
  public factura: Factura = <Factura>{};

  constructor(private location: Location, private route: ActivatedRoute, private fb: FormBuilder, private servicioFacturas: ServicioFacturas, private ruta: Router){
    this.form = this.fb.group({
      id: this.fb.control(-1),
      numero: this.fb.control("", [Validators.required, Validators.minLength(6)]),
      id_cliente: this.fb.control("", [Validators.required]),
      fecha: this.fb.control("", [Validators.required])
    });
  }

  envio(){
    console.log("Aquí añado facturas: ", this.form.value);
    const factura={
      numero: this.form.value.numero,
      fecha: this.form.value.fecha,
      id_cliente: this.form.value.id_cliente
    }
    this.servicioFacturas.insertarFacturas(factura).subscribe({
      next: res => {
        console.log("res," , res);
       this.ruta.navigate(['/']);
      },
      error: error => console.log("Error", error)
    });
  }

    volver(){
    this.location.back();
  }

    ngOnInit(){
    
  }


}
