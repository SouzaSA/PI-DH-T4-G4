import { PessoaDto } from './pessoa.dto';

export interface ProfessorDto {
    professorId?: number;
    pessoa?: PessoaDto;
    departamento?: string;
  }