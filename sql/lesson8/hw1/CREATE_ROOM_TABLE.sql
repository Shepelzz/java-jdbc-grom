--DROP TABLE FP_ROOM;
CREATE TABLE FP_ROOM(
  ID NUMBER,
  CONSTRAINT FP_ROOM_PK PRIMARY KEY(ID),
  NUMBER_OF_GUESTS NUMBER NOT NULL,
  PRICE FLOAT CHECK(PRICE >= 0),
  BREAKFAST_INCLUDED NUMBER(1,0) DEFAULT 0,
  PETS_ALLOWED NUMBER(1,0) DEFAULT 0,
  DATE_AVAILABLE_FROM TIMESTAMP NOT NULL,
  HOTEL_ID NUMBER,
  CONSTRAINT FP_HOTEL_FK FOREIGN KEY(HOTEL_ID) REFERENCES FP_HOTEL(ID)
);

--DROP SEQUENCE FP_ROOM_PK_SEQ;
CREATE SEQUENCE FP_ROOM_PK_SEQ START WITH 1 INCREMENT BY 1;