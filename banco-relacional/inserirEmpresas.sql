alter table empresas modify cnpj varchar(14);

insert into empresas
	(nome, cnpj)
values
	('Bradesco', 96548985552380),
    ('Vale', 45726775008786),
    ('Cielo', 00298362767673);
    
desc empresas;
desc prefeitos;

select * from empresas;
select * from cidades;

insert into empresas_unidades
	(empresa_id, cidade_id, sede)
values
	(1, 1, 1),
    (1, 2, 0),
    (2, 1, 0),
    (2, 2, 1);