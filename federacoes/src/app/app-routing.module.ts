import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarComponent } from './Federacao/listar/listar.component';
import { EditarComponent } from './Federacao/editar/editar.component';


const routes: Routes = [
  {path: '', component:ListarComponent},
  {path: 'editar', component:EditarComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
