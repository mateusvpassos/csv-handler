CREATE TABLE user (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(200) NOT NULL,
    birth_date timestamp NOT NULL,
    email varchar(100) NOT NULL,
    phone varchar(20) NOT NULL,
    address varchar(200) NOT NULL,
    city varchar(100) NOT NULL,
    state varchar(100) NOT NULL,
    zip varchar(10),
    country varchar(100) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY UK_userid (id),
    UNIQUE KEY UK_useremail (email)
);