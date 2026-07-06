create database ems;

use ems;

create table if not exists tbl_employee(
	eid int primary key,
    ename varchar(100),
    salary int,
    dno int
    );

insert into tbl_employee values(101,"Ram",10000,10);

insert into tbl_employee values(102,"Shyam",10000,20);

insert into tbl_employee values(103,"Geeta",10000,10);

insert into tbl_employee values(104,"Nita",10000,20);

select * from tbl_employee;

desc tbl_employee;

select dno , count(*) from tbl_employee group by dno;

select dno,sum(salary),round(avg(salary),2) from tbl_employee group by dno;

select dno,sum(salary),min(salary),max(salary) from tbl_employee 
group by dno having min(salary) > 5000;

select dno,sum(salary),round(avg(salary),2) from tbl_employee 
group by dno order by dno desc;

create table if not exists tbl_dept(
	dno int primary key,
    dname varchar(20)
    );

insert into  tbl_dept values(10,"Development");
insert into tbl_dept values(20,"Tasty");

select * from tbl_dept;

update tbl_dept set dname = "Testing" where dno = 20;

select dname from tbl_dept where dno in (select dno from tbl_employee);

select * from tbl_employee where dno = (select dno from tbl_dept where dname = "Testing");

select dname from tbl_dept where dno = (select dno from tbl_employee where ename = "Ram");

select dname from tbl_dept where dno in 
(select dno from tbl_employee where eid = 101 or eid = 102);

alter table tbl_employee modify ename varchar(100) not null;

drop table tbl_employee;

create table if not exists tbl_employee(
	eid int primary key,
    ename varchar(100) not null,
    email varchar(100) unique,
    salary int check (salary > 0)
    );

insert into tbl_employee values (101,"Ram","ram@gmail.com",10000);

insert into tbl_employee values (102,"Shyam","shyam@gmail.com",10000);

select * from tbl_employee;

alter table tbl_employee add column dno int;

update tbl_employee set dno = 20 where eid = 102;

alter table tbl_employee add constraint cn1 foreign key (dno) references tbl_dept(dno);

show create table tbl_employee;

select * from tbl_employee;

insert into tbl_employee values (104,"Sai","sai@gmail.com",10000,40);

DELIMITER //

create procedure insertEmployee
(in eid int ,in ename varchar(20), in email varchar(20), in salary int,in dno int)
begin 
	insert into tbl_employee (eid,ename,email,salary,dno)
    values(eid,ename,email,salary,dno);
end //

DELIMITER ;

 call insertEmployee(105,"Ramu","ramu@gmail.com",10000,10);
 
 drop procedure insertEmployee;
 
 show procedure status where db = "testdata";
 
DELIMITER //
create procedure getEmployeeName(in eid int,out empname varchar(20))
begin
	select ename into empname from tbl_employee e where e.eid = eid;
end //

call getEmployeeName(101,@empname);
select @empname;

show procedure status where db = "testdata";

DELIMITER //
create function getEmpName(eid int) returns varchar(20)
DETERMINISTIC
begin
	declare empname varchar(20);
	select ename into empname from tbtbl_employeel_employee e where e.eid = eid;
    return empname;
end //
DELIMITER ;

select getEmpName(101);

-- Joins

select e.ename, d.dname from tbl_employee e natural join tbl_dept d;

select e.ename, d.dname from tbl_employee e RIGHT JOIN tbl_dept d on e.dno = d.dno;

desc tbl_employee;
select * from tbl_employee;