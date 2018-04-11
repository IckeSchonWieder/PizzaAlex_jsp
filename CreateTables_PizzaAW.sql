drop database if exists Pizzadb;
create database Pizzadb;

USE Pizzadb;


Drop table if exists Kunde;
CREATE TABLE Kunde
	(KdNr INTEGER primary key Auto_Increment,
	UsNr INTEGER,
	Name VARCHAR(100),
	Vorname VARCHAR(100),
	Strasse VARCHAR(100),
	Plz VARCHAR(100),
	Ort VARCHAR(100));


insert into Kunde (UsNr, Name, Vorname, Strasse, Plz, Ort) values 
	(1,'Steinmeiser', 'Franz-Walther', 'AStrasse 12', '01245', 'ADorf'),
	(2,'Gabrielis', 'Sigmund', 'BStrasse 54', '45455' , 'Goslar'),
	(3,'Schräder', 'Gerhardt', 'CStrasse 144', '77253', 'Mossenberg-Wöhren'),
	(4,'Schultz', 'Martha', 'DStrasse 1A', '53997', 'Eschweiler'),
	(5,'von der Leithen', 'Ursel', 'EStrasse 19', '78315', 'Elsene');




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
	




Drop table if exists Position;
CREATE TABLE Position
	(PoNr INTEGER primary key Auto_Increment,
	BeNr INTEGER,
	PiNr Integer,
	Anzahl Integer);



insert into Position (BeNr, PiNr, Anzahl) values 
	(1, 3, 2),
	(1, 4, 1),
	(1, 1, 4);
