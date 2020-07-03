--CRUD 중 CUD작업
--기본키 왜 필요한지

--1. 이렇게 하면 관리안됨 
create table test2(
id number(3) primary key, 
name varchar2(9)
)

--2. 추천 
create table test3(
id number(3), 
name varchar2(21), 
constraint pk_test3_id primary key(id)
)

--3. alter table 이용해 만드는법 
create table test4(
id number(3), 
name varchar2(21)
) 
alter table test4 add constraint pk_test4_id primary key(id)

drop table test2
drop table test3
drop table test4


insert into test2 (id, name) values (1, 'kim')
insert into test2 (name, id) values ('lee', 2)
insert into test2 (id) values (3)
--insert into test2 (name) values ('shin')  //notnull 제약조건 위반
--insert into test value (3, 'kang')  //중복된 id 

commit
select * from test2




-- --외래키 생성------------------
create table depart(
did number(3), 
dname varchar2(20) not null  
)
alter table depart add constraint pk_depart_did primary key(did)

insert into depart (did, dname) values (1, '영문학과')
insert into depart (did, dname) values (2, '국문학과')
insert into depart values (3, '서문학과')
insert into depart values (4, '불문학과')

commit
select * from depart

--student table 생성 및 외래키 지정
--1. 
create table student1(
sid varchar2(3) primary key, 
did number(3) references depart(did), 
sname varchar2(12) not null
)
--2.
create table student2(
sid varchar2(3), 
did number(3), 
sname varchar2(12) not null, 
constraint pk_student2_sid primary key(sid), 
constraint fk_student2_did foreign key(did) references depart(did)
)

--3.
create table student3(
sid varchar2(3), 
did number(3), 
sname varchar2(12) not null
)
alter table student3 add constraint pk_student3_sid primary key(sid)
alter table student3 add constraint fk_student3_sid foreign key(did) references depart(did)

commit
select * from student3

drop table student1
drop table student2
drop table student3

create table student1(
sid varchar2(3) primary key,
did number(5) references depart(did), 
sname varchar2(12) not null
)

create table student2(
sid varchar2(3), 
did number(5),
sname varchar2(12), 
constraint pk_student2_sid primary key(sid), 
constraint fk_student2_did foreign key(did) references depart(did)
)

create table student3(
sid varchar2(3), 
did number(5), 
sname varchar2(12)
)
alter table student3 add constraint pk_student3_sid primary key(sid)
alter table student3 add constraint fk_student3_did foreign key(did) references depart(did)

insert into student3(sid, did, sname)
values
('s01', 1, 'a')

insert into student3(sid, did, sname)
values
('s02', 1, 'b')
-- did에 1 가능! 외래키이므로! 외래키는 중복가능 

--insert into student3(sid, did, sname)
--values
--('s03', 100, 'c')

insert into student3
values
('s04', null, 'a')

insert into student3 values ('s05', 1, 'k')

insert into student3 values ('s06', 1, 'f')

insert into student3 values ('s07', 1, 'z')

delete from student3 where sid = 's07'
delete from student3 where sid = 's06'
delete from student3 where sname = 'k'

delete from depart where did = 3
--delete from depart where did = 1  // student3에 1값을 사용하고 있어서 삭제불가 ->student3 의 did 를 바꿔주거나, null 값을 넣어주기

--quiz. student3 테이블에 있는 레코드 중에서 did 가 1인 것들을 찾아서 did 값을 2로 변경후,  depart 테이블에서 didㄱ 밧이 1인 레코드 값을 삭제하시오
update student3 set did = 2 where did = 1
delete from depart where did = 1

select sid, did from student3




