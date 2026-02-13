import { Routes } from '@angular/router';
import { ListadoFacturas } from './componentes/listado-facturas/listado-facturas';
import { ServicioFacturas } from './servicios/servicio-facturas';
import { FormFacturas } from './componentes/form-facturas/form-facturas';
import { DetalleFacturas } from './componentes/detalle-facturas/detalle-facturas';
import { FormDetalles } from './componentes/form-detalles/form-detalles';


export const routes: Routes = [
    {
        path: "",
        component: ListadoFacturas
    },
    {
        path: "form-facturas/:id",
        component: FormFacturas
    },
    {
        path: "factura/:id",
        component: DetalleFacturas
    },
    {
        path: "form-detalle/:idFactura/:idDetalle",
        component: FormDetalles
    }
];
