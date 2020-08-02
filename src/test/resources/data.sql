insert into setor (id, ativo,codigo,email,lotacao,nome) values (1, true, 'INFORMATICA', 'x1@email.com', '01', 'Informática');
insert into setor (id, ativo,codigo,email,lotacao,nome) values (2, true, 'TRANSPORTE', 'x2@email.com', '02', 'Transporte');
insert into setor (id, ativo,codigo,email,lotacao,nome) values (3, true, 'PATRIMONIO', 'x3@email.com', '02', 'Patrimônio');

insert into status (codigo,nome) values ('CONCLUIDO', 'Concluído');
insert into status (codigo,nome) values ('PENDENTE_CLIENTE', 'Pendente cliente');
insert into status (codigo,nome) values ('EM_EXECUCAO', 'Em execução');

insert into usuario(login,nome,email) values ('login01', 'Nome 01', 'email01@email.com');
insert into usuario(login,nome,email) values ('login02', 'Nome 02', 'email02@email.com');
insert into usuario(login,nome,email) values ('login03', 'Nome 03', 'email03@email.com');


insert into veiculo(placa,modelo,capacidade,lotacao,ativo,quilometragem) values ('ABC-0101', 'Fiat 147', 10, '01', true, 1000);
insert into veiculo(placa,modelo,capacidade,lotacao,ativo,quilometragem) values ('XYZ-9999', 'Variant', 20, '01', true, 2000);
insert into veiculo(placa,modelo,capacidade,lotacao,ativo,quilometragem) values ('IJK-0011', 'Fusca 69', 15, '01', true, 3000);