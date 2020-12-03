import { SalaDto } from './sala.dto';
import { DisciplinaDto } from './disciplina.dto';
import { ProfessorDto } from './professor.dto';
import { DiaHoraDto } from './diaHora.dto';
import { CursaDisciplinaOferecidaDto } from './cursa-disciplina-oferecida.dto';

export interface DisciplinaOferecidaDto {
  disciplinaOferecidaId?: number;
  diasHoras?: DiaHoraDto[];
  professor?: ProfessorDto;
  disciplina?: DisciplinaDto;
  sala?: SalaDto;
  semestre?: number;
  turma?: number;
  ano?: number;
  disciplinasCursadas?: CursaDisciplinaOferecidaDto[];
}