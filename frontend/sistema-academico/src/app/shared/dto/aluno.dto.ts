import { PessoaDto } from './pessoa.dto';

export interface AlunoDto {
    id?: number;
    pessoa?: PessoaDto;
    curso?: string;
  }