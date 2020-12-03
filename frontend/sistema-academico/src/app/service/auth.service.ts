import { ProfessorService } from './professor.service';
import { AdministradorService } from './administrador.service';
import { Router } from '@angular/router';
import { Injectable } from '@angular/core';

import jwt_decode from 'jwt-decode';

import { AuthRepository } from '../seguranca/auth-repository';
import { AlunoService } from './aluno.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  jwtPayload: any; 

  constructor(
    private alunoService: AlunoService,
    private administradorService: AdministradorService,
    private professorService: ProfessorService,
    public repository: AuthRepository, 
    private router: Router
  ) { 
    this.carregarToken();
  }

  login(login: string, senha: string){
    
    return this.repository.postLogin(login, senha).subscribe(resposta => {
        
        const json: JSON = JSON.parse(JSON.stringify(resposta));
        console.log(json);
        this.armazenarToken(json['access_token']);
        this.armazenarUsuario(this.jwtPayload);
        
        console.log('Novo access token criado!\n'+JSON.stringify(this.jwtPayload));
        //this.router.navigate(['/listar/cliente']);        
      },
        (e) => {
          console.log(e.error.error_description);      
        });    
  }

  private armazenarToken(token: string) {
    this.jwtPayload = JSON.parse(atob(token.split('.')[1]));
    
    localStorage.setItem('token', token);
  }

  private armazenarUsuario(jwtPayload) {
     //prof
     if(jwtPayload.authorities.includes('SA03')) {
      this.professorService.getProfessorPorPessoaId(this.getUserIdOnToken()).
      subscribe(prof => sessionStorage.setItem('professorId', prof.professorId.toString()));
    }
    //admin
    if(jwtPayload.authorities.includes('SA04')) {
      this.administradorService.getAdministradorPorPessoaId(this.getUserIdOnToken()).
        subscribe(adm => sessionStorage.setItem('administradorId', adm.id));
    }
    //aluno
    if(jwtPayload.authorities.includes('SA05')) {
      this.alunoService.getAlunoPorPessoaId(this.getUserIdOnToken())
        .subscribe(alu => sessionStorage.setItem('alunoId', alu.id));
    }
  }

  private carregarToken() {
    const token = localStorage.getItem('token');

    if (token) {
      this.armazenarToken(token);
    }
  }

  logout() {
    return this.repository.postLogout().subscribe(resposta => {
        this.limparAccessToken();
        this.router.navigate(['']);
        sessionStorage.clear();
      },
      (e) => {
        console.log(e.error.error_description);      
      }); 
  }

  limparAccessToken() {
    window.localStorage.removeItem('token');
    this.jwtPayload = null;
  }

  isAccessTokenInvalido() {
    const token = localStorage.getItem('token');
    
    return !token || this.isTokenExpired();
  }

  getTokenExpirationDate(token: string): Date {
    const decoded: any = jwt_decode(token);

    if (decoded.exp === undefined) {
      return null;
    }

    const date = new Date(0);
    date.setUTCSeconds(decoded.exp);
    return date;
  }

  verificaTokenExpirado(token?: string): boolean {
    if (!token) {
      return true;
    }

    const date = this.getTokenExpirationDate(token);
    if (date === undefined) {
      return false;
    }

    return !(date.valueOf() > new Date().valueOf());
  }

  isTokenExpired(){
    this.repository.postCheckToken().subscribe(resposta => {        
      const json: JSON = JSON.parse(JSON.stringify(resposta));      
      if(json['active']){
        return false;
      }    
    },
    ( e ) => {
        this.obterNovoAccessToken();           
    });
  }

  obterNovoAccessToken(){    
    return this.repository.postRefreshToken().subscribe(resposta => {
      const json: JSON = JSON.parse(JSON.stringify(resposta));
      this.armazenarToken(json['access_token']);
      console.log('Novo access token criado pelo refresh token! '+JSON.stringify(this.jwtPayload));
      },
      (e) => {
        console.log(e.error.error_description);  
        this.logout();
        this.router.navigate(['']);    
      });  
  }

  temPermissao(permissao: string) {
    return this.jwtPayload && this.jwtPayload.authorities.includes(permissao);
  }

  temQualquerPermissao(roles) {
    for (const role of roles) {
      if (this.temPermissao(role)) {
        return true;
      }
    }
    return false;
  }

  getAuthorizationToken() {
    const token = window.localStorage.getItem('token');
    return token;
  }

  isUserLoggedIn() {
    const token = this.getAuthorizationToken();
    if (!token) {
      return false;
    } else if (this.verificaTokenExpirado(token)) {
      return false;
    }

    return true;
  }

  getUserIdOnToken() {
    const decoded: any = jwt_decode(window.localStorage.getItem('token'));

    if (decoded.exp === undefined) {
      return null;
    }

    return decoded.usuario_id;
  }

}
