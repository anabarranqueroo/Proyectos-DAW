import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [CommonModule, FormsModule, RouterLink],
  standalone: true,
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class Home implements OnInit {
  url = 'https://ddm999.github.io/gt7info/data.json';
  buscador: string = '';
  usedCars: any[] = [];
  legendsCars: any[] = [];
  carType: 'used' | 'legend' | null = null;

  images: string[] = [
    'assets/coche1.jpg',
    'assets/coche2.jpg',
    'assets/coche3.jpg',
    'assets/coche4.jpg',
    'assets/coche5.jpg'
  ];

  numImg: number = 0;
  animatedTotalCars = 0;
  animatedLegendCars = 0;
  animatedBrands = 0;

  constructor(private router: Router) { }

  ngOnInit() {
    setInterval(() => {
      this.numImg = (this.numImg + 1) % this.images.length;
    }, 5000);

    fetch(this.url)
      .then(res => res.json())
      .then(data => {
        this.usedCars = data.used.cars;
        this.legendsCars = data.legend.cars;

        console.log("Coches: ", this.usedCars);
        console.log("Coches legendarios: ", this.legendsCars);

        this.animateStats();
      });
  }


  buscar() {
    console.log("Buscando coche: ", this.buscador);
    if (!this.buscador) return;
    this.router.navigate(['/catalog', 'used'], { queryParams: { c: this.buscador } });
  }

  get filtroCoches() {
    const cars = this.carType === 'used' ? this.usedCars : this.legendsCars;

    if (!this.buscador) return cars;

    const term = this.buscador.toLowerCase();
    return cars.filter(car => car.name.toLowerCase().includes(term));
  }

  recuentoMarcasUnicas(): number {
    const todosCoches = this.usedCars.concat(this.legendsCars);
    const marcas = todosCoches
      .map(car => car.manufacturer ? car.manufacturer.toLowerCase() : '')
      .filter(Boolean); 
    return new Set(marcas).size;
  }

  animateStats() {
    const total = this.usedCars.length + this.legendsCars.length;
    const legend = this.legendsCars.length;
    const brands = this.recuentoMarcasUnicas();

    this.animateCounter('animatedTotalCars', total, 100);
    this.animateCounter('animatedLegendCars', legend, 100);
    this.animateCounter('animatedBrands', brands, 100);
  }

 animateCounter(variable: 'animatedTotalCars' | 'animatedLegendCars' | 'animatedBrands', target: number, interval: number) {
  let current = 0;
  const steps = 50; 
  const step = Math.max(1, Math.floor(target / steps));

  const timer = setInterval(() => {
    current += step;
    if (current >= target) {
      current = target;
      clearInterval(timer);
    }
    this[variable] = current;
  }, interval);
}
}