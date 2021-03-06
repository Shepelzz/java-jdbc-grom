CREATE TABLE FP_USER(
  ID NUMBER,
    CONSTRAINT FP_USER_PK PRIMARY KEY(ID),
  USER_NAME NVARCHAR2(100) NOT NULL,
  PASSWORD NVARCHAR2(50) NOT NULL,
  COUNTRY NVARCHAR2(50),
  USER_TYPE NVARCHAR2(20)
);

CREATE SEQUENCE FP_USER_PK_SEQ START WITH 1 INCREMENT BY 1;
