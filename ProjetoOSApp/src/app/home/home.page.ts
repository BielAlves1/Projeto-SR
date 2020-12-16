import { Component } from '@angular/core';
import { FuncionarioService } from '../funcionario.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  //variavel lista dos funcionarios
  funcionarios: any;

  constructor(private fService: FuncionarioService) {

  }

  //Busca os funcionários ao iniciar a View
  async ionViewDidEnter(){
    this.fService.getDisponiveis().subscribe( data => {
      this.funcionarios = data;
    })

  }


}
