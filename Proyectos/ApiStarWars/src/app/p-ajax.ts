import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { People } from './people';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PAjax {
  //private urlPeople = 'http://swapi.dev/api/people/';
  //private urlPlanets = 'http://swapi.dev/api/planets/';
  private urlPeople = 'https://swapi.py4e.com/api/people/';
  private urlPlanets = 'https://swapi.py4e.com/api/planets/';

  constructor(private http: HttpClient) {}

  // Personajes
  listar(): Observable<People[]> {
    return this.http.get<any>(this.urlPeople).pipe(
      map(resp =>
        resp.results.map((p: any) => ({
          nombre: p.name,
          altura: p.height,
          peso: p.mass,
          cumpleanos: p.birth_year,
          genero: p.gender,
          planetaUrl: p.homeworld
        }))
      )
    );
  }

listarPagina(url: string) {
  console.log('PAjax: solicitando URL:', url);
  return this.http.get<any>(url).pipe(
    map(resp => {
      console.log('PAjax: respuesta de la API:', resp);
      return {
        results: resp.results.map((p: any) => ({
          nombre: p.name,
          altura: p.height,
          peso: p.mass,
          cumpleanos: p.birth_year,
          genero: p.gender,
          planetaUrl: p.homeworld
        })),
      next: resp.next || null,
      previous: resp.previous || null
    };
    })
  );
}



  // Planetas
  listarPlanetas(): Observable<any[]> {
    return this.http.get<any>(this.urlPlanets).pipe(
      map(resp => resp.results.map((p: any, index: number) => ({
        id: index + 1,  // asignamos un ID para usar en rutas
        name: p.name,
        population: p.population,
        gravity: p.gravity,
        climate: p.climate,
        terrain: p.terrain,
        rotation_period: p.rotation_period,
        orbital_period: p.orbital_period,
        diameter: p.diameter
      })))
    );
  }

  // Detalle de un planeta por ID (basado en la lista)
  obtenerPlaneta(id: number): Observable<any> {
    return this.listarPlanetas().pipe(
      map(planetas => planetas[id - 1])  // porque el id lo pusimos index+1
    );
  }
}
