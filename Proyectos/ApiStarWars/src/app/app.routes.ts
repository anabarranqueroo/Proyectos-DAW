import { Routes } from '@angular/router';
import { Listado } from './listado/listado';
import { Detalle } from './detalle/detalle';
import { people } from './people/people';

export const routes: Routes = [
    {
        path: '',
        component: people
    },
    
    {
        path: 'planetas',
        component: Listado
    },

    {
        path: 'planeta/:id',
        component: Detalle
    }
];
