import { DisciplinaOferecida } from './disciplina-oferecida.model';

export class DiaHora {
    diaHoraId?: number;
    horario?: string;
    diaSemana?: string;

    constructor() {
        this.diaHoraId = undefined;
        this.horario = undefined;
        this.diaSemana = undefined;
      }
}