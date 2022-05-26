create table if not exists persistent_logins
(
    username  varchar(64) not null,
    series    varchar(64) not null,
    token     varchar(64) not null,
    last_used timestamp   not null
    );

insert into test(max_score, name) values (5,'Чебурашка');
insert into test(max_score, name) VALUES (5,'Входной');