CREATE TABLE prisoner(
	inmate_id INT PRIMARY KEY,
    name VARCHAR(50),
    criminal_id INT,
    crime_id INT,
    sentence VARCHAR(30),
    jail_id INT,
    serving_from DATE,
    release_date DATE,
    behaviour VARCHAR(30),
    status VARCHAR(50),
    FOREIGN KEY (criminal_id) REFERENCES criminal(id),
    FOREIGN KEY (jail_id) REFERENCES jail(id)
);

INSERT INTO prisoner (inmate_id, name, criminal_id, sentence, jail_id, serving_from, release_date, behaviour) 
	VALUES (8802, "Rahul Kumar Jha", 103, "Life imprisonment", 1, "2011-01-15","2027-01-14,", "good");
            