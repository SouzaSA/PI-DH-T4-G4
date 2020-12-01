import { DisciplinaOferecidaDto } from './disciplina-oferecida.dto';

export interface DiaHoraDto {
    diaHoraId?: number;
    horario?: string;
    diaSemana?: string;
    disciplinaOferecida?: DisciplinaOferecidaDto;
  }