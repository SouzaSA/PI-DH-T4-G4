import { DisciplinaOferecidaDto } from './disciplina-oferecida.dto';
import { AlunoDto } from './aluno.dto';
import { NotaDto } from './nota.dto';

export interface CursaDisciplinaOferecidaDto {
  cursaDisciplinaOferecidaId?: number,
  dataInscricao?: Date,
  dataDeferimento?: Date,
  faltas?: Number,
  aluno?: AlunoDto,
  disciplinaOferecida?: DisciplinaOferecidaDto,
  notas?: NotaDto
}