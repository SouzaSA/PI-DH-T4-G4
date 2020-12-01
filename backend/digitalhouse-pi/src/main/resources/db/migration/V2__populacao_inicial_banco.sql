INSERT INTO pessoa (nome, sobrenome, email, password, cep, rua, numero, bairro, complemento, cidade, estado) VALUES
	("Thyago", "Santiago", "ssantiagotl@gmail.com", "$2y$12$jSk8ljb6Unj26zALSCACvO11s6/Uw4PMP0XCnlotscXFioCiZ8CGW", "12345677", "Rua das Acácias", "345", "Parque das Arvores", "casa", "Formigas","MG"),
	("João", "das Couves", "joaodascouves@escola.com.br", "$2y$12$jSk8ljb6Unj26zALSCACvO11s6/Uw4PMP0XCnlotscXFioCiZ8CGW", "12233640", "Rua Maria Palmira Ferreira Ivo", "123", "Bosque dos Eucaliptos", "casa", "São José dos Campos", "SP"),
	("Maria", "das Couves", "mariadascouves@escola.com.br", "$2y$12$jSk8ljb6Unj26zALSCACvO11s6/Uw4PMP0XCnlotscXFioCiZ8CGW", "12233640", "Rua Maria Palmira Ferreira Ivo", "123", "Bosque dos Eucaliptos", "casa", "São José dos Campos", "SP"),
	("Alfredo", "Higiênico", "alfredo@escola.com.br", "$2y$12$jSk8ljb6Unj26zALSCACvO11s6/Uw4PMP0XCnlotscXFioCiZ8CGW", "12290550", "Avenida Selmo Ferreira Diniz Júnior", "852", "Perinho", "apartamento 150", "Caçapava", "SP"),
	("Rita", "Risonha da Floresta", "rita@escola.com.br", "$2y$12$jSk8ljb6Unj26zALSCACvO11s6/Uw4PMP0XCnlotscXFioCiZ8CGW", "12326500", "Rua Trinta e Oito", "39", "Veraneio Irajá", "casa", "Jacareí", "SP"),
	("Clementina", "Clementina", "clementina@escola.com.br", "$2y$12$jSk8ljb6Unj26zALSCACvO11s6/Uw4PMP0XCnlotscXFioCiZ8CGW", "39790971", "Rua Darci Alves de Oliveira", "195", "Centro", "casa", "Água Boa", "MG"),
	("Harry", "Potter", "harrypotter@escola.com.br", "$2y$12$jSk8ljb6Unj26zALSCACvO11s6/Uw4PMP0XCnlotscXFioCiZ8CGW", "46910970", "Distrito de Várzea do Caldas", "48", "Centro", "apartamento 21", "Várzea do Caldas", "BA"),
	("Helena", "de Troia", "helena@escola.com.br", "$2y$12$jSk8ljb6Unj26zALSCACvO11s6/Uw4PMP0XCnlotscXFioCiZ8CGW", "24944854", "Rua R", "1", "Santa Paula (Inoã)", "casa", "Maricá", "RJ"),
	("Perseu", "do Olimpo", "perseu@escola.com.br", "$2y$12$jSk8ljb6Unj26zALSCACvO11s6/Uw4PMP0XCnlotscXFioCiZ8CGW", "46910970", "Distrito de Várzea do Caldas", "48", "Centro", "apartamento 21", "Várzea do Caldas", "BA"),
	("Perseia", "do Olimpo", "perseia@escola.com.br", "$2y$12$jSk8ljb6Unj26zALSCACvO11s6/Uw4PMP0XCnlotscXFioCiZ8CGW", "24944854", "Rua R", "1", "Santa Paula (Inoã)", "casa", "Maricá", "RJ");
	
INSERT INTO professor (departamento, fk_pessoa_id) VALUES 
	(1, 1),
	(2, 2),
	(3, 3),
	(4, 4);
	
INSERT INTO administrador (fk_pessoa_id) VALUES
	(5),
	(6),
	(7);
	
INSERT INTO curso (nome, fk_professor_id) VALUES
	("Bacharelado em Letras", 1),
	("Bacharelado em Física", 2),
	("Bacharelado em Matemática", 3),
	("Bacharelado em Química", 4);
	
INSERT INTO aluno (fk_curso_id, fk_pessoa_id) VALUES 
	(1, 8),
	(2, 9),
	(3, 10);
	
INSERT INTO disciplina (codigo, horas_semanais, creditos, ementa, nome, semestre_ideal) VALUES
	("MAT-12", 4, 3, "Números reais. Funções reais de uma variável real. Limites. Funções contínuas: teoremas do valor intermediário e de Bolzano-Weierstrass. Derivadas: definição e propriedades, funções diferenciáveis, regra da cadeia e derivada da função inversa. Teorema do valor médio. Fórmula de Taylor e pesquisa de máximos, mínimos e pontos de inflexão; aplicações. Regras de L'Hospital. Integral de Riemann: definição, propriedades e interpretação geométrica. O Teorema Fundamental do Cálculo. Técnicas de integração. Aplicações. Integrais impróprias. Sequências numéricas: continuidade e convergência, seqüências monótonas, convergência e completude do conjunto dos números reais. Séries Numéricas: convergência ou divergência de uma série. Critérios de convergência: critérios do termo geral, da razão, da raiz, da integral e critério de Leibniz. Convergência absoluta e convergência condicional. Séries de Potências: intervalo de convergência e o Teorema de Abel. Propriedades da soma de uma série de potências: continuidade, derivação e integração termo a termo. Séries de Taylor das principais funções elementares. Aplicações.","Cálculo Diferencial e Integral I", "1"),
	("MAT-22", 4, 3, "Noções da topologia no Rn. Curvas parametrizadas em Rn. Funções de várias variáveis, curvas e superfíceis de nível. Limite e continuidade. Derivadas direcionais e derivadas parciais. Diferenciabilidade e diferencial. Regra da cadeia. O vetor gradiente e sua interpretação. Derivadas parciais de ordem superior. Fórmula de Taylor e pesquisa de máximos, mínimos e pontos de sela. Extremos condicionados: Multiplicadores de Lagrange. Transformações entre espaços reais: a diferencial e a matriz Jacobiana. Conjuntos de nível. Teorema da Função Implícita e Teorema da Função Inversa. Integrais Múltiplas: integral dupla e integral tripla. Integral iterada e o Teorema de Fubini. Mudança de variáveis na integral. Coordenadas polares, cilíndricas e esféricas. Aplicações.", "Cálculo Diferencial e Integral II", 2),
	("HUM-02", 4, 3, "Conceito de ética e de moral. Noções de teoria ética: Ética clássica; Ética kantiana; Ética utilitarista. Ética moderna, indivíduo e sociedade: Enfoques temáticos como bioética, ética e economia, códigos de conduta empresarial e meio ambiente. Ética na engenharia: Código de Ética Profissional; Tecnologia e riscos; Falhas humanas e falhas tecnológicas. Responsabilidade do engenheiro; Exemplos de excelência e exemplos de infrações éticas", "Ética", 2),
	("HUM-03", 4, 3, "Filosofia, mito e religião. O fisiologismo primordial. Argumentação e retórica: Sócrates e os sofistas. Platão: o cosmo, o humano e a polis. A síntese aristotélica. Epicuro e os estóicos. Cícero e a preservação da cultura grega na Roma Antiga. O helenismo e a passagem ao mundo cristão.", "Introdução à Filosofia: As Origens", 4),
	("FIS-15", 4, 3, "Forças. Estática. Equilíbrio de um corpo rígido. Cinemática da partícula em um plano. Movimento circular. Dinâmica da partícula. Conceito de referencial inercial. Leis de Newton. Princípio de conservação do momento linear. Atrito. Sistemas com massa variável. Dinâmica do movimento curvilíneo. Momento angular. Forças centrais. Movimento relativo. Transformações de Galileu. Referenciais não inerciais. Trabalho e energia. Forças conservativas e energia potencial. Movimento sob ação de forças conservativas. Curvas de potencial. Forças não conservativas. Dinâmica de um sistema de partículas: centro de massa, momento angular, energia cinética. Colisões.", "Mecânica I", 5),
	("FIS-26", 4, 3, "Dinâmica do corpo rígido: centro de massa, momento de inércia, energia, equação do movimento de rotação, rolamento, movimento giroscópico. Movimento oscilatório: dinâmica do movimento harmônico simples; pêndulos, osciladores acoplados, oscilações harmônicas, oscilações amortecidas, oscilações forçadas e ressonância. Movimento ondulatório: ondas em cordas, ondas estacionárias, ressonância, ondas sonoras, batimento, efeito Doppler. Gravitação. Introdução à Mecânica Analítica: trabalho virtual, equação de D’Alembert, equações de Lagrange, princípio de Hamilton e equações de Hamilton.", "Mecânica II", 6),
	("QUI-18", 4, 3, "Principais experiências para a caracterização do átomo, espectro atômico do átomo de hidrogênio e o modelo de Bohr, estrutura atômica, espectros atômicos, seus níveis energéticos e geometria dos orbitais atômicos. Ligações Químicas: covalentes, iônicas e metálicas com abordagem nos modelos do elétron localizado e dos orbitais moleculares. Momento de dipolo elétrico das moléculas. Estrutura cristalina dos metais e dos compostos iônicos simples. Faces planas naturais e ângulos diedros, clivagem, hábito. Célula unitária e sistemas cristalinos. Empilhamento compacto. Índices de Miller. Difração de raios X. Defeitos e ideias básicas sobre estrutura dos silicatos.", "Química Geral I", 1),
	("QUI-28", 4, 3, "Termodinâmica química: energia interna, entalpia, entropia e energia livre de Gibbs. Potencial químico, atividade e fugacidade. Relação entre energia livre de Gibbs e constante de equilíbrio. Eletroquímica: equilíbrios de reações de óxido-redução, eletrodos, potenciais de equilíbrio dos eletrodos, pilhas e baterias, leis da eletrólise e corrosão.", "Química Geral II", 2);

INSERT INTO requere (fk_disciplina_id, fk_requerida_id) VALUES
	(2, 1),
	(6, 5),
	(6, 2),
	(8, 7);
	
INSERT INTO sala (andar, capacidade, departamento, numero) VALUES 
	(0, 50, 3, 1530),
	(1, 50, 3, 2536),
	(0, 70, 1, 1640),
	(1, 50, 1, 2612),
	(1, 35, 0, 2444),
	(1, 25, 0, 2410),
	(1, 55, 2, 2312),
	(1, 75, 2, 2322);
	
INSERT INTO disciplina_oferecida (ano, semestre, turma, fk_disciplina_id, fk_professor_id, fk_sala_id) VALUES
	(2020, 1, 1, 1, 1, 1),
	(2020, 1, 1, 3, 2, 1),
	(2020, 1, 1, 4, 1, 4),
	(2020, 1, 1, 5, 3, 3),
	(2020, 1, 1, 7, 4, 5),
	(2020, 1, 1, 8, 4, 5);
	
INSERT INTO dia_hora (dia_semana, horario, fk_disciplina_oferecida_id) VALUES
	("SEG", "M1", 1),
	("SEG", "M2", 1),
	("SEG", "M3", 1),
	("SEG", "M4", 1),
	("SEG", "V1", 2),
	("SEG", "V2", 2),
	("TER", "V1", 2),
	("TER", "V2", 2),
	("TER", "M1", 3),
	("TER", "M2", 3),
	("QUA", "M3", 3),
	("QUA", "M4", 3),
	("QUA", "M1", 4),
	("QUA", "M2", 4),
	("TER", "M3", 4),
	("TER", "M4", 4),
	("QUI", "M1", 5),
	("QUI", "M2", 5),
	("QUI", "M3", 5),
	("QUI", "M4", 5),
	("SAB", "M1", 6),
	("SAB", "M2", 6),
	("SAB", "M3", 6),
	("SAB", "M4", 6);

INSERT INTO informe (data_publicacao, departamento, descricao, prioridade, titulo, fk_professor_id) VALUES
	("2020-02-01 15:25:15", 4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 3, "Loren Ipson 01", 1),
	("2020-04-01 13:25:15", 4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 3, "Loren Ipson 02", 4),
	("2020-01-01 10:25:15", 2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1, "Lorem Ipson Alfa", 3),
	("2020-04-01 15:25:15", 2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 4, "Lorent ipsonius", 2),
	("2020-08-01 10:25:15", 1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 2, "Loren", 1),
	("2020-09-01 10:25:15", 1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1, "Loren 2", 1),
	("2020-11-01 11:25:15", 3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 3, "Dolor sit", 3),
	("2020-11-03 11:25:15", 3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 2, "Adspiscing elit", 3);
	
INSERT INTO telefone (telefone, fk_pessoa_id) VALUES
	("1512554268", 1),
	("1523655874", 1),
	("15254698752", 1),
	("1625425412", 2),
	("16854258744", 2),
	("1865423658", 3),
	("18985236547", 3),
	("15854236574", 4),
	("15456236575", 4),
	("17321456987", 5),
	("17254236588", 5),
	("1832158452", 6),
	("18596325874", 6),
	("11987665242", 7),
	("11998855223", 7),
	("11995566332", 8),
	("11994455221", 8),
	("11885522114", 9),
	("11777552485", 9),
	("16542158744", 10),
	("16254125875", 10);
	
INSERT INTO permissao (descricao, nome) VALUES
	("Permissao de acesso visualização", "SA01"),
	("Permissao de acesso edição", "SA02"),
	("Permissao de acesso professor", "SA03"),
	("Permissao de acesso administrador", "SA04"),
	("Permissao de acesso aluno", "SA05");
	
INSERT INTO grupo (nome) VALUES
	("PROF"),
	("ALUN"),
	("ADMN");

INSERT INTO grupo_permissao (grupo_id, permissao_id) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(2, 1),
	(2, 2),
	(2, 5),
	(3, 1),
	(3, 2),
	(3, 4);
	
INSERT INTO usuario_grupo (usuario_id, grupo_id) VALUES
	(1, 1),
	(5, 3),
	(9, 2);
	
INSERT INTO cursa_disciplina_oferecida (data_inscricao, data_deferimento, faltas, fk_aluno_id, fk_disciplina_oferecida_id) VALUES
	(NOW(), NOW(), 0, 2, 1),
	(NOW(), NOW(), 0, 2, 2),
	(NOW(), NOW(), 2, 2, 3),
	(NOW(), NOW(), 4, 2, 4),
	(NOW(), NOW(), 4, 2, 5),
	(NOW(), NOW(), 2, 2, 6);
	
INSERT INTO nota (titulo, numero, valor, fk_cursa_disciplina_oferecida_id) VALUES
	("PROVA", 1, 55.30, 1),
	("PROVA", 2, 77.80, 1),
	("PROVA", 1, 80.25, 2),
	("PROVA", 2, 90.00, 2),
	("PROVA", 3, 99.50, 2),
	("PROVA", 1, 50.25, 3),
	("PROVA", 2, 82.50, 3),
	("TRABALHO", 1, 100.00, 3),
	("PROVA", 1, 100.00, 4),
	("PROVA", 2, 80.00, 4),
	("SEMINARIO", 1, 85.00, 4),
	("SEMINARIO", 2, 90.00, 4),
	("PROVA", 1, 30.00, 5),
	("TRABALHO", 1, 100.00, 6),
	("SEMINARIO", 2, 100.00, 6);
