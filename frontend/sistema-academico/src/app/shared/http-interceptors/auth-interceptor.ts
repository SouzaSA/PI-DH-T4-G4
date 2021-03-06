import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpErrorResponse } from '@angular/common/http';

import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { environment } from './../../../environments/environment';
import { AuthService } from './../../service/auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(
    private authService: AuthService
  ) { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {

    if (req.url.includes(`${environment.URLSERVIDOR}`)){
      
      const token = this.authService.getAuthorizationToken();
      let request: HttpRequest<any> = req;

      req.url.includes(`${environment.URLSERVIDOR}`)

      if (token && !this.authService.verificaTokenExpirado(token)) {
        // O request é imutavel, ou seja, não é possível mudar nada
        // Faço o clone para conseguir mudar as propriedades
        // Passo o token de autenticação no header
        request = req.clone({
          headers: req.headers.set('Authorization', `Bearer ${token}`)
        });
      }

      // retorno o request com o erro tratado
      return next.handle(request)
        .pipe(
          catchError(this.handleError)
        );
    }
    return next.handle(req);
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // Erro de client-side ou de rede
      console.error('Ocorreu um erro:', error.error.message);
    } else {
      // Erro retornando pelo backend
      console.error(
        `Código do erro ${error.status}, ` +
        `Erro: ${JSON.stringify(error.error)}`);
    }
    // retornar um observable com uma mensagem amigavel.
    return throwError('Ocorreu um erro, tente novamente');
  }
}
