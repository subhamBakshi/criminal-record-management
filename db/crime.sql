CREATE TABLE crime(
	id INT PRIMARY KEY,
    name VARCHAR(100)
);

INSERT INTO crime(id, name)
 VALUE (1, "abduction"), (2, "arson"), (3, "assault"),(4, "burglary"),(5, "child abuse"),
		(6, "drug trafficking"),(7, "false imprisonment"),(8, "fraud"),(9, "hacking"),(10, "hijacking"),
        (11, "human trafficking"),(12, "murder"),(13, "attempted murder"),(14, "genocide"),(15, "organised crime"),
        (16, "pick-pocket"),(17, "smuggling"),(18, "shop-lifting"),(19, "terrorism"),(20, "traffic violation"),
        (21, "vandalism"),(22, "white collar crime");
        
SELECT * FROM crime;