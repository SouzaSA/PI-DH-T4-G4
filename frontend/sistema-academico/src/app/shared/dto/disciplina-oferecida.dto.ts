import { SalaDto } from './sala.dto';
import { DisciplinaDto } from './disciplina.dto';
import { ProfessorDto } from './professor.dto';

export interface DisciplinaOferecidaDto {
  disciplinaOferecidaId?: number;
  horario?: string;
  professor?: ProfessorDto;
  disciplina?: DisciplinaDto;
  sala?: SalaDto;
  semestre?: number;
  turma?: number;
  ano?: number;
}