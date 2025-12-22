import { Component } from '@angular/core';
import { PAjax } from '../p-ajax';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-listado',
  imports: [CommonModule, RouterLink],
  templateUrl: './listado.html',
  styleUrls: ['./listado.css']
})
export class Listado {
  public planetas: any[] = [];

  constructor(private datosSw: PAjax) {}

  ngOnInit() {
    this.datosSw.listarPlanetas().subscribe(data => {
      this.planetas = data;
    });
  }
}
