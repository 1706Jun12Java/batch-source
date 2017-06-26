CREATE TABLE account_type
(
    ID INTEGER PRIMARY KEY,
    name VARCHAR2(255) NOT NULL
);

INSERT INTO account_type VALUES (1, 'Checking');
INSERT INTO account_type VALUES (2, 'Savings');

CREATE TABLE users
(
    ID INTEGER PRIMARY KEY,
    first_name VARCHAR2(255),
    last_name VARCHAR2(255),
    username VARCHAR2(255) NOT NULL,
    password VARCHAR2(255) NOT NULL
);
CREATE UNIQUE INDEX "users_username_uindex" ON users (username);

CREATE TABLE account
(
    ID INTEGER PRIMARY KEY,
    balance INTEGER DEFAULT 0,
    user_id INTEGER,
    account_type_id INTEGER
);

ALTER TABLE account ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (ID)
ON DELETE CASCADE;
ALTER TABLE account ADD CONSTRAINT fk_account_type_id FOREIGN KEY (account_type_id) REFERENCES account_type (ID)
ON DELETE CASCADE;

CREATE SEQUENCE SQ_user_id START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_insert_user_id BEFORE INSERT ON users
    FOR EACH ROW
    BEGIN
        SELECT SQ_user_id.nextval INTO :NEW.ID FROM dual;
    END;

CREATE SEQUENCE SQ_account_id START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_insert_account_id BEFORE INSERT ON account
    FOR EACH ROW
    BEGIN
        SELECT SQ_account_id.nextval INTO :NEW.ID FROM dual;
    END;