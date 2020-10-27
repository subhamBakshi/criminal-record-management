CREATE TABLE police_station(
	id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    city_id INT,
    helpline_no INT,
    foreign key (city_id) references city(id)
);
 
 INSERT INTO police_station (id, name, city_id, helpline_no) 
	VALUES (1, "Wakad PS", 1, 1010),(2, "Sangavi PS", 1, 1011),(3, "Hinjewadi PS", 1, 1012),
			(4, "Andheri PS",2, 1020),(5, "Bandra PS",2, 1021),(6, "Nagpada PS",2, 1022),
			(7, "V V Puram PS", 3, 1030),(8, "Whitefield PS", 3, 1031),(9, "Subramanya Nagar PS", 3, 1032),
			(10, "Alipur PS", 4, 1040),(11, "Park Street PS", 4, 1041),(12, "Taratala PS", 4, 1042),
			(13, "Esplanade PS",5 , 1050),(14, "Port Marine PS", 5, 1051),(15, "Ennore PS", 5, 1052),
			(16, "PS Chetganj", 6, 1060),(17, "Lanka PS", 6, 1061),(18, "Luxa Thana PS", 6, 1062),
            (19, "Darya Ganj PS", 7, 1070),(20, "Jama Masjid PS", 7, 1071),(21, "Laxmi Nagar PS", 7, 1072),
            (22, "Jawahar Circle PS", 8, 1080),(23, "PS Kotwali", 8, 1081),(24, "Sodala PS", 8, 1082),(25, "Chaksu PS", 8, 1083),
            (26, "PS Soura", 9, 1090),(27, "PS Karan Nagar", 9, 1091),
            (28, "Danapur PS", 10, 1101),(29, "Kadamkuan PS", 10, 1102),(30, "Didarganj PS", 10, 1103);
            
SELECT * FROM police_station;