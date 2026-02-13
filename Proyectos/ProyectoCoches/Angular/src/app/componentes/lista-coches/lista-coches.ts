import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CocheService } from '../../servicios/coche-servicio';
import { Coche } from '../../modelos/coche';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-lista-coches',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './lista-coches.html',
  styleUrls: ['./lista-coches.css']
})
export class ListaCoches implements OnInit {

  coches: Coche[] = [];

  constructor(private cocheService: CocheService) {}

  ngOnInit(): void {
    this.cargarCoches();
  }

  cargarCoches(): void {
    this.cocheService.listarCoches().subscribe({
      next: data => this.coches = data,
      error: err => console.error('Error al cargar coches', err)
    });
  }

  borrarCoche(id: number){
    if (confirm('¿Seguro que deseas borrar este coche?')) {
      this.cocheService.borrarCoche(id).subscribe({
        next: () => this.cargarCoches(),
        error: err => console.error('Error al borrar coche', err)
      });
    }
  }
}