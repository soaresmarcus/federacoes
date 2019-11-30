import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Federacao } from 'src/app/Model/Federacao';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  federacao:Federacao = new Federacao();
  constructor(private service:ServiceService, private router:Router) { }

  federacoes:Federacao[];
  ngOnInit() {
    this.service.getFederacoes().subscribe(data=>{
      this.federacoes=data;
    })
  }

  Editar(federacao:Federacao):void{
    localStorage.setItem("id", federacao.id.toString())
    this.router.navigate(["editar"]);
  }

  Excluir(federacao:Federacao){
    this.service.excluiFederacao(federacao)
    .subscribe(data=>{
      this.federacoes=this.federacoes.filter(f=>f!==federacao);
      alert("Unidade Federativa foi removida!");
    });
  }

  Salvar(federacao:Federacao){
    this.service.addFederacoes(this.federacao)
    .subscribe(data=>{
      alert("Salvo com sucesso!")
      location.reload();
    });
  }
  

}
