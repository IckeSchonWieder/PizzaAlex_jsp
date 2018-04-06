drop database if exists PizzaAW;
create database PizzaAW;

USE PizzaAW;


Drop table if exists Kunde;
CREATE TABLE Kunde
	(KdNr INTEGER primary key Auto_Increment,
	Name VARCHAR(100),
	Vorname VARCHAR(100),
	Strasse VARCHAR(100),
	Plz VARCHAR(100),
	Ort VARCHAR(100));


insert into Kunde (Name, Vorname, Strasse, Plz, Ort) values 
	('Steinmeiser', 'Franz-Walther', 'AStrasse 12', '01245', 'ADorf'),
	('Gabrielis', 'Sigmund', 'BStrasse 54', '45455' , 'Goslar'),
	('Schräder', 'Gerhardt', 'CStrasse 144', '77253', 'Mossenberg-Wöhren'),
	('Schultz', 'Martha', 'DStrasse 1A', '53997', 'Eschweiler'),
	('von der Leithen', 'Ursel', 'EStrasse 19', '78315', 'Elsene');




Drop table if exists Pizza;
CREATE TABLE Pizza
	(PiNr INTEGER primary key Auto_Increment,
	Name VARCHAR(100),
	Preis DOUBLE(5,2));


insert into Pizza (Name, Preis) values 
	('Margharita', 4.99),
	('Salame', 5.99),
	('Funghi', 5.99),
	('Hawaii', 6.49),
	('Speciale', 6.49),
	('Quattre Stagione', 6.79),
	('ConTutti de Alex', 7.79);



Drop table if exists Bestellung;
CREATE TABLE Bestellung
	(BeNr INTEGER primary key Auto_Increment,
	KdNr INTEGER,
	IPAddr VARCHAR(100),
	SessID VARCHAR(100),
	Preis DOUBLE(5,2));



insert into Bestellung (KdNr, IPAddr, SessID, Preis) values 
	(1, '192.168.0.1', 'TestID', 15.99);
	


