import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Departamento } from '../models/departamento';
import { Profesor } from '../models/profesor';

@Injectable({
  providedIn: 'root',
})
export class ServicioDepartamentos {
  private url: string = 'http://localhost/serviciosWeb/departamentos/deptosProfes.php';

  constructor(private http: HttpClient){}

  //Departamentos

  listarDept(){
    let pa = JSON.stringify({
      servicio: 'departamentos'
    });
    return this.http.post<Departamento[]>(this.url, pa);
  }

  anadirDept(departamento: Departamento){
    let pa = JSON.stringify({
      servicio: 'anadeDepto',
      nombre: departamento.nombre,
      descripcion: departamento.descripcion
    });
    return this.http.post<Departamento>(this.url, pa);
  }

  eliminarDept(id: number){
    let pa = JSON.stringify({
      servicio: "eliminaDepto",
      id
    });
    return this.http.post<Departamento[]>(this.url, pa);
  }

  selDeptID(id: number){
    let pa = JSON.stringify({
      servicio: "selDeptoID",
      id
    });
    return this.http.post<Departamento>(this.url, pa);
  }

  modificarDept(departamento: Departamento){
  let pa = JSON.stringify({
        servicio: 'modificaDepto',
        nombre: departamento.nombre,
        descripcion: departamento.descripcion,
        id: departamento.id
      });
      return this.http.post<Departamento[]>(this.url, pa);
  }

}
