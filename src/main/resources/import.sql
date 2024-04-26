insert into tamanho (largura,comprimento,profundidade) values(1,2,3);
insert into tamanho (largura,comprimento,profundidade) values(10,20,30);

insert into telefone (codigoArea, numero) values ('63','888888888');
insert into telefone (codigoArea, numero) values ('61','333333333');
insert into telefone (codigoArea, numero) values ('62','222222222');
insert into telefone (codigoArea, numero) values ('11','111111111');
insert into telefone (codigoArea, numero) values ('22','442223344');
insert into telefone (codigoArea, numero) values ('11','333333333');
insert into telefone (codigoArea, numero) values ('22','555555555');
insert into telefone (codigoArea, numero) values ('63','848484848');

insert into endereco (cep, rua, numero) values (11111111,'Rua 1',12);
insert into endereco (cep, rua, numero) values (10101010,'Rua 10',2);
insert into endereco (cep, rua, numero) values (55555555,'Rua 5',14);
insert into endereco (cep, rua, numero) values (88888888,'Rua Paulista',8);
insert into endereco (cep, rua, numero) values (25252525,'Rua Cariora',3);
insert into endereco (cep, rua, numero) values (44445555,'Rua José',34);
insert into endereco (cep, rua, numero) values (66666777,'Rua Gisele',31);
insert into endereco (cep, rua, numero) values (77777888,'Rua Marcela',20);


insert into funcionario (nome,cargo,id_endereco,id_telefone,email) values ('João','Vendedor',1,1,'joao@gmail.com');

insert into cliente (nome,id_endereco,id_telefone,email) values ('Giovanna',2,2,'giovanna@gmail.com');
insert into cliente (nome,id_endereco,id_telefone,email) values ('Lucas',4,4,'lucas@gmail.com');

insert into fornecedor (nome,id_endereco,id_telefone,email) values ('José',6,6,'jose@gmail.com');
insert into fornecedor (nome,id_endereco,id_telefone,email) values ('Gisele',7,7,'gisele@gmail.com');

insert into caneca (nome,descricao,preco,id_tamanho,capacidade,material,id_fornecedor) values ('Caneca coração','Alça de coração',40.50,1,320,1,1);
insert into caneca (nome,descricao,preco,id_tamanho,capacidade,material,id_fornecedor) values ('Caneca Preta','Tarja branca',50.50,2,360,2,1);