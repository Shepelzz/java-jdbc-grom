CREATE TABLE FP_USER_TYPE (
    ID NUMBER,
        CONSTRAINT FP_USER_TYPE_PK PRIMARY KEY(ID),
    NAME NVARCHAR2(50) NOT NULL UNIQUE
);


CREATE SEQUENCE FP_USER_TYPE_PK_SEQ START WITH 1 INCREMENT BY 1;