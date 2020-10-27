CREATE TABLE case_table(
	sl_no INT,
	case_id INT PRIMARY KEY,
    crime_id INT,
    registration_date DATE,
    registered_PS INT,
    case_description VARCHAR(200),
    case_status VARCHAR(50),
    FOREIGN KEY (crime_id) REFERENCES crime(id),
    FOREIGN KEY (registered_PS) REFERENCES police_station(id)
);

SELECT * FROM case_table;

INSERT INTO case_table VALUES (1, 5001, 3, "2000-11-17", 19, "Brutal assault on a bank manager", "closed");
INSERT INTO case_table VALUES (2, 5043, 8, "2020-10-03", 10, "Management level fraud", "pending");
INSERT INTO case_table VALUES (3, 5055, 12, "2010-02-13", 4, "Murder of 38 yrs old IT worker", "closed");
INSERT INTO case_table VALUES (4, 5056, 4, "2010-02-13", 4, "Robbery and snatching worth 25000 cash along with mobile and other valuables", "closed");

ALTER TABLE case_table modify sl_no int unique AUTO_INCREMENT;