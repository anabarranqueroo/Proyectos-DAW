import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { Departamento } from '../../models/departamento';
import { ServicioDepartamentos } from '../../services/servicio-dept';
import { RouterLink, Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list-dept',
  standalone: false,
  templateUrl: './list-dept.html',
  styleUrl: './list-dept.css',
})
export class ListDept implements OnInit {

  public listaDept: Departamento[] = [];
  public idDept: number | null = null;
  public nombreDept!: string;
  public deptSeleccionado: Departamento | null = null;

  constructor(private location: Location, private servicioDept: ServicioDepartamentos, private route: ActivatedRoute) {
  }

  cargarDepartamentos() {
    this.servicioDept.listarDept().subscribe({
      next: departamentos => {
        this.listaDept = departamentos;
      },
      error: error => console.error('Error al obtener los departamentos', error)
    });
  }

  mostrarProf(dept: Departamento) {
    if (this.idDept === dept.id) {
      this.idDept = null;
      this.deptSeleccionado = null;
    } else {
      this.idDept = dept.id;
      this.deptSeleccionado = dept;
    }
  }

  eliminar(departamento: Departamento) {
    if (confirm(`¿Quieres eliminar el departamento de "${departamento.nombre}" ?`)) {
      this.servicioDept.eliminarDept(departamento.id).subscribe({
        next: () => {
          this.cargarDepartamentos();
        },
        error: error => console.log("Error", error)
      });
    }
  }

  ngOnInit() {

    this.servicioDept.listarDept().subscribe({
      next: departamentos => {
        this.listaDept = departamentos;

        this.route.params.subscribe(params => {
          const idParam = params["idDept"];
          if (idParam) {
            this.idDept = Number(idParam);
            this.servicioDept.selDeptID(this.idDept).subscribe({
              next: dpto => {
                this.deptSeleccionado = dpto;
                this.nombreDept = dpto.nombre;
              },
              error: error => console.error(error)
            });
          }
        });
      }
    });
  }

  volver() {
    this.location.back();
  }
}