export class Disciplina {
    disciplinaId?: number;
    codigo?: string;
    horasSemanais?: number;
    creditos?: number;
    ementa?: string;
    nome?: string;
    obrigatoria?: string[];
    semestreIdeal?: number;

    constructor() {
        this.disciplinaId = undefined;
        this.codigo = undefined;
        this.horasSemanais = undefined;
        this.creditos = undefined;
        this.ementa = undefined;
        this.nome = undefined;
        this.obrigatoria = undefined;
        this.semestreIdeal = undefined;
    }
}