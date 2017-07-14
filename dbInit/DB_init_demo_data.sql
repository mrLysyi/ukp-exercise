use  dbo;




insert into dbo.pn_daynames values(1,'понеділок',1,1,'пн','1');
insert into dbo.pn_daynames values(2,'вівторок',1,2,'вт','2');
insert into dbo.pn_daynames values(3,'середа',1,3,'ср','3');
insert into dbo.pn_daynames values(4,'четверг',1,4,'чт','4');
insert into dbo.pn_daynames values(5,'п''ятниця',1,5,'пт','5');
insert into dbo.pn_daynames values(6,'субота',1,8,'сб','6');
insert into dbo.pn_daynames values(7,'неділя',1,11,'нд','7');
insert into dbo.pn_daynames values(8,'понеділок-п''ятниця',5,6,'пн-пт','1,2,3,4,5');
insert into dbo.pn_daynames values(9,'понеділок-субота',6,9,'пн-сб','1,2,3,4,5,6');
insert into dbo.pn_daynames values(10,'вівторок-субота',5,10,'вт-сб','2,3,4,5,6');
insert into dbo.pn_daynames values(11,'вівторок-п''ятниця',4,7,'вт-пт','2,3,4,5');
insert into dbo.pn_daynames values(12,'понеділок-неділя',7,11,'пн-вс','1,2,3,4,5,6,7');



insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(4052,1,'1900-01-01 10:00:00.000','1900-01-01 17:00:00.000','1900-01-01 13:00:00.000','1900-01-01 13:30:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(4052,5,'1900-01-01 09:00:00.000','1900-01-01 16:00:00.000','1900-01-01 13:00:00.000','1900-01-01 13:30:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(4052,2,'1900-01-01 10:00:00.000','1900-01-01 17:00:00.000','1900-01-01 13:00:00.000','1900-01-01 13:30:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(4052,3,'1900-01-01 10:00:00.000','1900-01-01 17:00:00.000','1900-01-01 13:00:00.000','1900-01-01 13:30:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(4052,4,'1900-01-01 10:00:00.000','1900-01-01 17:00:00.000','1900-01-01 13:00:00.000','1900-01-01 13:30:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(3049,8,'1900-01-01 09:00:00.000','1900-01-01 19:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(3049,6,'1900-01-01 09:00:00.000','1900-01-01 17:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(4050,8,'1900-01-01 09:00:00.000','1900-01-01 19:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(4050,6,'1900-01-01 09:00:00.000','1900-01-01 17:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1004,8,'1900-01-01 09:00:00.000','1900-01-01 19:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1004,6,'1900-01-01 09:00:00.000','1900-01-01 17:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1008,8,'1900-01-01 09:00:00.000','1900-01-01 19:00:00.000','1900-01-01 14:00:00.000','1900-01-01 15:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1011,6,'1900-01-01 09:00:00.000','1900-01-01 17:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1011,8,'1900-01-01 09:00:00.000','1900-01-01 19:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1014,8,'1900-01-01 09:00:00.000','1900-01-01 19:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1014,6,'1900-01-01 09:00:00.000','1900-01-01 17:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1015,8,'1900-01-01 09:00:00.000','1900-01-01 19:00:00.000','1900-01-01 13:00:00.000','1900-01-01 14:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1015,6,'1900-01-01 09:00:00.000','1900-01-01 17:00:00.000','1900-01-01 13:00:00.000','1900-01-01 14:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1021,8,'1900-01-01 09:00:00.000','1900-01-01 19:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1021,6,'1900-01-01 09:00:00.000','1900-01-01 17:00:00.000','1900-01-01 00:00:00.000','1900-01-01 00:00:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1019,8,'1900-01-01 09:00:00.000','1900-01-01 19:00:00.000','1900-01-01 13:30:00.000','1900-01-01 14:30:00.000' );
insert into dbo.routine (id, dayofweek, workfrom, workto, intervalfrom, intervalto) values(1019,6,'1900-01-01 09:00:00.000','1900-01-01 17:00:00.000','1900-01-01 13:30:00.000','1900-01-01 14:30:00.000' );

