import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './cadastrar/cadastrar.component';

import { CarrinhoComponent } from './carrinho/carrinho.component';
import { EntrarComponent } from './entrar/entrar.component';
import { HomeComponent } from './home/home.component';
import { ParceirosComponent } from './parceiros/parceiros.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},

  {path: 'entrar', component: EntrarComponent},
  {path: 'cadastrar', component: CadastrarComponent},

  {path: 'home', component: HomeComponent},
  {path: 'parceiros', component: ParceirosComponent},
  {path: 'carrinho', component: CarrinhoComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
