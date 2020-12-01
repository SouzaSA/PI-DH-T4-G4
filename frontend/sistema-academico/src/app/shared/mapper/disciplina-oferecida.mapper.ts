import { DisciplinaOferecida } from '../model/disciplina-oferecida.model';
import { DisciplinaOferecidaDto } from '../dto/disciplina-oferecida.dto';
import { DiaHoraMapper } from './diaHora.mapper';

export class DisciplinaOferecidaMapper {

  static toDisciplinaOferecida( disciplinaOferecidaDto: DisciplinaOferecidaDto) : DisciplinaOferecida {
      let disciplinaOferecida = new DisciplinaOferecida();

      disciplinaOferecida.disciplinaOferecidaId = disciplinaOferecidaDto.disciplinaOferecidaId;
      disciplinaOferecida.diasHoras = disciplinaOferecidaDto.diasHoras.map(diaHora => DiaHoraMapper.toDiaHora(diaHora));
      disciplinaOferecida.professor = disciplinaOferecidaDto.professor.pessoa.nome;
      disciplinaOferecida.disciplina = disciplinaOferecidaDto.disciplina.nome;
      disciplinaOferecida.sala = disciplinaOferecidaDto.sala.departamento + ' ' + disciplinaOferecidaDto.sala.numero;
      disciplinaOferecida.semestre = disciplinaOferecidaDto.semestre;
      disciplinaOferecida.turma = disciplinaOferecidaDto.turma;
      disciplinaOferecida.ano = disciplinaOferecidaDto.ano;

      return disciplinaOferecida;
  }

}