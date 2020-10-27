CREATE TABLE criminal_record (
	criminal_id INT,
    criminal_name VARCHAR(50),
    case_id INT,
    crime_id INT,
    FOREIGN KEY (criminal_id) REFERENCES criminal(id),
    -- FOREIGN KEY (criminal_name) REFERENCES criminal(name),
    FOREIGN KEY (case_id) REFERENCES case_table(case_id),
    FOREIGN KEY (crime_id) REFERENCES crime(id)
);

SELECT * FROM criminal_record;

INSERT INTO criminal_record VALUES (101, "Gabbar Singh", 5001,3);
INSERT INTO criminal_record VALUES (102, "Dinesh Karthik", 5043,8);
INSERT INTO criminal_record VALUES (103, "Rahul Kumar Jha", 5055,12);
INSERT INTO criminal_record VALUES (103, "Rahul Kumar Jha", 5056,4);

ALTER TABLE criminal_record DROP criminal_name;