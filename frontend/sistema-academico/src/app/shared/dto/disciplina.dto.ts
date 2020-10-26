export interface DisciplinaDto {
    disciplinaId?: number;
    codigo?: string;
    creditos?: number;
    ementa?: string;
    nome?: string;
    obrigatoria?: string[];
    semestreIdeal?: number;
}