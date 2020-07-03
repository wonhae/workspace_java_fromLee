c: insert
r: select 
u: update
d: delete

특정 조건을 만족하는 레코드 조회하기 

where 절:  ~인지...  (조건절이라고 생각하시면 됨)

select * from member

select * from member where id = 'm001'
select * from member where name = 'g'
select * from member where age = 9

비교 연산자 : 19세 이하의 유권자 조회 = 18세 이하가 아닌 국민을 조회하세요 
--  x  select * from member where age >= 19select * from member where age !<=18

언더바 _ : 모르는 글자 한글자  , % : 모르는 글자인데 글자 수도 몰라 , like 
select * from member where name like '서울34차12__'
select * from member where id like 'm00_'
select * from member where name like '%34차%'
select * from member where id like '%m%9%'
select * from member where id like '%7%'


create table test5(
id varchar2(6), 
name varchar2(18) 
)

insert into test5 (id, name) values ('t001' , 'john')
insert into test5 (id, name) values ('t002' , 'sam')
insert into test5 (id) values ('t003')
insert into test5 (name) values ('tom')
commit
select * from test5
입력 안한것은 null 나온다 

id 정보가 없는 사람을 조회하려고 함 
select * from test5 where id is null
select * from test5 where id is not null

name 정보가 있는 사람을 조회하려고 함 => name 정보가 없는 사람이 아닌 사람을 조회하시오 
select * from test5 where name is not null
