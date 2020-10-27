CREATE TABLE criminal(
	id INT PRIMARY KEY,
    name VARCHAR(50),
    dob DATE,
    gender INT
);

SELECT * FROM criminal;

ALTER TABLE criminal ADD photo BLOB;
ALTER TABLE criminal ADD address VARCHAR(50);
ALTER TABLE criminal ADD contact_no INT;
-- ALTER TABLE criminal ADD no_of_cases_registered INT;

ALTER TABLE criminal MODIFY gender VARCHAR(15);
ALTER TABLE criminal MODIFY contact_no BIGINT;

INSERT INTO criminal (id, name, dob, gender, address, contact_no) 
	VALUES (101, "Gabbar Singh", "1967-02-15", "Male", "Badal, Punjab", 7989102044);
    
INSERT INTO criminal (id, name, dob, gender, address, contact_no) 
	VALUES (102, "Dinesh Karthik", "1985-06-01", "Male", "Chennai, Tamil Nadu", 8420102044);
    
INSERT INTO criminal (id, name, dob, gender, address, contact_no) 
	VALUES (103, "Rahul Kumar Jha", "1983-04-17", "Male", "Patna, Bihar", 8980909440);
    