import { SalaDto } from './sala.dto';
import { DisciplinaDto } from './disciplina.dto';
import { ProfessorDto } from './professor.dto';
import { DiaHoraDto } from './diaHora.dto';

export interface DisciplinaOferecidaDto {
  disciplinaOferecidaId?: number;
  diasHoras?: DiaHoraDto[];
  professor?: ProfessorDto;
  disciplina?: DisciplinaDto;
  sala?: SalaDto;
  semestre?: number;
  turma?: number;
  ano?: number;
}