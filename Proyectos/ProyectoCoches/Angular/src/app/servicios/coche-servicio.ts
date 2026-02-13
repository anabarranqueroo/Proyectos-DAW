import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Coche } from '../modelos/coche';

@Injectable({
  providedIn: 'root'
})
export class CocheService {

  private baseUrl = 'http://localhost:8081/api/coches';

  constructor(private http: HttpClient) { }

  listarCoches(): Observable<Coche[]> {
    return this.http.get<Coche[]>(this.baseUrl);
  }

  obtenerCoche(id: number): Observable<Coche> {
    return this.http.get<Coche>(`${this.baseUrl}/${id}`);
  }

  crearCoche(coche: Coche): Observable<Coche> {
    return this.http.post<Coche>(this.baseUrl, coche);
  }

  editarCoche(id: number, coche: Coche): Observable<Coche> {
    return this.http.put<Coche>(`${this.baseUrl}/${id}`, coche);
  }

  borrarCoche(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}