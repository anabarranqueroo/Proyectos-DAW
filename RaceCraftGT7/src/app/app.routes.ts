import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { UsedCarsCatalog } from './components/used-cars-catalog/used-cars-catalog';
import { LegendsCarsCatalog } from './components/legends-cars-catalog/legends-cars-catalog';

export const routes: Routes = [
    {
        path: '',
        component: Home
    },
    {
        path: 'catalog/used',
        component: UsedCarsCatalog
    },
    {
        path: 'catalog/legends',
        component: LegendsCarsCatalog
    }
];
