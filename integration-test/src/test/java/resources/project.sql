DROP TABLE IF EXISTS PROJECT;

create table PROJECT
(
ID INTEGER not null,
NAME VARCHAR(255) not null,
ACCOUNT VARCHAR(255),
primary key(id)
);

INSERT INTO PROJECT (ID, NAME, ACCOUNT) VALUES (1, 'A', 'You know');
INSERT INTO PROJECT (ID, NAME, ACCOUNT) VALUES (2, 'B', 'You know');
INSERT INTO PROJECT (ID, NAME, ACCOUNT) VALUES (3, 'C', 'Other');
INSERT INTO PROJECT (ID, NAME, ACCOUNT) VALUES (4, 'C', 'Other');
INSERT INTO PROJECT (ID, NAME, ACCOUNT) VALUES (5, 'C', 'Other');
INSERT INTO PROJECT (ID, NAME, ACCOUNT) VALUES (6, 'C', 'Other');