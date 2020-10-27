CREATE TABLE city(
	id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
 
 INSERT INTO city (id, name) 
	VALUES (1, "Pune"),(2, "Mumbai"),(3, "Bangalore"),(4, "Kolkata"),(5, "Chennai"),
			(6, "Varanasi"),(7, "Delhi"),(8, "Jaipur"),(9, "Srinagar"),(10, "Patna");
            
SELECT * FROM city;
				