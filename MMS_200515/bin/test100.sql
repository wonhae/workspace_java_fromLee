ncreate table account(
	name varchar2(4) primary key,
	balance number(4) default 0
)

insert into account (name) values('a')
insert into account (name, balance) values('b', 1000)
commit

update account set balance = 0 where name = 'b'

select * from account

