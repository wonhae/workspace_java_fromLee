create table test1(
id number(3), 
name varchar2(21)
)
update test1 set id = 4 , name = 'Chae' where name = 'choi'
update test1 set name = 'anh' where id = 5
--update test1 set name = 'min' where name = null ////


--어떤 컬럼에 대해 입력하는지
insert into test1(id, name) values (1,'kim')
insert into test1(id, name) values(2, 'lee')
insert into test1(name, id) values('park', 3)
insert into test1(name) values('choi')
insert into test1(id) values(5)
insert into test1 values(6, 'shin')
insert into test1 values(7, 'na')

commit

select * from test1