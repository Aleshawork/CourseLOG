delete from users where id in (1,2);
delete from authority where id in(1,2,3);
delete from course where id in(1,2);


insert into users (id,name,surname,username,password )
  values(1,'Alexey','Borisov','ALEXEY','$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG'),
    (2,'Egor','Mironov','EGOR','$2a$10$r2o0BIhT/UEmRObriaJjE.JeQQse.SbUBX3BoymNCP8./.skrw6iS');

insert into authority (id,name,user_id) values(1,'ROLE_USER',1), (2,'ROLE_USER',2), (3,'ROLE_ADMIN',1);

insert into course (id,author,name) values(1,'Anton R.E','Spring in action'),
                                           (2,'Pospelov T.E','SQL');