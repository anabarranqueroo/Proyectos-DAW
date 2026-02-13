import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Factura } from '../modelos/factura';
import { Detalle } from '../modelos/detalle';
import { consumerBeforeComputation } from '@angular/core/primitives/signals';

@Injectable({
  providedIn: 'root',
})

export class ServicioFacturas {
  private url: string = 'http://localhost/serviciosWeb/facturas/servidor.php';

  constructor(private http: HttpClient){
  }

  //Facturas

  listarFacturas(){
    let pa = JSON.stringify({
      servicio: 'facturas'
    });
    return this.http.post<Factura[]>(this.url, pa);
  }

  insertarFacturas(factura: any){
    let pa = JSON.stringify({
      servicio: 'anadeFactura',
      numero: factura.numero,
      fecha: factura.fecha,
      id_cliente: factura.id_cliente
    });
    return this.http.post<any>(this.url, pa);
  }

  //Detalles Facturas

  detalleFactura(idFactura: number){
    let pa = JSON.stringify({
      servicio: 'detalle',
      idFactura: idFactura
    });
    return this.http.post<Detalle[]>(this.url, pa);
  }

  añadirDetalle(detalle: any){
    let pa = JSON.stringify({
      servicio: 'anade',
      idFactura: detalle.id_factura,
      cantidad: detalle.cantidad,
      concepto: detalle.concepto,
      precio: detalle.precio,
      tipo_iva: detalle.tipo_iva
    });
    return this.http.post<any>(this.url, pa);
  }

  borrarDetalle(id: number, idFactura: number){
    let pa = JSON.stringify({
      servicio: 'borra',
      id: id,
      idFactura: idFactura
    });
    return this.http.post<Detalle[]>(this.url, pa);
  }

   modificarDetalle(detalle: Detalle) {
    let pa = JSON.stringify({
      servicio: 'modificarDetalle',
      id: detalle.id,
      cantidad: detalle.cantidad,
      concepto: detalle.concepto,
      precio: detalle.precio,
      tipo_iva: detalle.tipo_iva,
      idFactura: detalle.id_factura
    });
    return this.http.post<Detalle[]>(this.url, pa);
  }

  seleccionarDetallePorId(id: number) {
    let pa = JSON.stringify({
      servicio: 'selDetalleID',
      id: id
    });
    return this.http.post<Detalle>(this.url, pa);
  }
}
