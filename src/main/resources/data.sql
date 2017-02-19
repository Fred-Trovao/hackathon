insert into authority (name) values ('admin');
insert into authority (name) values ('user');

INSERT INTO endereco(cidade, estado) VALUES ('João Pessoa', 'PB');
INSERT INTO endereco(cidade, estado) VALUES ('Campina Grande', 'PB');
INSERT INTO endereco(cidade, estado) VALUES ('Patos', 'PB');

INSERT INTO usuario(ativado, cpf, endereco_id, login, nome, senha, 
            telefone)
    VALUES (true, '00875976409', 2, 'fredmfarias@gmail.com', 'Fred Farias', 'fred', '83988269825');

    INSERT INTO usuario(ativado, cpf, endereco_id, login, nome, senha, 
            telefone)
  	VALUES (true, '70233186409', 1, 'jcmacedo@gmail.com', 'José Carlos', 'jose', '83996568756');

INSERT INTO usuario(ativado, cpf, endereco_id, login, nome, senha, 
            telefone)
    VALUES (true, '17478460232', 3, 'lucasfigueiredo@gmail.com', 'Lucas Figuereido', 'lucas', '83991342526');

insert into users_authority (id_user, id_authority) values (1, 1);
insert into users_authority (id_user, id_authority) values (2, 1);
insert into users_authority (id_user, id_authority) values (3, 1);
	