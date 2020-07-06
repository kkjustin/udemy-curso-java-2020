select * from prefeitos;
select * from cidades;

-- Interseção das tabelas
select * from cidades c 
	inner join prefeitos p on (c.id = p.cidade_id);

-- Diferença (outter) busca a interseção + as cidades sem prefeito associado
select * from cidades c
	left join prefeitos p on (c.id = p.cidade_id);
    
-- Diferença (outter) busca a interseção +  os prefeitos sem cidade associada
select * from cidades c
	right join prefeitos p on (c.id = p.cidade_id);
    
-- FULL JOIN (MySql não tem) UNION ALL traz as duplicações
select * from cidades c
	left join prefeitos p on (c.id = p.cidade_id)
union
select * from cidades c
	right join prefeitos p on (c.id = p.cidade_id);