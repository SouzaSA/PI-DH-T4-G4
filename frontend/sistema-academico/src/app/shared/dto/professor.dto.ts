import { PessoaDto } from './pessoa.dto';

export interface ProfessorDto {
    professor_id?: number;
    pessoa?: PessoaDto;
    departamento?: string;
  }