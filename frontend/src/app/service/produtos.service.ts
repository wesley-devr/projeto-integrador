import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Produto } from '../model/Produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {

  constructor(
    private http: HttpClient
  ) { }

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  getAllProdutos(): Observable<Produto[]> {
    return this.http.get<Produto[]>(`${environment.baseUrl}/produtos`,this.token)
  }

  getByIdProdutos(id: number):Observable<Produto>{
    return this.http.get<Produto>(`${environment.baseUrl}/produtos/${id}`,this.token)
  }

  findByDescricao(descricao: String): Observable<Produto>{
    return this.http.get<Produto>(`${environment.baseUrl}/descricao/${descricao}`)
  }

  postProdutos(produto: Produto): Observable<Produto>{
    return this.http.post<Produto>(`${environment.baseUrl}/produtos`, Produto, this.token)
  }

  putProdutos(produto: Produto): Observable<Produto>{
    return this.http.put<Produto>(`${environment.baseUrl}/produtos`, Produto, this.token)
  }

  deleteProdutos(id: number) {
    return this.http.delete(`${environment.baseUrl}/produtos/${id}`, this.token)
  }

}
