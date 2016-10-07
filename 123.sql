insert into users (id,name,surname) values (1, 'Вова','Макаренко');
insert into users (id,name,surname) values (2, 'Настя','Куриленко');
insert into users (id,name,surname) values (3, 'Вова','Ролик');

update users set name = 'Настенька' where id = 2;

select * from users;
select * from users where name = 'Вова';
select * from users where surname like '%ко';

select name from users;

select count(*) from users;

insert into users (id,name,surname) values (3, 'Чертила', 'Непонятный');
insert into users (id) values (4);
insert into users (id,name,surname) values (5, 'Чертила', 'Непонятный');

delete from users where id = 5;


insert into messages (id,from_id, to_id, message, date) values (1, 1,2,'Привет', now());


select * from messages left join users AS from_users on messages.from_id = from_users.id left join users AS to_users on messages.to_id = to_users.id;


select messages.id, (from_users.name from_users.surname), to_users.name, message from messages left join users AS from_users on messages.from_id = from_users.id left join users AS to_users on messages.to_id = to_users.id;