create database student_management_db;
use student_management_db;
create table student(
    student_id int primary key auto_increment,
    full_name varchar(100) not null ,
    email varchar(100) not null unique ,
    phone_number varchar(15) not null ,
    register_date date not null ,
    status bit default 1
);

delimiter //
create procedure find_all_student()
begin
    select * from student;
end //
delimiter //

delimiter //
create procedure create_student(
    name_in varchar(100),
    email_in varchar(100),
    phone_in varchar(15),
    register_in date
)
begin
   insert into student(full_name, email, phone_number, register_date)
       values (name_in, email_in, phone_in, register_in);

end //
delimiter //

delimiter //
create procedure find_student_by_id(
    id_in int
)
begin
    select * from  student
        where student_id = id_in;
end //

delimiter //

delimiter //
create procedure update_student(
    id_in int,
    name_in varchar(100),
    email_in varchar(100),
    phone_in varchar(15),
    status_in bit
)
begin
    update student
        set
            full_name = name_in,
            email = email_in,
            phone_number = phone_in,
            status = status_in
    where student_id = id_in;
end //
delimiter //

delimiter //
create procedure delete_student(
    id_in int
)
begin
    delete from student
        where student_id = id_in;
end //
delimiter //

delimiter //
create procedure find_student_by_name(
    name_in varchar(100)
)
begin
    declare name_search varchar(100);
    set name_search = concat('%', name_in, '%');
    select * from  student where full_name like name_search;
end //
delimiter //
