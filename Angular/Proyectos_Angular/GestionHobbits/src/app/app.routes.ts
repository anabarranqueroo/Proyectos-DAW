import { Routes } from '@angular/router';
import { GHobbit } from './g-hobbit/g-hobbit';
import { FormHobbit } from './form-hobbit/form-hobbit';

export const routes: Routes = [{
    path: "",
    component: GHobbit
},
{
    path: "hobbit-add",
    component: FormHobbit
},
{
    path: "hobbit-addMod/:indice",
    component: FormHobbit
}
];
