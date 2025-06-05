select * from students;

insert into students (date_of_birth, document, first_name, last_name)
VALUES (now(), 123, 'mateo', 'brizuela');

select COLUMN_NAME,
       DATA_TYPE,
       IS_NULLABLE
#select *
from information_schema.COLUMNS
where TABLE_SCHEMA = 'ACADEMY_SYSTEM_DB'
and TABLE_NAME = 'students';

drop table tutor;