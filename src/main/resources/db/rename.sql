SET foreign_key_checks = 0;  

ALTER TABLE acompanhamento RENAME TO acompanhamento_backup;
ALTER TABLE acompanhamento_item RENAME TO acompanhamento_item_backup;
ALTER TABLE anexo RENAME TO anexo_backup;
ALTER TABLE cargo RENAME TO cargo_backup;
ALTER TABLE estado RENAME TO estado_backup;
ALTER TABLE exercicio RENAME TO exercicio_backup;
ALTER TABLE ferias RENAME TO ferias_backup;
ALTER TABLE funcao RENAME TO funcao_backup;
ALTER TABLE item_nota_fiscal RENAME TO item_nota_fiscal_backup;
ALTER TABLE localizacao RENAME TO localizacao_backup;
ALTER TABLE motorista RENAME TO motorista_backup;
ALTER TABLE nota_fiscal RENAME TO nota_fiscal_backup;
ALTER TABLE passageiro RENAME TO passageiro_backup;
ALTER TABLE patrimonio RENAME TO patrimonio_backup;
ALTER TABLE setor RENAME TO setor_backup;
ALTER TABLE setor_status RENAME TO setor_status_backup;
ALTER TABLE setor_usuario RENAME TO setor_usuario_backup;
ALTER TABLE solicitacao RENAME TO solicitacao_backup;
ALTER TABLE status RENAME TO status_backup;
ALTER TABLE tipo_item RENAME TO tipo_item_backup;
ALTER TABLE transporte RENAME TO transporte_backup;
ALTER TABLE transporte_localizacao RENAME TO transporte_localizacao_backup;
ALTER TABLE uorg RENAME TO uorg_backup;
ALTER TABLE usuario RENAME TO usuario_backup;
ALTER TABLE usuario_interessado RENAME TO usuario_interessado_backup;
ALTER TABLE veiculo RENAME TO veiculo_backup;

CREATE TABLE acompanhamento AS SELECT * FROM acompanhamento_backup;
CREATE TABLE acompanhamento_item AS SELECT * FROM acompanhamento_item_backup;
CREATE TABLE anexo AS SELECT * FROM anexo_backup;
CREATE TABLE cargo AS SELECT * FROM cargo_backup;
CREATE TABLE estado AS SELECT * FROM estado_backup;
CREATE TABLE exercicio AS SELECT * FROM exercicio_backup;
CREATE TABLE ferias AS SELECT * FROM ferias_backup;
CREATE TABLE funcao AS SELECT * FROM funcao_backup;
CREATE TABLE item_nota_fiscal AS SELECT * FROM item_nota_fiscal_backup;
CREATE TABLE localizacao AS SELECT * FROM localizacao_backup;
CREATE TABLE motorista AS SELECT * FROM motorista_backup;
CREATE TABLE nota_fiscal AS SELECT * FROM nota_fiscal_backup;
CREATE TABLE passageiro AS SELECT * FROM passageiro_backup;
CREATE TABLE patrimonio AS SELECT * FROM patrimonio_backup;
CREATE TABLE setor AS SELECT * FROM setor_backup;
CREATE TABLE setor_status AS SELECT * FROM setor_status_backup;
CREATE TABLE setor_usuario AS SELECT * FROM setor_usuario_backup;
CREATE TABLE solicitacao AS SELECT * FROM solicitacao_backup;
CREATE TABLE status AS SELECT * FROM status_backup;
CREATE TABLE tipo_item AS SELECT * FROM tipo_item_backup;
CREATE TABLE transporte AS SELECT * FROM transporte_backup;
CREATE TABLE transporte_localizacao AS SELECT * FROM transporte_localizacao_backup;
CREATE TABLE uorg AS SELECT * FROM uorg_backup;
CREATE TABLE usuario AS SELECT * FROM usuario_backup;
CREATE TABLE usuario_interessado AS SELECT * FROM usuario_interessado_backup;
CREATE TABLE veiculo AS SELECT * FROM veiculo_backup;


UPDATE usuario SET usua_in_ativo = 0 WHERE usua_in_ativo = 'N' OR usua_in_ativo IS NULL;
UPDATE usuario SET usua_in_ativo = 1 WHERE usua_in_ativo = 'S';
ALTER TABLE `usuario` CHANGE `USUA_CD_USUARIO` `id` BIGINT NOT NULL;
ALTER TABLE `usuario` CHANGE `USUA_TX_LOGIN` `login` VARCHAR(45) NOT NULL;
ALTER TABLE `usuario` CHANGE `USUA_TX_NOME` `nome` VARCHAR(100) NOT NULL;
ALTER TABLE `usuario` CHANGE `USUA_TX_EMAIL` `email` VARCHAR(100) NULL DEFAULT NULL;
ALTER TABLE `usuario` CHANGE `USUA_TX_TELEFONE` `telefone` VARCHAR(45) NULL DEFAULT NULL;
ALTER TABLE `usuario` CHANGE `USUA_IN_ATIVO` `ativo` TINYINT(1) NULL DEFAULT 1;
ALTER TABLE `usuario` CHANGE `USUA_IN_RESETA_SENHA` `reseta_senha` VARCHAR(1) NULL DEFAULT 'N';
ALTER TABLE `usuario` CHANGE `USUA_TX_CPF` `cpf` VARCHAR(20) NULL;
ALTER TABLE `usuario` CHANGE `USUA_TX_MATRICULA` `matricula` VARCHAR(30) NULL;
ALTER TABLE `usuario` CHANGE `USUA_TX_ENDERECO` `endereco` VARCHAR(300) NULL;
ALTER TABLE `usuario` CHANGE `USUA_TX_LOCALIZACAO` `localizacao` VARCHAR(100) NULL;
ALTER TABLE `usuario` CHANGE `USUA_TX_TELEFONE2` `telefone2` VARCHAR(45) NULL;
ALTER TABLE `usuario` CHANGE `USUA_TX_ENDERECO2` `endereco2` VARCHAR(300) NULL;
ALTER TABLE `usuario` CHANGE `USUA_DT_INGRESSO` `data_ingresso` DATE NULL;
ALTER TABLE `usuario` CHANGE `USUA_TX_STATUS` `status` VARCHAR(1) NULL DEFAULT '1';
ALTER TABLE `usuario` CHANGE `USUA_TX_ARQUIVO_FOTO` `arquivo_foto` VARCHAR(100) NULL;
ALTER TABLE `usuario` CHANGE `USUA_DT_NASCIMENTO` `data_nascimento` DATE NULL;
ALTER TABLE `usuario` CHANGE `USUA_TX_RAMAL` `ramal` VARCHAR(45) NULL;
ALTER TABLE `usuario` CHANGE `USUA_DT_ATUALIZACAO` `data_atualizacao` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE `usuario` CHANGE `USUA_IN_LOTACAO` `lotacao` VARCHAR(2) NULL;
ALTER TABLE `usuario` CHANGE `UORG_CD_UORG` `uorg_id` BIGINT NULL;
ALTER TABLE `usuario` CHANGE `CARG_CD_CARGO` `cargo_id` BIGINT NULL;
ALTER TABLE `usuario` CHANGE `FUNC_CD_FUNCAO` `funcao_id` BIGINT NULL;
-- OBS: USUA_DT_ATUALIZACAO: on update CURRENT_TIMESTAM




UPDATE uorg SET UORG_IN_ATIVO = 0 WHERE UORG_IN_ATIVO = 'N' OR UORG_IN_ATIVO IS NULL;
UPDATE uorg SET UORG_IN_ATIVO = 1 WHERE UORG_IN_ATIVO = 'S';
ALTER TABLE `uorg` CHANGE `UORG_CD_UORG` `id` BIGINT NOT NULL;
ALTER TABLE `uorg` CHANGE `UORG_TX_CODIGO` `codigo` VARCHAR(45) NULL;
ALTER TABLE `uorg` CHANGE `UORG_TX_NOME` `nome` VARCHAR(200) NOT NULL;
ALTER TABLE `uorg` CHANGE `UORG_IN_ATIVO` `ativo` TINYINT(1) NOT NULL DEFAULT 1;

UPDATE cargo SET CARG_IN_ATIVO = 0 WHERE CARG_IN_ATIVO = 'N' OR CARG_IN_ATIVO IS NULL;
UPDATE cargo SET CARG_IN_ATIVO = 1 WHERE CARG_IN_ATIVO = 'S';
ALTER TABLE `cargo` CHANGE `CARG_CD_CARGO` `id` BIGINT NOT NULL;
ALTER TABLE `cargo` CHANGE `CARG_TX_CODIGO` `codigo` VARCHAR(45) NULL;
ALTER TABLE `cargo` CHANGE `CARG_TX_NOME` `nome` VARCHAR(200) NOT NULL;
ALTER TABLE `cargo` CHANGE `CARG_IN_ATIVO` `ativo` TINYINT(1) NOT NULL DEFAULT 1;

UPDATE funcao SET FUNC_IN_ATIVO = 0 WHERE FUNC_IN_ATIVO = 'N' OR FUNC_IN_ATIVO IS NULL;
UPDATE funcao SET FUNC_IN_ATIVO = 1 WHERE FUNC_IN_ATIVO = 'S';
ALTER TABLE `funcao` CHANGE `FUNC_CD_FUNCAO` `id` BIGINT NOT NULL;
ALTER TABLE `funcao` CHANGE `FUNC_TX_CODIGO` `codigo` VARCHAR(45) NULL;
ALTER TABLE `funcao` CHANGE `FUNC_TX_NOME` `nome` VARCHAR(200) NOT NULL;
ALTER TABLE `funcao` CHANGE `FUNC_IN_ATIVO` `ativo` TINYINT(1) NOT NULL DEFAULT 1;

UPDATE ferias SET FERI_IN_ATIVO = 0 WHERE FERI_IN_ATIVO = 'N' OR FERI_IN_ATIVO IS NULL;
UPDATE ferias SET FERI_IN_ATIVO = 1 WHERE FERI_IN_ATIVO = 'S';
ALTER TABLE `ferias` CHANGE `FERI_CD_FERIAS` `id` BIGINT NOT NULL;
ALTER TABLE `ferias` CHANGE `USUA_CD_USUARIO` `usuario_id` BIGINT NOT NULL;
ALTER TABLE `ferias` CHANGE `EXER_CD_EXERCICIO` `exercicio_id` BIGINT NOT NULL;
ALTER TABLE `ferias` CHANGE `FERI_DT_INICIO` `inicio` DATETIME NOT NULL;
ALTER TABLE `ferias` CHANGE `FERI_DT_FIM` `fim` DATETIME NOT NULL;
ALTER TABLE `ferias` CHANGE `FERI_IN_ATIVO` `ativo` TINYINT(1) NOT NULL DEFAULT 1;
  

ALTER TABLE `exercicio` CHANGE `EXER_CD_EXERCICIO` `id` BIGINT NOT NULL;
ALTER TABLE `exercicio` CHANGE `EXER_TX_CODIGO` `codigo` VARCHAR(45) NOT NULL;
ALTER TABLE `exercicio` CHANGE `EXER_NR_ANO` `ano` INT NOT NULL;
ALTER TABLE `exercicio` ADD `ativo` TINYINT(1) NULL DEFAULT 1;



UPDATE motorista SET MOTO_IN_ATIVO = 0 WHERE MOTO_IN_ATIVO = 'N' OR MOTO_IN_ATIVO IS NULL;
UPDATE motorista SET MOTO_IN_ATIVO = 1 WHERE MOTO_IN_ATIVO = 'S';
ALTER TABLE `motorista` CHANGE `MOTO_CD_MOTORISTA` `id` BIGINT NOT NULL;
ALTER TABLE `motorista` CHANGE `USUA_CD_USUARIO`  `usuario_id` BIGINT NOT NULL;
ALTER TABLE `motorista` CHANGE `MOTO_IN_TURNO` `turno` INT NOT NULL;
ALTER TABLE `motorista` CHANGE `MOTO_IN_ATIVO` `ativo` TINYINT(1) NULL DEFAULT 1;
ALTER TABLE `motorista` CHANGE `MOTO_IN_LOTACAO` `lotacao` VARCHAR(2) NOT NULL DEFAULT '01';


ALTER TABLE `passageiro` CHANGE `PASS_CD_PASSAGEIRO` `id` BIGINT NOT NULL;
ALTER TABLE `passageiro` CHANGE `TRAN_CD_TRANSPORTE` `transporte_id` BIGINT NOT NULL;
ALTER TABLE `passageiro` CHANGE `PASS_TX_NOME` `nome` VARCHAR(100) NOT NULL;
ALTER TABLE `passageiro` CHANGE `PASS_TX_IDENTIFICADOR` `identificador` VARCHAR(45) NOT NULL;
ALTER TABLE `passageiro` ADD `ativo` TINYINT(1) NULL DEFAULT 1;


ALTER TABLE `transporte` CHANGE `TRAN_CD_TRANSPORTE` `id` BIGINT NOT NULL;
ALTER TABLE `transporte` CHANGE `SOLI_CD_SOLICITACAO` `solicitacao_id` BIGINT NOT NULL;
ALTER TABLE `transporte` CHANGE `TRAN_TX_ENDERECO_ORIGEM` `endereco_origem` VARCHAR(100) NOT NULL;
ALTER TABLE `transporte` CHANGE `TRAN_TX_ENDERECO_DESTINO` `endereco_destino` VARCHAR(100) NOT NULL;
ALTER TABLE `transporte` CHANGE `TRAN_DT_SAIDA_ORIGEM` `data_saida_origem` TIMESTAMP NOT NULL;
ALTER TABLE `transporte` CHANGE `TRAN_DT_SAIDA_DESTINO` `data_saida_destino` TIMESTAMP NULL;
ALTER TABLE `transporte` CHANGE `TRAN_NR_PASSAGEIROS` `quantidade_passageiros` INT NOT NULL;
ALTER TABLE `transporte` CHANGE `TRAN_IN_STATUS` `status` INT NOT NULL;
ALTER TABLE `transporte` CHANGE `VEIC_CD_VEICULO` `veiculo_id` BIGINT NULL;
ALTER TABLE `transporte` CHANGE `MOTO_CD_MOTORISTA` `motorista_id` BIGINT NULL;
ALTER TABLE `transporte` CHANGE `ESTA_CD_ESTADO` `estado_id` BIGINT NOT NULL;
ALTER TABLE `transporte` CHANGE `TRAN_TX_CIDADE_ORIGEM` `cidade_origem` VARCHAR(45) NOT NULL;
ALTER TABLE `transporte` CHANGE `TRAN_TX_CIDADE_DESTINO` `cidade_destino` VARCHAR(45) NOT NULL;
ALTER TABLE `transporte` CHANGE `TRAN_IN_TIPO` `tipo` INT(11) NOT NULL DEFAULT 1;
ALTER TABLE `transporte` CHANGE `TRAN_TX_TELEFONE` `telefone` VARCHAR(35) NOT NULL;
ALTER TABLE `transporte` CHANGE `TRAN_IN_QUILOMETRAGEM_INICIO` `quilometragem_inicio` INT NULL;
ALTER TABLE `transporte` CHANGE `TRAN_IN_QUILOMETRAGEM_FIM` `quilometragem_fim` INT NULL;
ALTER TABLE `transporte` CHANGE `TRAN_IN_DIARIA` `diaria` DECIMAL(2,1) NULL;

  

UPDATE veiculo SET VEIC_IN_ATIVO = 0 WHERE VEIC_IN_ATIVO = 'N' OR VEIC_IN_ATIVO IS NULL;
UPDATE veiculo SET VEIC_IN_ATIVO = 1 WHERE VEIC_IN_ATIVO = 'S';
ALTER TABLE `veiculo` CHANGE `VEIC_CD_VEICULO` `id` BIGINT NOT NULL;
ALTER TABLE `veiculo` CHANGE `VEIC_TX_PLACA` `placa` VARCHAR(20) NULL;
ALTER TABLE `veiculo` CHANGE `VEIC_TX_MODELO` `modelo` VARCHAR(100) NULL;
ALTER TABLE `veiculo` CHANGE `VEIC_NR_CAPACIDADE` `capacidade` INT NULL;
ALTER TABLE `veiculo` CHANGE `VEIC_IN_LOTACAO` `lotacao` VARCHAR(2) NOT NULL DEFAULT '01';
ALTER TABLE `veiculo` CHANGE `VEIC_IN_ATIVO` `ativo` TINYINT(1) NULL DEFAULT 1;
ALTER TABLE `veiculo` CHANGE `VEIC_IN_QUILOMETRAGEM` `quilometragem` INT NULL;



ALTER TABLE `transporte_localizacao` CHANGE `TRLO_CD_TRANS_LOCALIZACAO` `id` BIGINT NOT NULL;
ALTER TABLE `transporte_localizacao` CHANGE `ESTA_CD_ESTADO` `estado_id` BIGINT NOT NULL;
ALTER TABLE `transporte_localizacao` CHANGE `TRLO_TX_NOME` `nome` VARCHAR(45) NOT NULL;
ALTER TABLE `transporte_localizacao` CHANGE `TRLO_TX_ENDERECO` `endereco` VARCHAR(200) NOT NULL;
ALTER TABLE `transporte_localizacao` CHANGE `TRLO_TX_CIDADE` `cidade` VARCHAR(45) NOT NULL;
ALTER TABLE `transporte_localizacao` ADD `ativo` TINYINT(1) NULL DEFAULT 1;


UPDATE estado SET ESTA_IN_ATIVO = 0 WHERE ESTA_IN_ATIVO = 'N' OR ESTA_IN_ATIVO IS NULL;
UPDATE estado SET ESTA_IN_ATIVO = 1 WHERE ESTA_IN_ATIVO = 'S';
ALTER TABLE `estado` CHANGE `ESTA_CD_ESTADO` `id` BIGINT NOT NULL;
ALTER TABLE `estado` CHANGE `ESTA_TX_NOME` `nome` VARCHAR(80) NOT NULL;
ALTER TABLE `estado` CHANGE `ESTA_TX_SIGLA` `sigla` VARCHAR(45) NOT NULL;
ALTER TABLE `estado` CHANGE `ESTA_IN_ATIVO` `ativo` TINYINT(1) NULL DEFAULT 1;



ALTER TABLE `usuario_interessado` CHANGE `USIN_CD_USUARIO_INTERESSADO` `id` BIGINT NOT NULL;
ALTER TABLE `usuario_interessado` CHANGE `USUA_CD_USUARIO` `usuario_id` BIGINT NOT NULL;
ALTER TABLE `usuario_interessado` CHANGE `SOLI_CD_SOLICITACAO` `solicitacao_id` BIGINT NOT NULL;

UPDATE setor_usuario SET SEUS_IN_ATIVO = 0 WHERE SEUS_IN_ATIVO = 'N' OR SEUS_IN_ATIVO IS NULL;
UPDATE setor_usuario SET SEUS_IN_ATIVO = 1 WHERE SEUS_IN_ATIVO = 'S';
ALTER TABLE `setor_usuario` CHANGE `SEUS_CD_SETOR_USUARIO` `id` BIGINT NOT NULL;
ALTER TABLE `setor_usuario` CHANGE `USUA_CD_USUARIO` `usuario_id` BIGINT NOT NULL;
ALTER TABLE `setor_usuario` CHANGE `SETO_CD_SETOR` `setor_id` BIGINT NOT NULL;
ALTER TABLE `setor_usuario` CHANGE `SEUS_IN_ATIVO` `ativo` TINYINT(1) NULL DEFAULT 1;
ALTER TABLE `setor_usuario` CHANGE `SEUS_IN_TIPO` `tipo` VARCHAR(1) NULL;


UPDATE setor SET SETO_IN_ATIVO = 0 WHERE SETO_IN_ATIVO = 'N' OR SETO_IN_ATIVO IS NULL;
UPDATE setor SET SETO_IN_ATIVO = 1 WHERE SETO_IN_ATIVO = 'S';
ALTER TABLE `setor` CHANGE `SETO_CD_SETOR` `id` BIGINT NOT NULL;
ALTER TABLE `setor` CHANGE `SETO_TX_NOME` `nome` VARCHAR(100) NOT NULL;
ALTER TABLE `setor` CHANGE `SETO_TX_EMAIL` `email` VARCHAR(200) NULL DEFAULT NULL;
ALTER TABLE `setor` CHANGE `SETO_IN_ATIVO` `ativo` TINYINT(1) NULL DEFAULT 1;
ALTER TABLE `setor` CHANGE `SETO_IN_LOTACAO` `lotacao` VARCHAR(2) NOT NULL DEFAULT '01';
ALTER TABLE `setor` ADD `codigo` VARCHAR(50) NULL DEFAULT NULL;
UPDATE setor SET codigo = 'INFORMATICA' where id = 15;
UPDATE setor SET codigo = 'TRANSPORTE' where id = 13;
UPDATE setor SET codigo = 'ALMOXARIFADO' where id = 9;
UPDATE setor SET codigo = 'PATRIMONIO' where id = 11;


ALTER TABLE `setor_status` CHANGE `SEST_CD_SETOR_STATUS` `id` BIGINT NOT NULL;
ALTER TABLE `setor_status` CHANGE `STAT_CD_STATUS` `status_id` BIGINT NOT NULL;
ALTER TABLE `setor_status` CHANGE `SETO_CD_SETOR` `setor_id` BIGINT NOT NULL;
ALTER TABLE `setor_status` ADD `ativo` TINYINT(1) NULL DEFAULT 1;


ALTER TABLE `status` CHANGE `STAT_CD_STATUS` `id` BIGINT NOT NULL;
ALTER TABLE `status` CHANGE `STAT_IN_STATUS` `codigo` VARCHAR(50) NOT NULL;
ALTER TABLE `status` CHANGE `STAT_NM_STATUS` `nome` VARCHAR(20) NOT NULL;
UPDATE status SET codigo = 'CONCLUIDO' where id = 1;
UPDATE status SET codigo = 'ABERTO' where id = 2;
UPDATE status SET codigo = 'CANCELADO' where id = 3;
UPDATE status SET codigo = 'PENDENTE_CLIENTE' where id = 4;
UPDATE status SET codigo = 'EM_EXECUCAO' where id = 5;
UPDATE status SET codigo = 'PENDENTE' where id = 6;
UPDATE status SET codigo = 'EM_ANALISE' where id = 7;


ALTER TABLE `solicitacao` CHANGE `SOLI_CD_SOLICITACAO` `id` BIGINT NOT NULL;
ALTER TABLE `solicitacao` CHANGE `STAT_CD_STATUS` `status_id` BIGINT NOT NULL;
ALTER TABLE `solicitacao` CHANGE `SETO_CD_SETOR` `setor_id` BIGINT NOT NULL;
ALTER TABLE `solicitacao` CHANGE `USUA_CD_USUARIO_CRIADOR` `criador_id` BIGINT NOT NULL;
ALTER TABLE `solicitacao` CHANGE `USUA_CD_USUARIO_RESPONSAVEL` `responsavel_id` BIGINT NULL DEFAULT NULL;
ALTER TABLE `solicitacao` CHANGE `SOLI_TX_TITULO` `titulo` VARCHAR(100) NOT NULL;
ALTER TABLE `solicitacao` CHANGE `SOLI_TX_DESCRICAO` `descricao` VARCHAR(2000) NULL DEFAULT NULL;
ALTER TABLE `solicitacao` CHANGE `SOLI_DT_CRIACAO` `criacao` DATETIME NOT NULL;


ALTER TABLE `acompanhamento` CHANGE `ACOM_CD_ACOMPANHAMENTO` `id` BIGINT NOT NULL;
ALTER TABLE `acompanhamento` CHANGE `SOLI_CD_SOLICITACAO` `solicitacao_id` BIGINT NOT NULL;
ALTER TABLE `acompanhamento` CHANGE `ACOM_DT_ACOMPANHAMENTO` `criacao` DATETIME NOT NULL;
ALTER TABLE `acompanhamento` CHANGE `ACOM_TX_DESCRICAO` `descricao` VARCHAR(5000) NULL DEFAULT NULL;
ALTER TABLE `acompanhamento` CHANGE `USUA_CD_USUARIO` `usuario_id` BIGINT NOT NULL;
ALTER TABLE `acompanhamento` CHANGE `STAT_CD_STATUS` `status_id` BIGINT NOT NULL;


ALTER TABLE `anexo` CHANGE `ANEX_CD_ANEXO` `id` BIGINT NOT NULL;
ALTER TABLE `anexo` CHANGE `ANEX_NM_ARQUIVO` `nome` VARCHAR(200) NOT NULL;
ALTER TABLE `anexo` CHANGE `ACOM_CD_ACOMPANHAMENTO` `acompanhamento_id` BIGINT NOT NULL;


ALTER TABLE `acompanhamento_item` CHANGE `ACIT_CD_ACOMPANHAMENTO_ITEM` `id` BIGINT NOT NULL;
ALTER TABLE `acompanhamento_item` CHANGE `ACOM_CD_ACOMPANHAMENTO` `acompanhamento_id` BIGINT NOT NULL;
ALTER TABLE `acompanhamento_item` CHANGE `PATR_CD_PATRIMONIO` `patrimonio_id` BIGINT NULL DEFAULT NULL;
ALTER TABLE `acompanhamento_item` CHANGE `ITNF_CD_ITEM_NF` `item_nota_fiscal_id` BIGINT NOT NULL;
ALTER TABLE `acompanhamento_item` CHANGE `ACIT_NR_QUANTIDADE` `quantidade` INT(11) NOT NULL;
ALTER TABLE `acompanhamento_item` CHANGE `LOCA_CD_LOCALIZACAO_ORIGEM` `origem_id` BIGINT NOT NULL;
ALTER TABLE `acompanhamento_item` CHANGE `ACIT_IN_APROVADO` `aprovado` VARCHAR(1) NOT NULL;
ALTER TABLE `acompanhamento_item` CHANGE `LOCA_CD_LOCALIZACAO_DESTINO` `destino_id` BIGINT NOT NULL;


UPDATE localizacao SET LOCA_IN_ATIVO = 0 WHERE LOCA_IN_ATIVO = 'N' OR LOCA_IN_ATIVO IS NULL;
UPDATE localizacao SET LOCA_IN_ATIVO = 1 WHERE LOCA_IN_ATIVO = 'S';
ALTER TABLE `localizacao` CHANGE `LOCA_CD_LOCALIZACAO` `id` BIGINT NOT NULL;
ALTER TABLE `localizacao` CHANGE `LOCA_NM_LOCALIZACAO` `nome` VARCHAR(100) NOT NULL;
ALTER TABLE `localizacao` CHANGE `LOCA_TX_DESCRICAO` `descricao` VARCHAR(250) NULL DEFAULT NULL;
ALTER TABLE `localizacao` CHANGE `LOCA_IN_ATIVO` `ativo` TINYINT(1) NULL DEFAULT 1;



ALTER TABLE `patrimonio` CHANGE `PATR_CD_PATRIMONIO` `id` BIGINT NOT NULL;
ALTER TABLE `patrimonio` CHANGE `ITNF_CD_ITEM_NF` `item_nota_fiscal_id` BIGINT NOT NULL;
ALTER TABLE `patrimonio` CHANGE `LOCA_CD_LOCALIZACAO_ATUAL` `localizacao_id` BIGINT NULL;
ALTER TABLE `patrimonio` CHANGE `PATR_CD_TOMBAMENTO` `tombamento` VARCHAR(20) NOT NULL;
ALTER TABLE `patrimonio` CHANGE `PATR_IN_STATUS` `status` VARCHAR(1) NULL DEFAULT '1';


UPDATE nota_fiscal SET NOFI_IN_ATIVO = 0 WHERE NOFI_IN_ATIVO = 'N' OR NOFI_IN_ATIVO IS NULL;
UPDATE nota_fiscal SET NOFI_IN_ATIVO = 1 WHERE NOFI_IN_ATIVO = 'S';
ALTER TABLE `nota_fiscal` CHANGE `NOFI_CD_NOTA_FISCAL` `id` BIGINT NOT NULL;
ALTER TABLE `nota_fiscal` CHANGE `NOFI_TX_NUMERO` `numero` VARCHAR(45) NOT NULL;
ALTER TABLE `nota_fiscal` CHANGE `NOFI_TX_EMPRESA` `empresa` VARCHAR(100) NOT NULL;
ALTER TABLE `nota_fiscal` CHANGE `NOFI_TX_OBSERVACAO` `observacao` VARCHAR(400) NULL DEFAULT NULL;
ALTER TABLE `nota_fiscal` CHANGE `NOFI_DT_COMPRA` `compra` DATETIME NOT NULL;
ALTER TABLE `nota_fiscal` CHANGE `NOFI_DT_FINAL_GARANTIA` `final_garantia` DATETIME NULL DEFAULT NULL;
ALTER TABLE `nota_fiscal` CHANGE `NOFI_IN_ATIVO` `ativo` TINYINT(1) NULL DEFAULT 1;


UPDATE item_nota_fiscal SET ITNF_IN_ATIVO = 0 WHERE ITNF_IN_ATIVO = 'N' OR ITNF_IN_ATIVO IS NULL;
UPDATE item_nota_fiscal SET ITNF_IN_ATIVO = 1 WHERE ITNF_IN_ATIVO = 'S';
ALTER TABLE `item_nota_fiscal` CHANGE `ITNF_CD_ITEM_NF` `id` BIGINT NOT NULL;
ALTER TABLE `item_nota_fiscal` CHANGE `TIIT_CD_TIPO_ITEM` `tipo_item_id` BIGINT NOT NULL;
ALTER TABLE `item_nota_fiscal` CHANGE `NOFI_CD_NOTA_FISCAL` `nota_fiscal_id` BIGINT NOT NULL;
ALTER TABLE `item_nota_fiscal` CHANGE `ITNF_TX_DESCRICAO` `descricao` VARCHAR(400) NULL DEFAULT NULL;
ALTER TABLE `item_nota_fiscal` CHANGE `ITNF_NR_QUANTIDADE` `quantidade_original` INT(11) NOT NULL;
ALTER TABLE `item_nota_fiscal` CHANGE `ITNF_NR_QUANTIDADE_ESTOQUE` `quantidade_estoque` INT(11) NOT NULL;
ALTER TABLE `item_nota_fiscal` CHANGE `ITNF_TX_ARQUIVO_FOTO` `arquivo_foto` VARCHAR(45) NULL;
ALTER TABLE `item_nota_fiscal` CHANGE `ITNF_IN_ATIVO` `ativo` TINYINT(1) NULL DEFAULT 1;


ALTER TABLE `tipo_item` CHANGE `TIIT_CD_TIPO_ITEM` `id` BIGINT NOT NULL;
ALTER TABLE `tipo_item` CHANGE `TIIT_TX_NOME` `nome` VARCHAR(100) NOT NULL;
ALTER TABLE `tipo_item` ADD `ativo` TINYINT(1) NULL DEFAULT 1;








-- Rodar depois das alteracoes das tabelas:

-- Chaves Primarias:
ALTER TABLE acompanhamento ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE acompanhamento_item ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE anexo ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE cargo ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE estado ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE exercicio ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE funcao ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE item_nota_fiscal ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE localizacao ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE motorista ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE nota_fiscal ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE passageiro ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE patrimonio ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE setor ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE setor_status ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE setor_usuario ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE solicitacao ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE status ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE tipo_item ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE transporte ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE transporte_localizacao ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE uorg ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE usuario ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE usuario_interessado ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE veiculo ADD PRIMARY KEY (id), MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;


-- FK de cada tabela:
ALTER TABLE usuario ADD CONSTRAINT FOREIGN KEY (uorg_id) REFERENCES uorg(id);
ALTER TABLE usuario ADD CONSTRAINT FOREIGN KEY (cargo_id) REFERENCES cargo(id);
ALTER TABLE usuario ADD CONSTRAINT FOREIGN KEY (funcao_id) REFERENCES funcao(id);
ALTER TABLE usuario ADD UNIQUE INDEX  (`login` ASC);
ALTER TABLE usuario ADD INDEX (`uorg_id` ASC);
ALTER TABLE usuario ADD INDEX (`cargo_id` ASC);
ALTER TABLE usuario ADD INDEX (`funcao_id` ASC);

ALTER TABLE uorg ADD UNIQUE INDEX (`codigo` ASC);

ALTER TABLE solicitacao ADD CONSTRAINT FOREIGN KEY (setor_id) REFERENCES setor(id);
ALTER TABLE solicitacao ADD CONSTRAINT FOREIGN KEY (status_id) REFERENCES status(id);
ALTER TABLE solicitacao ADD CONSTRAINT FOREIGN KEY (criador_id) REFERENCES usuario(id);
ALTER TABLE solicitacao ADD CONSTRAINT FOREIGN KEY (responsavel_id) REFERENCES usuario(id);
ALTER TABLE solicitacao ADD INDEX (`criador_id` ASC);
ALTER TABLE solicitacao ADD INDEX (`responsavel_id` ASC);
ALTER TABLE solicitacao ADD INDEX (`status_id` ASC);
ALTER TABLE solicitacao ADD INDEX (`setor_id` ASC);


ALTER TABLE acompanhamento ADD CONSTRAINT FOREIGN KEY (solicitacao_id) REFERENCES solicitacao(id);
ALTER TABLE acompanhamento ADD CONSTRAINT FOREIGN KEY (status_id) REFERENCES status(id);
ALTER TABLE acompanhamento ADD CONSTRAINT FOREIGN KEY (usuario_id) REFERENCES usuario(id);
ALTER TABLE acompanhamento ADD INDEX (`solicitacao_id` ASC);
ALTER TABLE acompanhamento ADD INDEX (`usuario_id` ASC);
ALTER TABLE acompanhamento ADD INDEX (`status_id` ASC);

ALTER TABLE tipo_item ADD UNIQUE INDEX (`nome` ASC);


ALTER TABLE item_nota_fiscal ADD CONSTRAINT FOREIGN KEY (nota_fiscal_id) REFERENCES nota_fiscal(id);
ALTER TABLE item_nota_fiscal ADD CONSTRAINT FOREIGN KEY (tipo_item_id) REFERENCES tipo_item(id);
ALTER TABLE item_nota_fiscal ADD INDEX (`tipo_item_id` ASC);
ALTER TABLE item_nota_fiscal ADD INDEX (`nota_fiscal_id` ASC);


ALTER TABLE patrimonio ADD CONSTRAINT FOREIGN KEY (item_nota_fiscal_id) REFERENCES item_nota_fiscal(id);
ALTER TABLE patrimonio ADD CONSTRAINT FOREIGN KEY (localizacao_id) REFERENCES localizacao(id);
ALTER TABLE patrimonio ADD INDEX (`item_nota_fiscal_id` ASC);
ALTER TABLE patrimonio ADD INDEX (`localizacao_id` ASC);
ALTER TABLE patrimonio ADD UNIQUE INDEX (`tombamento` ASC);


ALTER TABLE acompanhamento_item ADD CONSTRAINT FOREIGN KEY (acompanhamento_id) REFERENCES acompanhamento(id);
ALTER TABLE acompanhamento_item ADD CONSTRAINT FOREIGN KEY (item_nota_fiscal_id) REFERENCES item_nota_fiscal(id);
ALTER TABLE acompanhamento_item ADD CONSTRAINT FOREIGN KEY (origem_id) REFERENCES localizacao(id);
ALTER TABLE acompanhamento_item ADD CONSTRAINT FOREIGN KEY (patrimonio_id) REFERENCES patrimonio(id);
ALTER TABLE acompanhamento_item ADD CONSTRAINT FOREIGN KEY (destino_id) REFERENCES localizacao(id);
ALTER TABLE acompanhamento_item ADD INDEX (`acompanhamento_id` ASC);
ALTER TABLE acompanhamento_item ADD INDEX (`patrimonio_id` ASC);
ALTER TABLE acompanhamento_item ADD INDEX (`item_nota_fiscal_id` ASC);
ALTER TABLE acompanhamento_item ADD INDEX (`origem_id` ASC);
ALTER TABLE acompanhamento_item ADD INDEX (`destino_id` ASC);


ALTER TABLE anexo ADD CONSTRAINT FOREIGN KEY (acompanhamento_id) REFERENCES acompanhamento(id);
ALTER TABLE anexo ADD INDEX (`acompanhamento_id` ASC);



ALTER TABLE setor_status ADD CONSTRAINT FOREIGN KEY (setor_id) REFERENCES setor(id);
ALTER TABLE setor_status ADD CONSTRAINT FOREIGN KEY (status_id) REFERENCES status(id);
ALTER TABLE setor_status ADD INDEX (`status_id` ASC);
ALTER TABLE setor_status ADD INDEX (`setor_id` ASC);


ALTER TABLE setor_usuario ADD CONSTRAINT FOREIGN KEY (usuario_id) REFERENCES usuario(id);
ALTER TABLE setor_usuario ADD CONSTRAINT FOREIGN KEY (setor_id) REFERENCES setor(id);
ALTER TABLE setor_usuario ADD INDEX (`setor_id` ASC);
ALTER TABLE setor_usuario ADD INDEX (`usuario_id` ASC);

ALTER TABLE motorista ADD CONSTRAINT FOREIGN KEY (usuario_id) REFERENCES usuario(id);
ALTER TABLE motorista ADD INDEX (`usuario_id` ASC);


ALTER TABLE estado ADD UNIQUE INDEX (`sigla` ASC);
ALTER TABLE estado ADD UNIQUE INDEX (`nome` ASC);
ALTER TABLE estado ADD UNIQUE INDEX (`id` ASC);



ALTER TABLE transporte ADD CONSTRAINT FOREIGN KEY (solicitacao_id) REFERENCES solicitacao(id);
ALTER TABLE transporte ADD CONSTRAINT FOREIGN KEY (veiculo_id) REFERENCES veiculo(id);
ALTER TABLE transporte ADD CONSTRAINT FOREIGN KEY (motorista_id) REFERENCES motorista(id);
ALTER TABLE transporte ADD CONSTRAINT FOREIGN KEY (estado_id) REFERENCES estado(id);
ALTER TABLE transporte ADD INDEX (`solicitacao_id` ASC);
ALTER TABLE transporte ADD INDEX (`veiculo_id` ASC);
ALTER TABLE transporte ADD INDEX (`motorista_id` ASC);
ALTER TABLE transporte ADD INDEX (`estado_id` ASC);


ALTER TABLE transporte_localizacao ADD CONSTRAINT FOREIGN KEY (estado_id) REFERENCES estado(id);
ALTER TABLE transporte_localizacao ADD INDEX (`estado_id` ASC);


ALTER TABLE passageiro ADD CONSTRAINT FOREIGN KEY (transporte_id) REFERENCES transporte(id);
ALTER TABLE passageiro ADD INDEX (`transporte_id` ASC);



ALTER TABLE usuario_interessado ADD CONSTRAINT FOREIGN KEY (usuario_id) REFERENCES usuario(id);
ALTER TABLE usuario_interessado ADD CONSTRAINT FOREIGN KEY (solicitacao_id) REFERENCES solicitacao(id);
ALTER TABLE usuario_interessado ADD INDEX (`usuario_id` ASC);
ALTER TABLE usuario_interessado ADD INDEX (`solicitacao_id` ASC);

ALTER TABLE ferias ADD CONSTRAINT FOREIGN KEY (usuario_id) REFERENCES usuario(id);
ALTER TABLE ferias ADD CONSTRAINT FOREIGN KEY (exercicio_id) REFERENCES exercicio(id);
ALTER TABLE ferias ADD INDEX (`usuario_id` ASC);
ALTER TABLE ferias ADD INDEX (`exercicio_id` ASC);


SET foreign_key_checks = 1;  

drop trigger if exists `transporte_status_trigger`;
DELIMITER $$
CREATE TRIGGER `transporte_status_trigger`
AFTER UPDATE on `solicitacao`
FOR EACH ROW BEGIN
    DECLARE transporteStatus INT DEFAULT 0;
    IF NEW.status_id != OLD.status_id THEN
        -- Cancelado -> Cancelado:
        IF NEW.status_id = 3  THEN
            SET transporteStatus = 5;
        -- Em analise -> Aguardando aprovacao:
        -- Para caso de alterar manualmente para "em analise". O transporte deve voltar para aguard aprovacao.
        -- Poderia incluir tambem "aberto" ou algo parecido...
        ELSEIF NEW.status_id = 7 THEN 
            SET transporteStatus = 1;
        -- ELSEIF NEW.status_id = 3 THEN 
        --    SET transporteStatus = 5;
        END IF;
        IF transporteStatus <> 0 THEN
            UPDATE `transporte` SET status = transporteStatus
            WHERE id = NEW.id;
        END IF;
    END IF;
END$$
DELIMITER ;


-- DROP TABLE acompanhamento_backup;
-- DROP TABLE acompanhamento_item_backup;
-- DROP TABLE anexo_backup;
-- DROP TABLE cargo_backup;
-- DROP TABLE estado_backup;
-- DROP TABLE exercicio_backup;
-- DROP TABLE funcao_backup;
-- DROP TABLE item_nota_fiscal_backup;
-- DROP TABLE localizacao_backup;
-- DROP TABLE motorista_backup;
-- DROP TABLE nota_fiscal_backup;
-- DROP TABLE passageiro_backup;
-- DROP TABLE patrimonio_backup;
-- DROP TABLE setor_backup;
-- DROP TABLE setor_status_backup;
-- DROP TABLE setor_usuario_backup;
-- DROP TABLE solicitacao_backup;
-- DROP TABLE status_backup;
-- DROP TABLE tipo_item_backup;
-- DROP TABLE transporte_backup;
-- DROP TABLE transporte_localizacao_backup;
-- DROP TABLE uorg_backup;
-- DROP TABLE usuario_backup;
-- DROP TABLE usuario_interessado_backup;
-- DROP TABLE veiculo_backup;

-- Check for sequences?
-- show table status
-- select max(id) from setor
-- ALTER TABLE setor AUTO_INCREMENT = <value from step 1 + 100>;