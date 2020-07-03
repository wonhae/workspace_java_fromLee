drop table member
drop table dep

create table dep (
did varchar2(4), 
dname varchar2(12)
) 
alter table dep add constraint pk_dep_did primary key(did)


create table member(
id varchar2(4), 
did varchar2(4), 
name varchar2(12)
)
alter table member add constraint pk_member_id primary key(id)
alter table member add constraint fk_member_did foreign key(did) references dep(did)

commit

insert into dep values('d001', '영업')
insert into dep values('d002', '경영')
insert into dep values('d003', '홍보')

insert into member values ('m001', 'd001', 'kim')
insert into member values ('m002', 'd002', 'lee')
insert into member values ('m003', 'd003', 'park')
insert into member values ('m004', 'd001', 'kang')
insert into member values ('m005', 'd003', 'choi')


select * from member, dep
-- x 이렇게 쓰면 못쓰게됨. select m.id, d.did, d.dname, m.name  from member m, dep d

■등가조인 equivalent join 
select m.id, d.did, d.dname, m.name
from member m, dep d
where m.did = d.did

■내부조인 inner join
select m.id, d.did, d.dname, m.name
from member m inner join dep d
on m.did = d.did
--혹시라도 member 에 또다른 외래키 있을 시!! 추가로 innerjoin 할 것 
inner join hometown h
on e.hid = h.hid

■내츄럴 조인 
select * from member m natural join dep d
natural join hometown h

■두개의 컬럼명 다를 때 (부모의 주키 컬럼과 자식의 외래키 컬럼명 다를 경우)(왠만하면 같게 해주세요)
select m.id, d.did, m.name, d.dname
from member m join dep d
on(m.did = d.did)

■두개의 컬럼 크기가 다를경우! 부모 컬럼보다 자식 컬럼이 작으면 문제가 된다.(짤린다) 크면 문제가 안된다. 
컬럼명과 크기 둘중에 하나는 같아야 한다. 

■컬럼명 다를때 
select m.id, d.did, m.name, d.dname
from member m join dep d
using(did)


■아웃터 조인은 3가지 종류  (레프트, 라이트)
아웃포조인 
아웃포조인 하기위해 멤버테이블에 좀 추가할 것
insert into member values('m010', null, 'jung')
insert into dep values('d100', '회계 ')
내츄럴 조인해보기 
commit


(왼쪽: 멤버것은 다나옴, 오른쪽: dep는 일치되는것만 나옴 )
select m.id, m.name, d.did, d.dname
from member m left outer join dep d 
on m.did = d.did

select m.id, m.name, d.did, d.dname
from member m right outer join dep d
on m.did = d.did

left outer join 을 이용해서 dep 테이블에 있는 모든데이터를 조회하되  member 테이블에 있는 데이터는 dep 와 일치할 경우에만 조회되게 하라. 
select m.id, m.name, d.did, d.dname
from dep d left outer join member m 
on m.did = d.did


풀 아웃터조인 
select m.id, m.name, d.did, d.dname
from dep d full outer join member m 
on m.did = d.did

나중 회원가입 프로젝트 만들때는 표를 2개이상으로 만들 것 
가상 테이블 만들어서 사용해볼 것 

뷰 생성(뷰도 객체)
create or replace view v_member
as 
select * from member

select * from v_member


ㅁdid 가 null 이 아닌 레코드로만 이뤄진 member 테이블 자료를 이용하여 
view_member_notnulldid 뷰를 생성하시오
create or replace view view_member_notnulldid
as
select * from member where did is not null

select * from  view_member_notnulldid

create or replace view v_member_dname
as
select * from member m  natural join dep d 

select * from  v_member_dname


----option
create or replace view v_member_notnulldid
as 
select * from member
where 
did is not null
with check option 

insert into view_member_notnulldid
(id, name, did)
values('m200', 'heo','d001')

update view_member_notnulldid set name = 'seo' 
where id = 'm200'

--안되는것임 
update view_member_notnulldid set did = null
where id = 'm200'

또다른  option 
create or replace view view_member_notnulldid
as 
select * from member
where did is not null
with read only 

