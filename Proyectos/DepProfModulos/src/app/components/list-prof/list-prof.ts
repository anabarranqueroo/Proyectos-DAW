import { Component, Input, Output, EventEmitter, SimpleChanges } from '@angular/core';
import { Profesor } from '../../models/profesor';
import { ServicioProfesores } from '../../services/servicio-prof';


@Component({
  selector: 'app-list-prof',
  standalone: false,
  templateUrl: './list-prof.html',
  styleUrl: './list-prof.css',
})
export class ListProf {
  public listaProf: Profesor[] = [];
  @Input() idDepartamento: number | null=null;
  @Input() nombreDepartamento: string = "";
  @Output() eliminado = new EventEmitter();
  delete_success: boolean = false;

  constructor(private servicioProf: ServicioProfesores) {
  }

  ngOnChanges(changes: SimpleChanges){
    if(changes['idDepartamento'] && this.idDepartamento){
      this.cargaProf();
    }
  }

  cargaProf(){
     if (this.idDepartamento) {
  this.servicioProf.listarProf(this.idDepartamento).subscribe({
    next: profesores => this.listaProf = profesores,
    error: error => console.error(error)
  });
}
  }


  eliminarProf(prof: Profesor) {
    if (confirm(`¿Seguro que quieres eliminar a "${prof.nombre}"?`)) {
      this.servicioProf.eliminarProf(prof, prof.id_departamento).subscribe({
        next: dat => {
          this.eliminado.emit(dat);
          this.cargaProf();
        },
        error: (err) => console.error(err),
      });
    }
  }
}
