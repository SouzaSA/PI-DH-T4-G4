import { CursaDisciplinaOferecidaDto } from './cursa-disciplina-oferecida.dto';

export interface NotaDto {
  notaId: number,
  titulo?: string,
  numero?: number,
  valor?: number,
  disciplinaCursadaAluno?: CursaDisciplinaOferecidaDto
}