insert into setor (id, ativo,codigo,email,lotacao,nome) values (1, true, 'INFORMATICA', 'x1@email.com', '01', 'Informática');
insert into setor (id, ativo,codigo,email,lotacao,nome) values (2, true, 'TRANSPORTE', 'x2@email.com', '02', 'Transporte');
insert into setor (id, ativo,codigo,email,lotacao,nome) values (3, true, 'PATRIMONIO', 'x3@email.com', '02', 'Patrimônio');

insert into status (id,codigo,nome) values (1, 'ABERTO', 'Aberto');
insert into status (id,codigo,nome) values (2, 'PENDENTE_CLIENTE', 'Pendente cliente');
insert into status (id,codigo,nome) values (3, 'EM_EXECUCAO', 'Em execução');

insert into usuario(id, login,nome,email) values (1, 'login01', 'Nome 01', 'email01@email.com');
insert into usuario(id, login,nome,email) values (2, 'login02', 'Nome 02', 'email02@email.com');
insert into usuario(id, login,nome,email) values (3, 'login03', 'Nome 03', 'email03@email.com');

insert into solicitacao(titulo, descricao, setor_id, criador_id, responsavel_id, status_id) values ('Titulo 01', 'Descricao 01', 1, 1, 2, 1);
insert into solicitacao(titulo, descricao, setor_id, criador_id, responsavel_id, status_id) values ('Titulo 02', 'Descricao 02', 1, 1, 2, 1);
insert into solicitacao(titulo, descricao, setor_id, criador_id, responsavel_id, status_id) values ('Titulo 03', 'Descricao 03', 2, 1, null, 1);

-- insert into veiculo(placa,modelo,capacidade,lotacao,ativo,quilometragem) values ('ABC-0101', 'Fiat 147', 10, '01', true, 1000);
-- insert into veiculo(placa,modelo,capacidade,lotacao,ativo,quilometragem) values ('XYZ-9999', 'Variant', 20, '01', true, 2000);
-- insert into veiculo(placa,modelo,capacidade,lotacao,ativo,quilometragem) values ('IJK-0011', 'Fusca 69', 15, '01', true, 3000);
