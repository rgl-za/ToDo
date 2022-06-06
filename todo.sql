drop table todo;

CREATE TABLE todo(
 idx    number not null,
 item 		  varchar(100) 		 NOT NULL,
 status 		varchar(1) default 'n'

);


DROP SEQUENCE seq_idx_no;
CREATE SEQUENCE seq_idx_no
INCREMENT BY 1
START WITH 1 ;