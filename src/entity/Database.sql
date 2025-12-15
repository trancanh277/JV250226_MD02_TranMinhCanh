create database db_exam_management;
use db_exam_management;
CREATE TABLE `exams` (
                         `exam_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         `exam_name` varchar(150) NOT NULL,
                         `exam_date` date NOT NULL,
                         `exam_time` float NOT NULL,
                         `unit_time` varchar(15) NOT NULL,
                         `exam_format` varchar(100) NOT NULL,
                         `status` int NOT NULL,

);
	-- intellij bị lỗi tắt mất tab sql, e tìm code bên mysql workbench, coppy qua thiếu câu lệnh create database db_exam_management; 
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_exam`(
    in p_exam_name varchar(150),
    in p_exam_date date,
    in p_exam_time float,
    in p_unit_time varchar(15),
    in p_exam_format varchar(100),
    in p_status int
)
begin
    insert into exams(exam_name, exam_date, exam_time, unit_time, exam_format, status)
    values (p_exam_name, p_exam_date, p_exam_time, p_unit_time, p_exam_format, p_status);
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_exam`(
    in p_exam_id int
)
begin
    delete from exams
    where exam_id = p_exam_id;
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `find_all_exams`()
begin
    select * from exams;
end$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `find_exam_by_id`(
    in p_exam_id int
)
begin
    select * from exams
    where exam_id = p_exam_id;
end$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `find_exams_by_name`(
    in p_exam_name varchar(150)
)
begin
    select * from exams
    where exam_name like concat('%', p_exam_name, '%');
end$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_exam`(
    in p_exam_id int,
    in p_exam_name varchar(150),
    in p_exam_date date,
    in p_exam_time float,
    in p_unit_time varchar(15),
    in p_exam_format varchar(100),
    in p_status int
)
begin
    update exams
    set exam_name = p_exam_name,
        exam_date = p_exam_date,
        exam_time = p_exam_time,
        unit_time = p_unit_time,
        exam_format = p_exam_format,
        status = p_status
    where exam_id = p_exam_id;
end$$
DELIMITER ;
