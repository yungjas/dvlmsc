CREATE TABLE `mscszn`.`new_table` (
  `music_id` INT NOT NULL AUTO_INCREMENT,
  `music_name` VARCHAR(125) NOT NULL,
  `artist_name` VARCHAR(125) NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `track_length` VARCHAR(45) NOT NULL,
  `data` LONGBLOB NULL,
  `filename` VARCHAR(125) NULL,
  PRIMARY KEY (`music_id`));

insert into music(music_name, artist_name, genre, track_length) values ("test", "jasmine", "testing", "1:00");