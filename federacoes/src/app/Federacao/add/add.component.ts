import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Federacao } from 'src/app/Model/Federacao';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  federacao:Federacao = new Federacao();
  
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
  }

  Salvar(federacao:Federacao){
    this.service.addFederacoes(this.federacao)
    .subscribe(data=>{
      alert("Salvo com sucesso!")
      this.router.navigate(["listar"]);
    })
  }

}
