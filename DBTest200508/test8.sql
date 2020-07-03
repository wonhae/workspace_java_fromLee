
create table test8(
eid number(5), 
ename varchar2(21), 
dcode varchar2(21), 
salary number, 
hometown varchar2(21)
)

insert into test8 values (1, '홍길동', '인사부', 2000, '경기')
insert into test8 values (3, '박길동', '인사부', 2000, '인천')
insert into test8 values (4, '고길동', '인사부', 3000, '대구')
insert into test8 values (4, 'john', '인사부', 5000, '대구')
insert into test8 values (4, 'tom', '인사부', 7000, '대구')
insert into test8 values (5, '이길동', '인사부', 4000, '경주')
insert into test8 values (2, '김길동', '홍보부', 4000, '서울')
insert into test8 values (6, '강길동', '홍보부', 3000, '경기')
insert into test8 values (7, '각길동', '홍보부', 2000, '서울')
insert into test8 values (8, '곽길동', '홍보부', 4000, '인천')
insert into test8 values (9, '구길동', '홍보부', 6000, '광주')
insert into test8 values (10, '맹길동', '홍보부', 7000, '대전')
insert into test8 values (11, '이순실', '비서실', 7000, '대전')
insert into test8 values (12, null, '관리부 ', 5000, '제주')

commit 

집계함수 = 통계함수 
select count(*) from test8
select count(eid) from test8  --eid 가 프라이머리 키라는 가정하에, 프라이머리 키를 count(eid)로 써서 검색하는게 트랜드이다. 프라이머리키는 notnull 조건있다. 
select count(ename) from test8  --이렇게는 잘 안한다. 

사장이 사원들 인건비 총합을 알고싶습니다. 어떻게 알 수 있을까요?
select sum(salary)*10000 총인건비 from test8

평균연봉
select avg(salary) from test8

가장많은/적은 연봉
select max(salary) from test8
select min(salary) from test8


**그룹짓기  group by 절 having 절 학습 
--elect 뒤에는group by 조건, 집계함수만 올 수 있다. ( x select * from test8 group by hometown) (철수네 반 이런거 안됨. 1-2반 1-3반) 
select hometown from test8 group by hometown 
select hometown, max(salary) from test8 group by hometown

dcode 별 그룹 짓고, 각 그룹에 몇명이 있는지를 조회하시오 
select dcode, count(*) from test8 group by dcode
select dcode, avg(salary) from test8 group by dcode

그룹에 대한 조건지정 ->having 절
최고연봉이 5천만원 이상인 사원이 있는 부서 조회
select dcode from test8 group by dcode having max(salary) >= 5000

select dcode from test8 group by dcode having avg(salary)>= 2000 or hometown = '경기' 

최고 연봉이 5천만원 이상의 사원이 있는 hometown  조회 
select hometown from test8 group by hometown having max(salary) >= 5000

사원수가 2명 이상이 있는 hometown 조회 
select hometown, count(*) from test8 
group by hometown 
having count(ename) >=2

조건절에 논리 연산자 들어갈 수 있다. 
and or

나중에 게시판 할 때 
select * from test8
where 
salary >= 3000 and salary <= 5000

select * from test8
where 
salary between A and B  
--A, B 둘다 포함 

hometown 이 경기 또는 서울인 것 조회 
select * from test8  
where 
hometown = '경기' or hometown = '서울'  or hometown = '대전'  or hometown = '대구' 

select * from test8
where
hometown in ('경기', '서울', '대전', '대구')

select 문의 결과는 table[relation], select 의 from 절에 relation 절 넣을 수 있다 = subquery 
select dcode, count(*) from test8 group by dcode
select * from (select dcode, count(*) from test8 group by dcode)  -- 위와 동일  (조건을 걸 떄 사용함) 
-- subquery 
select dcode from (select dcode, eid from test8)

select * from test8
where dcode in (select dcode from test8 group by dcode)


최고 연봉이 5000만원 이상인 부서의 모든 사원들의 정보를 조회하시오  (having 절)
select * from test8 
where 
dcode in (select dcode from test8 group by dcode having max(salary) >= 5000)

최고 연봉이 5000만원 이상인 부서의 최고 연봉을 받고 있는 사원의 정보를 조회하시오  (having 절) (구조조정 할때 많이 쓰인다.)
select * from test8
where
salary in (select max(salary) from test8 group by dcode having max(salary) >=5000)
--*in 안에는 컬럼이 하나만 있어야 한다. 


각부서의 최고 연봉자 뽑기 
select * from test8 
where
(dcode, salary)
in (select dcode, max(salary) from test8 
						group by dcode 
						having max(salary) >= 5000 )
						
		
테이블의 별칭 붙일때? join 나올 때!!
실행순서? 	select ->from test8 e -> e.ename					
select e.ename from test8 e where e.eid = 1
