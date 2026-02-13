import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListDept } from './components/list-dept/list-dept';
import { FormDept } from './components/form-dept/form-dept';
import { ListProf } from './components/list-prof/list-prof';
import { FormProf } from './components/form-prof/form-prof';

const routes: Routes = [
  {
    path: "",
    component: ListDept
  },
  {
    path: "form-dept/:idDep",
    component: FormDept
  },
  {
    path: "form-dept-edit/:idDept",
    component: FormDept
  },
  {
    path: "form-prof/:idDept",
    component: FormProf
  },
  {
    path: "form-prof-edit/:idProf",
    component: FormProf
  },
  {
    path: "list-dept/:idDept",
    component: ListDept
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
