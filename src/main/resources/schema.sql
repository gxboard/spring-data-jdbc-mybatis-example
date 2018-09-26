CREATE TABLE IF NOT EXISTS lego_set (
  id   INTEGER  PRIMARY KEY,
  name VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS manual (
  id      INTEGER  PRIMARY KEY,
  lego_set INTEGER,
  author  CHAR(100),
  text    VARCHAR(1000)
);
CREATE TABLE IF NOT EXISTS Model (
  name        VARCHAR(100),
  description TEXT,
  lego_set     INTEGER
);
