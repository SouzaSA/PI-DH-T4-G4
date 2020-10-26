import { PessoaDto } from './pessoa.dto';

export interface AdministradorDto {
    administradorId?: number;
    pessoa?: PessoaDto;
  }