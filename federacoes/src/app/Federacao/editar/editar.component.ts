import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Federacao } from 'src/app/Model/Federacao';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  federacao: Federacao = new Federacao();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.Editar();
  }

  Editar(){
    let id = localStorage.getItem("id");
    this.service.getFederacaoById(+id)
    .subscribe(data=>{
      this.federacao=data;
    });
  }

  Atualizar(federacao:Federacao){
    this.service.editaFederacao(federacao)
    .subscribe(data=>{
      this.federacao=data;
      alert("Atualizado com sucesso!");
      this.router.navigate([""]);
    });
  }

}
