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
                            insert into utente values(default,'valerio','scarinzi','valerx',"valerio","valerio@email",true);
                             insert into utente values(default,'francesco','di domenico','spaghettino',"francesco","francesco@email",true);
                              insert into utente values(default,'mario','guida','mario98',"mario","mario@email",false);
                               insert into utente values(default,'andrea','landolfi','andrea',"andrea","andrea@email",false);
                            insert into utente values(default,'1','1','1',"1","1@email",false);

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
            nome_prod varchar(255) not null,
            descrizione_prod varchar(255)not null,
            costo_prodotto double not null,
			disponibilita_prod int not null,
            imgPath_prod varchar (200) not null,
            primary key(id_prodotto)
);

            insert into prodotto values(default,'Travertino Anticato','Tevartino opera incerta  ',18,200,'travertinoOpus.jpg');
            insert into prodotto values(default,'Travertino Squadrato','Travertino Squadrato 20cm a correre',35,200,'porfidoOpus.jpeg');
            insert into prodotto values(default,'Pietra Di Trani Bocciardato Anticato','Pietra Di Trani opera incerta, lavorazioni Bocciardato e Anticato',16,200,'PietraDiTraniAnticata.png');
            insert into prodotto values(default,'Pietra Di Trani Squadrato','Pietra Di Trani Anticata e Tranciata 20cm a correre',35,200,'PietraDiTraniAnticataTranciata.png');
			insert into prodotto values(default,'Travertino tozzetti','Travertino tozzetti 10x10 ',30,200,'porfidoOpus.jpeg');
			insert into prodotto values(default,'Pietra Alpina ','Pietra Alpina opera incerta ',16,200,'porfidoOpus.jpeg');
            insert into prodotto values(default,'Pietra Alpina Anticato','Pietra Alpina OpusIncertum',20,10,'pietraAlpinaOpus.png');
			insert into prodotto values(default,'Porfido','Porfido opera incerta ',16,200,'porfidoOpus.jpeg');
			insert into prodotto values(default,'Porfido squadrato','Porfido squadrato ',16,200,'PorfidoSquadrato.JPG');
			insert into prodotto values(default,'Porfido cubetti','Porfido Cubetti ',16,200,'PorfidoCubetti.jpg');
			insert into prodotto values(default,'Ciottoli di fiume','Ciottoli di fiume ',20,200,'CiottoliFiume.jpg');
			insert into prodotto values(default,'Ciottoli di Carrara','Ciottoli di Carrara ',22,200,'CiottoliCarrara.jpg');
			insert into prodotto values(default,'Ciottoli Sant Ambrogio','Ciottoli  rossi  ',24,200,'CiottoliRossi.jpg');
            insert into prodotto values(default,'Ciottoli verdello','Ciottoli di verdello ',24,200,'ciottoliVerdi.jpg');
			insert into prodotto values(default,'Scultura in roccia','Porfido opera incerta ',2000,1,'SculturaRoccia.png');



create table Carrello(
                              Id_sc int not null,
                              Id_usr int not null,
                              Id_prd int not null ,
                              Total_price double not null,
                              qty_product int not null,
                              primary key(Id_sc,Id_prd,Id_usr),
                              foreign key(Id_usr) references Utente(Id_user),
                              foreign key (Id_prd) references Prodotto(id_prodotto)
                              );



create table Ordine(
				Id_ordine int not null auto_increment,
                Id_usr int not null,
                data_ordine varchar(50) not null,
                name_ordine varchar(500) not null,
                stato_ordine varchar(500) not null,
                indirizzo_sped varchar(500) not null,
                tot_price double not null,

                primary key(Id_ordine)
                );

         create table OrderProd (
                           Id_ordine int not null,
                           Id_prod int not null,
                           qty_ord_prod int not null,
                           primary key(Id_ordine,Id_prod),
                           foreign key(Id_ordine) references Ordine(Id_ordine),
                           foreign key(Id_prod) references Prodotto(id_prodotto)
);


create table ProdottoCategoria(
            id_prod int not null,
			id_cat int not null,
			primary key(id_prod,id_cat),
			foreign key(id_prod) references Prodotto(id_prodotto),
			foreign key(id_cat) references Categoria(id_categoria)
                    );

                    insert into ProdottoCategoria values("1","1");
					insert into ProdottoCategoria values("3","1");

					insert into ProdottoCategoria values("7","1");

					insert into ProdottoCategoria values("2","2");
                     insert into ProdottoCategoria values("4","2");
					insert into ProdottoCategoria values("9","2");

                    insert into ProdottoCategoria values("10","3");
                    insert into ProdottoCategoria values("11","3");
                    insert into ProdottoCategoria values("12","3");
                    insert into ProdottoCategoria values("13","3");
					insert into ProdottoCategoria values("14","3");
					insert into ProdottoCategoria values("15","3");

