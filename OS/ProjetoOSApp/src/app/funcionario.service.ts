import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  
  constructor(private http: HttpClient) { }

  //Função para buscar os funcionários
  getDisponiveis(){

    //Ativa os cabeçalhos para requisição 
    var headers = new HttpHeaders();
    headers.append('Access-Control-Allow-Origin', '*');

    //Request no end-point do servidor (Servlet Funcionário)
    return this.http.get('https://projetoos.herokuapp.com/Funcionario?action=BuscarTodos',{headers: headers});
  }
}
