DROP TABLE wine_test_db.USER; 
DROP TABLE wine_test_db.STAND; 
DROP TABLE wine_test_db.WINE; 


CREATE TABLE USER (
    ID int NOT NULL AUTO_INCREMENT,
    USERNAME varchar(255),
    PW varchar(255),
    PRIMARY KEY (ID)
);

INSERT INTO USER (USERNAME, PW)
VALUES ("Satan", "666"), ("nrbn", "666"), ("a", "a"), ("asd", "123"), ("nrbn", "36"), ("123", "123");

CREATE TABLE STAND (
    ID int NOT NULL AUTO_INCREMENT,
    standName varchar(255),    
	standLocation varchar(255),
	standOwner varchar(255),
    
    PRIMARY KEY (ID)
);

INSERT INTO STAND(standName, standLocation, standOwner)
VALUES ("Gudulas Weine", 1, "Gudula"), ("Max Weine", 2 ,"Max");

CREATE TABLE WINE (
    ID int NOT NULL AUTO_INCREMENT,
    wineName varchar(255),    
	wineDescription varchar(255),
	standID int,
    PRIMARY KEY (ID),
    FOREIGN KEY (standID) REFERENCES STAND(ID)
);

INSERT INTO WINE(wineName, wineDescription, standID)
VALUES ("Rot Wein", "",2), ("Weis Wein", "" ,1);

CREATE TABLE WINEEVALUATION (
    ID int NOT NULL AUTO_INCREMENT,
    sweet int,
    salty int,
    bitter int,
    sour int,
    wineID int,
    userID int,
    PRIMARY KEY (ID),
    FOREIGN KEY (wineID) REFERENCES WINE(ID),
    FOREIGN KEY (userID) REFERENCES USER(ID)
);

CREATE TABLE STANDEVALUATION (
    ID int NOT NULL AUTO_INCREMENT,
    standID int,
    userID int,
    review varchar(255),
    PRIMARY KEY (ID),
    FOREIGN KEY (standID) REFERENCES STAND(ID),
    FOREIGN KEY (userID) REFERENCES USER(ID)
);
