import { DisciplinaOferecida } from '../model/disciplina-oferecida.model';
import { DisciplinaOferecidaDto } from '../dto/disciplina-oferecida.dto';
export class DisciplinaOferecidaMapper {

  static toDisciplinaOferecida( disciplinaOferecidaDto: DisciplinaOferecidaDto) : DisciplinaOferecida {
      let disciplinaOferecida = new DisciplinaOferecida();

      disciplinaOferecida.disciplinaOferecidaId = disciplinaOferecidaDto.disciplinaOferecidaId;
      disciplinaOferecida.horario = disciplinaOferecidaDto.horario;
      disciplinaOferecida.professor = disciplinaOferecidaDto.professor.pessoa.nome;
      disciplinaOferecida.disciplina = disciplinaOferecidaDto.disciplina.nome;
      disciplinaOferecida.sala = disciplinaOferecidaDto.sala.departamento + ' ' + disciplinaOferecidaDto.sala.numero;
      disciplinaOferecida.semestre = disciplinaOferecidaDto.semestre;
      disciplinaOferecida.turma = disciplinaOferecidaDto.turma;
      disciplinaOferecida.ano = disciplinaOferecidaDto.ano;

      return disciplinaOferecida;
  }

}