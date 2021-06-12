import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { faFacebook, faInstagram } from '@fortawesome/free-brands-svg-icons';
import { faHeart, faInfoCircle } from '@fortawesome/free-solid-svg-icons';
import { environment } from 'src/environments/environment.prod';
import Swal from 'sweetalert2';
import { Produto } from '../model/Produto';
import { ProdutosService } from '../service/produtos.service';

@Component({
  selector: 'app-parceiros',
  templateUrl: './parceiros.component.html',
  styleUrls: ['./parceiros.component.css']
})
export class ParceirosComponent implements OnInit{

  produto: Produto = new Produto()
  listaProdutos: Produto[]

  nome = environment.nome
  imagem = environment.imagem
  descricao = environment.descricao

  constructor(
    private router: Router,
    private produtoService: ProdutosService

  ) { }

  ngOnInit() {
    window.scroll(0,0)

    if(environment.token == '') {
      this.router.navigate(['/home'])
    }

    this.findAllProdutos()

  }

  faFacebook = faFacebook;
  faInstagram = faInstagram;
  faHeart = faHeart;
  faCircleInfo = faInfoCircle

  findAllProdutos() {
    this.produtoService.getAllProdutos().subscribe((resp: Produto[]) => {
      this.listaProdutos = resp
      console.log(this.listaProdutos)
    })
  }

  cadastrarProdutos() {
    this.produtoService.postProdutos(this.produto).subscribe((resp: Produto)=> {
        this.produto = resp
        Swal.fire(
          'Sucesso',
          'Produto cadastrado com sucesso!',
          'success'
        )
        this.produto = new Produto()
    })
  }

}