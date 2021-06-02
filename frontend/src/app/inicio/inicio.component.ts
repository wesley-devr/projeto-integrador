import { environment } from './../../environments/environment.prod';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import Swal from 'sweetalert2';
import { AuthService } from '../Service/auth.service';
import { Usuario } from '../model/Usuario';
import { UsuarioLogin } from '../model/UsuarioLogin';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userLogin: UsuarioLogin = new UsuarioLogin
  UsuarioLogin: Usuario;

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(){
    window.scroll(0,0)
    localStorage.clear()
  }

  entrar(){
    this.authService.entrar(this.UsuarioLogin).subscribe((resp: Usuario) => {
      this.UsuarioLogin = resp
      // environment.id = this.userLogin.id
      // environment.nome = this.userLogin.nome
      // environment.token = this.userLogin.token
      // environment.tipoParceiro = this.userLogin.tipoParceiro
      // environment.tipoAdministrador = this.userLogin.tipoAdministrador

      if(this.userLogin.tipoParceiro == false){
        this.router.navigate (['/home'])
      } else {
        this.router.navigate (['meus-produtos'])
      }
      

    },error=>{
      if( error.status == 500 ){
        Swal.fire({
          icon: 'warning',
          title: 'Oops...',
          text: 'Usuário ou senha incorretos!'
        })

    }}
    )
  }

}
