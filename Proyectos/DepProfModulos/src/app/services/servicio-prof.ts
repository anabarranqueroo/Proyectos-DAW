import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Departamento } from '../models/departamento';
import { Profesor } from '../models/profesor';

@Injectable({
  providedIn: 'root',
})
export class ServicioProfesores {
  private url: string = 'http://localhost/serviciosWeb/departamentos/deptosProfes.php';

  constructor(private http: HttpClient){}
  
  listarProf(idDept: number){
    let pa = JSON.stringify({
      servicio: 'profesores',
      id_departamento: idDept,
    });
    return this.http.post<Profesor[]>(this.url, pa);
  }

  insertarProf(profesor: Profesor, idDept: number){
    let pa = JSON.stringify({
      servicio: 'anadeProfe',
      id_departamento: idDept,
      dni: profesor.dni,
      nombre: profesor.nombre,
      apellidos: profesor.apellidos
    });
    return this.http.post<Profesor[]>(this.url, pa);
  }

  eliminarProf(profesor: Profesor, idDept: number){
    let pa = JSON.stringify({
      servicio: "eliminaProfe",
      id: profesor.id,
      id_departamento: idDept
    });
    return this.http.post<Profesor[]>(this.url, pa);
  }

 modificarProf(profesor: Profesor, idDept: number) {
    const pa = JSON.stringify({
      servicio: 'modificaProfe',
      id: profesor.id,
      id_departamento: idDept,
      dni: profesor.dni,
      nombre: profesor.nombre,
      apellidos: profesor.apellidos
    });
    return this.http.post<Profesor[]>(this.url, pa);
  }

  selProfId(idProf: number) {
    const pa = JSON.stringify({
      servicio: 'selProfeID',
      id: idProf,
    });
    return this.http.post<Profesor>(this.url, pa);
  }
}
