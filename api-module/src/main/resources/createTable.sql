CREATE TABLE PANEL (
                       PANEL_ID VARCHAR(255) NOT NULL PRIMARY KEY,
                       EQUIP_TYPE VARCHAR(255) NOT NULL,
                       OPERATOR VARCHAR(255) ,
                       CREATE_DATE_TIME DATE NOT NULL,
                       UPDATE_DATE_TIME DATE ,
                       SCAN_INDEX INT
);

insert into PANEL values ('panel1','equip1','홍길동',sysdate-1,sysdate,1);