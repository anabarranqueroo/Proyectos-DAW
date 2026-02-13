import { Routes } from '@angular/router';
import { DetalleCoches } from './componentes/detalle-coches/detalle-coches';
import { ListaCoches } from './componentes/lista-coches/lista-coches';
import { FormCoche } from './componentes/form-coche/form-coche';
import { FormModelo } from './componentes/form-modelo/form-modelo';

export const routes: Routes = [
  {
    path: '',
    component: ListaCoches
  },
  {
    path: 'form-coche/:idCoche',
    component: FormCoche
  },
  {
    path: 'form-coche-edit/:idCoche',
    component: FormCoche
  },
   {
    path: 'detalle/:idCoche',
    component: DetalleCoches
  },
  {
    path: 'coches/:idCoche/modelos/nuevo',
    component: FormModelo
  },
  {
    path: 'coches/:idCoche/modelos/editar/:idModelo',
    component: FormModelo
  }
];
