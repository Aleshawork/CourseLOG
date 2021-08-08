create table if not exists users(
    id  serial primary key ,
    name varchar(30),
    surname varchar(30),
    username varchar(30),
    password varchar(68)
);

create table if not exists  authority(
    id serial primary key,
    name varchar(30),
    user_id int not null
);

create table if not exists course(
    id serial primary key,
    author varchar(30),
    name varchar(30)
);
