CREATE TABLE persons
(
    city         VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    name         VARCHAR(255) NOT NULL,
    surname      VARCHAR(255) NOT NULL,
    age          INTEGER      NOT NULL,
    CONSTRAINT pk_persons PRIMARY KEY (name, surname, age)
);
