import { Routes } from '@angular/router';
import { Listado } from './componentes/listado/listado';
import { FormPersonas } from './componentes/form-personas/form-personas';

export const routes: Routes = [

    {
        path: "",
        component: Listado
    },
    {
        //no puedes poner la primera barra que sino da error
        path: "formulario-personas/:id", //id es el id de la persona que se edita
        component: FormPersonas
    },
];
