CREATE TABLE IF NOT EXISTS TrackingSystem.SERVICEREQUEST 
(SRNUMBER char(64) ,
TITLE VARCHAR(512) ,
ACCOUNTID integer NOT NULL,
CONTACTID integer NOT NULL,
STATUS char(20) ,
OPENDATE timestamp DEFAULT CURRENT_TIMESTAMP,
CLOSEDATE timestamp DEFAULT CURRENT_TIMESTAMP,
DESCRIPTION varchar(512),
CREATED_BY varchar(200) DEFAULT 'SYS_ADMIN', 
UPDATED_BY varchar (200) DEFAULT 'SYS_ADMIN', 
CREATED_AT timestamp NOT NULL DEFAULT NOW(),
UPDATED_AT timestamp  NOT NULL DEFAULT NOW(),
PRIMARY KEY (SRNUMBER),
INDEX date (OPENDATE ,CLOSEDATE));
