import { CursoDto } from './curso.dto';
import { PessoaDto } from './pessoa.dto';

export interface AlunoDto {
  alunoId?: number;
  pessoa?: PessoaDto;
  curso?: CursoDto;
}