import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PAjax } from '../p-ajax';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-detalle',
  imports: [CommonModule, RouterLink],
  templateUrl: './detalle.html',
  styleUrls: ['./detalle.css']
})
export class Detalle {
  public planeta: any = {};

  constructor(private ruta: ActivatedRoute, private PAjax: PAjax) {}

  ngOnInit() {
    const id = this.ruta.snapshot.params['id'];
    this.PAjax.obtenerPlaneta(id).subscribe(data => {
      this.planeta = data;
    });
  }
}
