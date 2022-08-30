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
                       admin bool not null,
                       primary key(id_user)
);
insert into utente values(default,'valerio','scarinzi','valerx','valerio',"valerio@email",true);
insert into utente values(default,'francesco','di domenico','spaghettino',"francesco","francesco@email",true);
insert into utente values(default,'mario','guida','mario98',"mario","mario@email",false);
insert into utente values(default,'andrea','landolfi','andre98',"andrea","andrea@email",false);


create table Categoria(
                          Id_categoria int not null auto_increment,
                          nome_cat varchar(25) not null,
                          descrizione_cat varchar(254) not null,
                          img_categoria varchar(25) not null,
                          primary key(Id_categoria)
);
insert into categoria values(default,'Opus incertum','L opera incerta (opus incertum) è una tecnica edilizia romana che riguarda il modo in cui viene realizzato il paramento di un muro in opera cementizia.','');
insert into categoria values(default,'Squadrato','Materiale ricavato dalla lavorazione di pietre grezze e irregolari,attraverso lavori di macchinari appositi.','');
insert into categoria values(default,'Cubetti e ciottoli','Materiali ricavati dalla lavorazione di pietre grezze per creare mosaici e decorazioni giardini e aiuole','');



create table Prodotto(



                         id_prodotto int not null auto_increment,
                         nome_prod varchar(25) not null,
                         descrizione_prod varchar(200)not null,
                         costo_prodotto double not null,
                         quantita_prod int not null,
                         disponibilita_prod int not null,
                         primary key(id_prodotto)
);
insert into prodotto values(default,'mattonella marmo','mattonella in marmo dim 50x50',40,20,20);
insert into prodotto values(default,'colonna marmo','colonna in marmo dim 2Mx0.80M',150,10,10);

create table CategoriaProdotto(
                                  id_prod int not null,
                                  id_cat int not null,
                                  primary key(id_prod,id_cat),
                                  foreign key(id_prod) references Prodotto(id_prodotto),
                                  foreign key(id_cat) references Categoria(id_categoria)
);