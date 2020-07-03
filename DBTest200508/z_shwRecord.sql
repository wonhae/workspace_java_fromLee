create table shin (
month number(2), 
do varchar2(10)
)
alter table shin add actno varchar2(21)

alter table shin add constraint pk_shin_actno primary key(actno)

commit
select * from shin

insert into shin (month, do, actno) values (6, '정처리', 'a1')
insert into shin (month, do, actno) values (5, '여행', 'a2')



create table ys (
dan varchar2(10), 
eat varchar2(10), 
rooms varchar2(10)
)
alter table ys add do char(10)
alter table ys add constraint fk_ys_do foreign key(do) references shin(do)
alter table ys modify eat varchar2(30)

select * from ys

--alter ys ys drop column rooms

insert into ys (dan, eat, rooms) values ('여천', '간장게장', '유캐슬')
insert into ys (dan, eat, rooms) values ('포차', '문어삼합', '안탑마')
insert into ys (dan, eat, rooms) values ('휴게소', '호두과자','차')

--======================

create table classd(
id char(21), 
name  char(21), 
age  number(3)
)
alter table classd add constraint pk_classd_id primary key (id)
select * from classd

create table acting(
name varchar2(21), 
doo varchar2(21)
)
alter table acting modify doo char(21)
alter table acting add constraint fk_acting_doo foreign key (doo) references classd(id)
select * from acting

insert into classd values('a1', '김댕댕', 23)
insert into classd values('a1', '김동댕', 25)
insert into acting values ('신혜원', a1)

delete from 학생 where 학번 = 24036  

-------------------------------
create table hw1(
id varcahr2(6), 
name varchar3(21), 
age number(2) check (age<95)
)
