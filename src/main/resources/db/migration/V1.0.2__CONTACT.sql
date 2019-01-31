CREATE TABLE IF NOT EXISTS TrackingSystem.CONTACT 
(CONTACTID integer AUTO_INCREMENT,
ACCOUNTID integer ,
LASTNAME CHAR(50) ,
FIRSTNAME CHAR(50),
PHONE char(40) ,
EMAIL CHAR(100) ,
CREATED_BY varchar(200) DEFAULT 'SYS_ADMIN',
UPDATED_BY varchar (200) DEFAULT 'SYS_ADMIN',
CREATED_AT timestamp NOT NULL DEFAULT NOW(),
UPDATED_AT timestamp  NOT NULL DEFAULT NOW(),
PRIMARY KEY (CONTACTID ),
FOREIGN KEY (ACCOUNTID)
REFERENCES ACCOUNT (ACCOUNTID));