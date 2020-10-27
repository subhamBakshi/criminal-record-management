CREATE TABLE admin (
	id INT PRIMARY KEY,
    photo BLOB,
    first_name VARCHAR(25),
    last_name VARCHAR(25),
    registration_no INT,
    email_id VARCHAR(40),
    contact_no INT,
    aadhar_no INT UNIQUE,
    username VARCHAR(25) UNIQUE,
    password VARCHAR(25)
);

INSERT INTO admin(id, username, password)
 VALUES (1, "police", "1234"), (2, "Jailer", "1234"), (3, "CBI", "1234"); 
 
 select * from admin;