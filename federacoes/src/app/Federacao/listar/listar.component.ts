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

  constructor(private service:ServiceService, private router:Router) { }

  federacoes:Federacao[];
  ngOnInit() {
    this.service.getFederacoes().subscribe(data=>{
      this.federacoes=data;
    })
  }

}
