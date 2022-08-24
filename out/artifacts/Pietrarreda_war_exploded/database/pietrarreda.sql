drop database if exists  pietrarreda ;
create database pietrarreda;
use pietrarreda;

create table Utente(
                Id_user int not null auto_increment,
                Nome varchar (20) not null,
                Cognome varchar(20) not null,
                username varchar(20) not null,
                passwordhash varchar(20) not null,
                email varchar(20) not null,
                 admin boolean default false,

                primary key(id_user)
                            );
                            insert into utente values(default,'valerio','scarinzi','valerx',"valerio","valerio@email");
                             insert into utente values(default,'francesco','di domenico','spaghettino',"franscesco","francesco@email");
                              insert into utente values(default,'mario','guida','mario98',"mario","mario@email");
                               insert into utente values(default,'andrea','landolfi','andre98',"andrea","andrea@email");
                           
                
  create table Categoria(
                         Id_categoria int not null auto_increment,
                         categoria_name varchar(25) not null,
                         cat_description varchar(200) not null,
                         img_categoria varchar(25) not null,
                         
                         primary key(Id_categoria)
                        );   
                        
create table Prodotto(

			id_prodotto int not null auto_increment,
            nome_prod varchar(25) not null,
            descrizione_prod varchar(200)not null,
            costo_prodotto double not null,
            quantita_prod int not null,
            disponibilita_prod int not null,
            primary key(id_prodotto)
);



                        
				

