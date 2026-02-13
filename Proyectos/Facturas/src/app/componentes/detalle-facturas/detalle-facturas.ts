import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from "@angular/router";
import { Factura } from '../../modelos/factura';
import { ServicioFacturas } from '../../servicios/servicio-facturas';
import { NgForOf } from '@angular/common';
import { Detalle } from '../../modelos/detalle';

@Component({
  selector: 'app-detalle-facturas',
  imports: [RouterLink, NgForOf],
  templateUrl: './detalle-facturas.html',
  styleUrl: './detalle-facturas.css',
})
export class DetalleFacturas {
  public titulo: string = "Añadir detalle";
  public factura: Factura = <Factura>{};
  public detalles: Detalle[] = [];
  private idFactura!: number;

  constructor(private ruta: Router,private route: ActivatedRoute, private servicioFactura: ServicioFacturas){}

  ngOnInit(){
    const idFactura = this.route.snapshot.params["id"];
    this.idFactura = Number(idFactura);

    this.servicioFactura.listarFacturas().subscribe({
      next: datos =>{
        this.factura = datos.find(f => f.id == this.idFactura)!;
        console.log("factura: ", this.factura);
        //find para decir que busque a que tiene el id igual al id de la url
      },
      error: error => console.log("Error factura", error)
    });

    this.servicioFactura.detalleFactura(this.idFactura).subscribe({
      next: datos => {
        this.detalles = datos;
        console.log("Detalles: ", this.detalles);
      },
      error: error => console.log("Error en los detalles", error)
    });    
  }

  //Para coger el idFactura
  anadirDetalle(){
    this.ruta.navigate(['/form-detalle', this.factura.id, -1]);
  }

  borrarDetalle(idDetalle: number){
    const confirmar = confirm("Desea borrarlo???");
    if(!confirmar){
      return;
    }
    
    this.servicioFactura.borrarDetalle(idDetalle, this.idFactura).subscribe({
      next: datos =>{
        this.detalles = datos;
        console.log("Detalle borrado");
      },
      error: error => console.log("Error al borrar", error)
    });
  }
  
}
