use techtr;
show databases;
create table tpl_employee(
 eid int ,
 ename varchar(100) ,
 esal int
);

rename table tpl_employee to tbl_employee;

describe tbl_employee;

insert into tbl_employee values (101,'Abhiram',100000);

insert into tbl_employee values (102,'Ramesh',200000);

select * from tbl_employee;

select eid , ename from tbl_employee;

insert into tbl_employee values (103,null,50000);

select * from tbl_employee;

select * from tbl_employee where eid=101;

select * from tbl_employee where eid!=101;

select ename from tbl_employee where esal <= 100000;

select eid , ename from tbl_employee where ename is null;

select eid , ename from tbl_employee where ename is not null;

select eid from tbl_employee where eid in (101,103);

select eid from tbl_employee where eid not in (101,103);

select eid from tbl_employee where eid in (101,109);

select esal from tbl_employee where esal between 50000 and 200000;

select esal from tbl_employee where esal not between 5000000 and 200000;

select ename from tbl_employee where ename like 'A%';

select ename from tbl_employee where ename like '_B%';

set SQL_SAFE_UPDATES=0;

update tbl_employee set esal=0 where eid=102;

select * from tbl_employee;

rollback;

select * from tbl_employee;

delete from tbl_employee where ename is null;

select * from tbl_employee;

select eid, sysdate(), "Abhiram", 100+200 from tbl_employee;

select eid, sysdate() as tdate, "Abhiram", 100+200 as col from tbl_employee;

alter table tbl_employee add deptno int;

alter table tbl_employee drop column deptno;

alter table tbl_employee rename column eid to empid;

truncate table tbl_employee;

rename table tbl_employee to tbl_emp;

drop table tbl_emp;