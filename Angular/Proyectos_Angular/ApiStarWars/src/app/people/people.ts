import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { PAjax } from '../p-ajax';
import { People } from '../people';

@Component({
  selector: 'app-people',
  imports: [CommonModule, HttpClientModule, RouterLink],
  templateUrl: './people.html',
  styleUrls: ['./people.css']
})
export class people implements OnInit {
  public lista: People[] = [];
  public error: string = '';
  public planetas: any[] = [];
  public nextUrl: string | null = null;
  public prevUrl: string | null = null;
  private baseUrl = 'https://swapi.py4e.com/api/people/';

  constructor(private datos: PAjax) { }

  ngOnInit() {
    this.cargarPersonajes();
    this.cargarPlanetas();
  }

  cargarPersonajes(url: string = this.baseUrl) {
    console.log('Cargando personajes desde URL:', url); 
    this.datos.listarPagina(url).subscribe({
      next: (resp: any) => {
        console.log('Respuesta completa de la API:', resp);
        this.lista = resp.results;
        this.nextUrl = resp.next;
        this.prevUrl = resp.previous;
        console.log('Lista de personajes:', this.lista);
        console.log('nextUrl:', this.nextUrl, 'prevUrl:', this.prevUrl);
      },
      error: err => {
        console.error('Error cargando personajes: ', err);
        this.error = 'No se pudieron cargar los personajes.';
      }
    });
}

  cargarPlanetas() {
    this.datos.listarPlanetas().subscribe({
      next: data => this.planetas = data,
      error: err => console.error('Error cargando planetas:', err)
    });
  }

  getPlanetaId(url: string | undefined): number | null {
    if (!url) return null;
    const parts = url.split('/').filter(Boolean);
    return Number(parts[parts.length - 1]);
  }

  getPlanetaName(url: string | undefined): string {
    if (!url) return '';
    const id = this.getPlanetaId(url);
    const planeta = this.planetas.find(p => p.id === id);
    return planeta ? planeta.name : '';
  }

  siguiente() {
    if (this.nextUrl) {
      this.cargarPersonajes(this.nextUrl);
    }
  }

  anterior() {
    if (this.prevUrl) {
      this.cargarPersonajes(this.prevUrl);
    }
  }
}
