CREATE TABLE jail(
	id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    city_id INT,
    no_of_inmates INT,
    prisoner_capacity INT,
    foreign key (city_id) references city(id)
);

INSERT INTO jail (id, name, city_id, no_of_inmates, prisoner_capacity) 
	VALUES (1, "Tihar Jail", 7, 128, 300),(2, "Madras Central Jail", 5, 42, 150),(3, "Naini Central Jail", 6, 81, 100),
			(4, "Bangalore Central Jail",3, 102, 160),(5, "Yerwada Jail", 2, 26, 115);
            

ALTER TABLE jail modify no_of_inmates int unique AUTO_INCREMENT;