use testdb;
create table tbl_file(
	title varchar(50),
    filedatat longblob
);

desc tbl_file;

delete from tbl_file;
select * from tbl_file;

insert into tbl_file
values('practice',load_file('c:\\SQL\\practice.zip'));

insert into tbl_file
values('1',load_file('c:\\SQL\\1.jpg'));

select *  from tbl_file;
select filedatat from tbl_file where title='1'
into dumpfile 'c:/sql/down1.exe';