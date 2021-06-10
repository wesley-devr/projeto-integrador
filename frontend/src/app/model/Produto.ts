import { Categoria } from "./Categoria"
import { Comentario } from "./Comentario"
import { User } from "./User"

export class Produto{
    public id: number
    public nome: string
    public preco: number
    public imagem: string
    public quantidade: number
    public descricao: string
    public categoria: Categoria
    public usuario: User
}