delete from dragons;
delete from caves;
delete from users;

alter table dragons alter column id restart with 1;
alter table caves alter column id restart with 1;
alter table users alter column id restart with 1;

insert into users(login, user_group, password) values ('admin', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');
insert into users(login, user_group, password) values ('user1', 'user', '0a041b9462caa4a31bac3567e0b6e6fd9100787db2ab433d96f6d178cabfce90');
insert into users(login, user_group, password) values ('user2', 'user', '0a041b9462caa4a31bac3567e0b6e6fd9100787db2ab433d96f6d178cabfce90');
insert into users(login, user_group, password) values ('user3', 'user', '0a041b9462caa4a31bac3567e0b6e6fd9100787db2ab433d96f6d178cabfce90');
insert into users(login, user_group, password) values ('user4', '', '0a041b9462caa4a31bac3567e0b6e6fd9100787db2ab433d96f6d178cabfce90');

insert into caves (surface,owner) values (30,1);
insert into caves (surface,owner) values (60,1);
insert into caves (surface,owner) values (3,2);
insert into caves (surface,owner) values (40,2);
insert into caves (surface,owner) values (22,2);
insert into caves (surface,owner) values (4,3);

insert into dragons (name, gold, color, CAVE_ID) values ('Cyrano', 1000, 'GREEN', 1);
insert into dragons (name, gold, color, CAVE_ID) values ('Beau', 100, 'RED', 2);
insert into dragons (name, gold, color, CAVE_ID) values ('Fracshun', 500 , 'BLACK', 2);
insert into dragons (name, gold, color, CAVE_ID) values ('Cyprian', 1000 , 'GOLD', 3);
insert into dragons (name, gold, color, CAVE_ID) values ('Paweł', 3000, 'GREEN', 1);
insert into dragons (name, gold, color, CAVE_ID) values ('Gaweł', 200, 'RED', 2);
insert into dragons (name, gold, color, CAVE_ID) values ('Marek', 530 , 'BLACK', 3);
insert into dragons (name, gold, color, CAVE_ID) values ('Marcin', 10000 , 'GOLD', 4);
