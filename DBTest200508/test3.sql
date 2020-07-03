--CRUD 중 R 작업

--체크 제약조건  (외래키와 차이: 다른테이블에 들어있는 값들중에서 선택하거나 null값 넣는것) 
create table member(
id varchar2(6), 
name varchar2(21) not null,
age number(3) check(age<200)
)

insert into member (id, name, age) values ('m001', 'a', 150)
insert into member (id, name, age) values ('m002', 'b', 170)
insert into member (id, name, age) values ('m003', 'c', 130)
insert into member (id, name, age) values ('m004', 'd', 100)
insert into member (id, name, age) values ('m005', 'e', 99)
insert into member (id, name, age) values ('m006', 'f', 95)
insert into member (id, name, age) values ('m007', 'g', 90)
insert into member (id, name, age) values ('m008', 'h', 17)
insert into member (id, name, age) values ('m009', 'i', 70)
insert into member (id, name, age) values ('m0010', 'j', 31)
insert into member (id, name, age) values ('m0011', 'k', 1)
insert into member (id, name, age) values ('m0012', 'l', 11)
insert into member (id, name, age) values ('m0013', 'm', 12)
insert into member (id, name, age) values ('m0014', 'n', 13)
insert into member (id, name, age) values ('m0015', 'o', 77)
insert into member (id, name, age) values ('m0016', 'p', 64)
insert into member (id, name, age) values ('m0017', 'q', 59)
insert into member (id, name, age) values ('m0018', 'r', 88)
insert into member (id, name, age) values ('m0019', 's', 22)
insert into member (id, name, age) values ('m0020', 't', 10)
insert into member (id, name, age) values ('m0021', 'u', 69)
insert into member (id, name, age) values ('m0022', 'v', 37)
insert into member (id, name, age) values ('m0023', 'w', 9)
insert into member (id, name, age) values ('m0024', 'x', 46)
insert into member (id, name, age) values ('m0025', 'y', 23)
insert into member (id, name, age) values ('m0026', 'z', 91)

commit
select * from member
select id from member

--quiz member 테이블에 있는 모든 레코드를 조회하는데, id와 name 컬럼 데이터만 가져오시오
select id, name from member
--quiz 모든 컬럼값 다 가져오는데, age 에 +1을 해서 가져오떼여(마트 할인율 비유해주심)
select id, name, age+1 from member
--id+name 더해서 나오게
select id, name, id||name from member
--
select id, name, id||':'||name from member

--name 대신 별명(이름)으로 ->as 이용 (as 생략 가능. as 쓰면 가독성이 좋다. ) / 나중에 별칭이 중요하다. 
select id, name as 이름 , age+1 as 한국나이, id||name 비밀번호 from member


--중복없이 아이디값 가져온다. 
select distinct id from member

--무슨 컬럼 기준으로 정렬? order by   desc, asc
select * from member order by id asc
select * from member order by id desc
--quiz member 테이블의 모든 레코드를 조회하는데, name 기준으로 오름차순 정렬하시오 
select * from member order by name asc

--quiz name으로 내림차순 정렬후, name 이 같으면,  age 로 내림차순 정렬한다. 
select * from member order by name desc , age desc

commit
select * from student3
