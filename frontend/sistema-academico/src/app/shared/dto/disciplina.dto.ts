export interface DisciplinaDto {
    disciplinaId?: number;
    codigo?: string;
    creditos?: number;
    ementa?: string;
    nome?: string;
    requeridas?: DisciplinaDto[];
    semestreIdeal?: number;
}