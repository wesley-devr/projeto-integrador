import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../model/Usuario';




@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }

  // entrar(userLogin: UserLogin): Observable<UserLogin>{
  //   return this.http.post<UserLogin>("http://localhost:8080/usuarios/logar", userLogin)
  // }

  // cadastrar(user: User): Observable<User>{
  //   return this.http.post<User>("http://localhost:8080/usuarios/cadastrar", user)
    
  // }

  entrar(userLogin: Usuario): Observable<Usuario>{
    return this.http.post<Usuario>("http://blogpessoal-heroku.herokuapp.com/usuarios/logar", userLogin)
  }

  cadastrar(user: Usuario): Observable<Usuario>{
    return this.http.post<Usuario>("http://blogpessoal-heroku.herokuapp.com/usuarios/cadastrar", user)
    
  }

  // logado(){
  //   let ok: boolean = false

  //   if (environment.token != ''){
  //     ok = true
  //   }

  //   return ok
  // }

}