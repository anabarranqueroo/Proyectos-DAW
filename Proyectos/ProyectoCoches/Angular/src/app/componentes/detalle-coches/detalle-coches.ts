import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CommonModule, DatePipe, Location } from '@angular/common';
import { CocheService } from '../../servicios/coche-servicio';
import { ModeloService } from '../../servicios/modelo-servicio';
import { Coche } from '../../modelos/coche';

@Component({
  selector: 'app-detalle-coches',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './detalle-coches.html',
  styleUrls: ['./detalle-coches.css'],
  providers: [DatePipe]
})
export class DetalleCoches implements OnInit {

  coche!: Coche;

  constructor(
    private route: ActivatedRoute,
    private cocheService: CocheService,
    private modeloService: ModeloService,
    private datePipe: DatePipe,
    private location: Location
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('idCoche'));
    if (id) {
      this.cargarCoche(id);
    }
  }

  cargarCoche(id: number): void {
    this.cocheService.obtenerCoche(id).subscribe({
      next: data => this.coche = data,
      error: err => console.error('Error al cargar coche', err)
    });
  }

  borrarModelo(modeloId: number): void {
    if (confirm('¿Seguro que deseas eliminar este modelo?') && this.coche.id != null) {
      this.modeloService.borrarModelo(this.coche.id, modeloId).subscribe(() => {
        this.cargarCoche(this.coche.id!);
      });
    }
  }

  getYear(fecha: string): string {
    return this.datePipe.transform(fecha, 'yyyy') || '';
  }

  volver(): void {
    this.location.back();
  }
}