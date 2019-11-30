import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Federacao } from '../Model/Federacao';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  federacao:Federacao[];

  constructor(private http:HttpClient) { }

  Url='http://localhost:8080/federacoes/';

  getFederacoes(){
    return this.http.get<Federacao[]>(this.Url);
  }

  addFederacoes(federacao:Federacao){
    return this.http.post<Federacao>(this.Url, federacao);
  }

  getFederacaoById(id:number){
    return this.http.get<Federacao>(this.Url + id)
  }

  editaFederacao(federacao:Federacao){
    return this.http.put<Federacao>(this.Url + federacao.id, federacao)
  }
}
