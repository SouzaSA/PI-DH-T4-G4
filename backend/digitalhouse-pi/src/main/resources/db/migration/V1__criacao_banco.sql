CREATE DATABASE IF NOT EXISTS `sistema_academico`;
USE `sistema_academico`;

CREATE TABLE IF NOT EXISTS `administrador` (
  `administrador_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fk_pessoa_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`administrador_id`),
  KEY `FKcnarqtexfp33p8v4sb92086ey` (`fk_pessoa_id`),
  CONSTRAINT `FKcnarqtexfp33p8v4sb92086ey` FOREIGN KEY (`fk_pessoa_id`) REFERENCES `pessoa` (`pessoa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `aluno` (
  `aluno_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fk_curso_id` bigint(20) DEFAULT NULL,
  `fk_pessoa_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`aluno_id`),
  KEY `FKpu2nlsyw5ty0jvjpnulki1hyl` (`fk_curso_id`),
  KEY `FKi829otlth0r8k93kiyxacuufv` (`fk_pessoa_id`),
  CONSTRAINT `FKi829otlth0r8k93kiyxacuufv` FOREIGN KEY (`fk_pessoa_id`) REFERENCES `pessoa` (`pessoa_id`),
  CONSTRAINT `FKpu2nlsyw5ty0jvjpnulki1hyl` FOREIGN KEY (`fk_curso_id`) REFERENCES `curso` (`curso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `cursa_disciplina_oferecida` (
  `cursa_disciplina_oferecida_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_inscricao` datetime(6) DEFAULT NULL,
  `data_deferimento` datetime(6) DEFAULT NULL,
  `fk_aluno_id` bigint(20) DEFAULT NULL,
  `fk_disciplina_oferecida_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cursa_disciplina_oferecida_id`),
  KEY `FK54n409o9cm2d9hxx0ykjh8hrm` (`fk_aluno_id`),
  KEY `FK8tra2oc0qi0qkm00l47ha4gfd` (`fk_disciplina_oferecida_id`),
  CONSTRAINT `FK54n409o9cm2d9hxx0ykjh8hrm` FOREIGN KEY (`fk_aluno_id`) REFERENCES `aluno` (`aluno_id`),
  CONSTRAINT `FK8tra2oc0qi0qkm00l47ha4gfd` FOREIGN KEY (`fk_disciplina_oferecida_id`) REFERENCES `disciplina_oferecida` (`disciplina_oferecida_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `curso` (
  `curso_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `fk_professor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`curso_id`),
  KEY `FK5t3kjlgpv6xbcaoailql4xftv` (`fk_professor_id`),
  CONSTRAINT `FK5t3kjlgpv6xbcaoailql4xftv` FOREIGN KEY (`fk_professor_id`) REFERENCES `professor` (`professor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `disciplina` (
  `disciplina_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(10) DEFAULT NULL,
  `creditos` int(11) DEFAULT NULL,
  `ementa` text,
  `nome` varchar(50) DEFAULT NULL,
  `semestre_ideal` int(11) DEFAULT NULL,
  PRIMARY KEY (`disciplina_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `disciplina_oferecida` (
  `disciplina_oferecida_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ano` smallint(6) DEFAULT NULL,
  `dia_semana` varchar(255) DEFAULT NULL,
  `horario` varchar(255) DEFAULT NULL,
  `semestre` int(11) DEFAULT NULL,
  `turma` int(11) DEFAULT NULL,
  `fk_disciplina_id` bigint(20) DEFAULT NULL,
  `fk_professor_id` bigint(20) DEFAULT NULL,
  `fk_sala_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`disciplina_oferecida_id`),
  KEY `FKaulwys96qs5hc8lt0afl8aajn` (`fk_disciplina_id`),
  KEY `FK9rhi6u2ij0f1f661i4khv1b3b` (`fk_professor_id`),
  KEY `FK1n8n5waf1kqryb4r05ok166gm` (`fk_sala_id`),
  CONSTRAINT `FK1n8n5waf1kqryb4r05ok166gm` FOREIGN KEY (`fk_sala_id`) REFERENCES `sala` (`sala_id`),
  CONSTRAINT `FK9rhi6u2ij0f1f661i4khv1b3b` FOREIGN KEY (`fk_professor_id`) REFERENCES `professor` (`professor_id`),
  CONSTRAINT `FKaulwys96qs5hc8lt0afl8aajn` FOREIGN KEY (`fk_disciplina_id`) REFERENCES `disciplina` (`disciplina_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `fotos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content_type` varchar(255) DEFAULT NULL,
  `nome_arquivo` varchar(255) DEFAULT NULL,
  `nome_arquivo_completo` varchar(255) DEFAULT NULL,
  `tamanho` bigint(20) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `grupo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `grupo_permissao` (
  `grupo_id` bigint(20) NOT NULL,
  `permissao_id` bigint(20) NOT NULL,
  PRIMARY KEY (`grupo_id`,`permissao_id`),
  KEY `FKh21kiw0y0hxg6birmdf2ef6vy` (`permissao_id`),
  CONSTRAINT `FKh21kiw0y0hxg6birmdf2ef6vy` FOREIGN KEY (`permissao_id`) REFERENCES `permissao` (`id`),
  CONSTRAINT `FKta4si8vh3f4jo3bsslvkscc2m` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `informe` (
  `informe_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_publicacao` datetime(6) DEFAULT NULL,
  `departamento` int(11) NOT NULL,
  `descricao` text,
  `prioridade` int(11) NOT NULL,
  `titulo` varchar(30) DEFAULT NULL,
  `fk_professor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`informe_id`),
  KEY `FK34gaoli3ql5rmg3biw1ybnj1n` (`fk_professor_id`),
  CONSTRAINT `FK34gaoli3ql5rmg3biw1ybnj1n` FOREIGN KEY (`fk_professor_id`) REFERENCES `professor` (`professor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `nota` (
  `nota_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `valor` decimal(5,2) DEFAULT NULL,
  `fk_cursa_disciplina_oferecida_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`nota_id`),
  KEY `FKhd1q3g18n5xr7lkpvctnmcpby` (`fk_cursa_disciplina_oferecida_id`),
  CONSTRAINT `FKhd1q3g18n5xr7lkpvctnmcpby` FOREIGN KEY (`fk_cursa_disciplina_oferecida_id`) REFERENCES `cursa_disciplina_oferecida` (`cursa_disciplina_oferecida_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `permissao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `pessoa` (
  `pessoa_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_cadastro` datetime(6) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nome` varchar(25) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `sobrenome` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`pessoa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `professor` (
  `professor_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `departamento` int(11) DEFAULT NULL,
  `fk_pessoa_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`professor_id`),
  KEY `FKervdncdshst2kb5htaqn78cvw` (`fk_pessoa_id`),
  CONSTRAINT `FKervdncdshst2kb5htaqn78cvw` FOREIGN KEY (`fk_pessoa_id`) REFERENCES `pessoa` (`pessoa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `requere` (
  `requere_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fk_disciplina_id` bigint(20) DEFAULT NULL,
  `fk_requerida_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`requere_id`),
  KEY `FKg3jhf5juy3kpenji5rb6clufl` (`fk_disciplina_id`),
  KEY `FKamvjsu24i1muxfdyx6o9od24x` (`fk_requerida_id`),
  CONSTRAINT `FKamvjsu24i1muxfdyx6o9od24x` FOREIGN KEY (`fk_requerida_id`) REFERENCES `disciplina` (`disciplina_id`),
  CONSTRAINT `FKg3jhf5juy3kpenji5rb6clufl` FOREIGN KEY (`fk_disciplina_id`) REFERENCES `disciplina` (`disciplina_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `sala` (
  `sala_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `andar` int(11) DEFAULT NULL,
  `capacidade` int(11) DEFAULT NULL,
  `departamento` varchar(40) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`sala_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sistema_academico.telefone
CREATE TABLE IF NOT EXISTS `telefone` (
  `telefone_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `telefone` varchar(15) DEFAULT NULL,
  `fk_pessoa_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`telefone_id`),
  KEY `FK2l2fkuhut50l5ajbyx247c6l0` (`fk_pessoa_id`),
  CONSTRAINT `FK2l2fkuhut50l5ajbyx247c6l0` FOREIGN KEY (`fk_pessoa_id`) REFERENCES `pessoa` (`pessoa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sistema_academico.usuario_grupo
CREATE TABLE IF NOT EXISTS `usuario_grupo` (
  `usuario_id` bigint(20) NOT NULL,
  `grupo_id` bigint(20) NOT NULL,
  PRIMARY KEY (`usuario_id`,`grupo_id`),
  KEY `FKk30suuy31cq5u36m9am4om9ju` (`grupo_id`),
  CONSTRAINT `FKk30suuy31cq5u36m9am4om9ju` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`),
  CONSTRAINT `FKmlpn0s6xmlc9xe1u9fppb6sdp` FOREIGN KEY (`usuario_id`) REFERENCES `pessoa` (`pessoa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;