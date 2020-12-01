export interface DisciplinaDto {
    disciplinaId?: number;
    horasSemanais?: number;
    codigo?: string;
    creditos?: number;
    ementa?: string;
    nome?: string;
    requeridas?: DisciplinaDto[];
    semestreIdeal?: number;
}