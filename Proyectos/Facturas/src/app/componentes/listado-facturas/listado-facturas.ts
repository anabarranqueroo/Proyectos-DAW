import { Component } from '@angular/core';
import { Factura } from '../../modelos/factura';
import { ServicioFacturas } from '../../servicios/servicio-facturas';
import { RouterLink, Router } from '@angular/router';

@Component({
  selector: 'app-listado-facturas',
  imports: [RouterLink],
  templateUrl: './listado-facturas.html',
  styleUrl: './listado-facturas.css',
})
export class ListadoFacturas {
public listaFacturas: Factura[] = [];

  constructor(private servicio: ServicioFacturas, private ruta: Router){
    this.servicio.listarFacturas().subscribe({
      next: facturas => {
        console.log("Facturas: ", facturas);
        this.listaFacturas = facturas;
      },
      error: error => console.error('Error al obtener las facturas', error)
    });
  }
}
