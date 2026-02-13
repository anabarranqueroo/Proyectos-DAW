import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Modelo } from '../modelos/modelo';

@Injectable({
  providedIn: 'root'
})
export class ModeloService {

  private baseUrl = 'http://localhost:8081/api/coches';

  constructor(private http: HttpClient) { }

  listarModelos(cocheId: number): Observable<Modelo[]> {
    return this.http.get<Modelo[]>(`${this.baseUrl}/${cocheId}/modelos`);
  }

  crearModelo(cocheId: number, modelo: Modelo): Observable<Modelo> {
    return this.http.post<Modelo>(`${this.baseUrl}/${cocheId}/modelos`, modelo);
  }

  editarModelo(cocheId: number, modeloId: number, modelo: Modelo): Observable<Modelo> {
    return this.http.put<Modelo>(`${this.baseUrl}/${cocheId}/modelos/${modeloId}`, modelo);
  }

  borrarModelo(cocheId: number, modeloId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${cocheId}/modelos/${modeloId}`);
  }
  obtenerModelo(cocheId: number, modeloId: number): Observable<Modelo> {
  return this.http.get<Modelo>(`${this.baseUrl}/${cocheId}/modelos/${modeloId}`);
}
}