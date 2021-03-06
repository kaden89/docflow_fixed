

DELETE FROM orders;
DELETE FROM employees;
DELETE FROM divisions;
DELETE FROM organization;


ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO organization (ID,NAME, LEGAL_ADDRESS, PHYSICAL_ADDRESS)
VALUES (100001,'OOO Romashka', 'Ufa', 'Ufa'),
       (100002,'OOO Alfa', 'Moscow', 'Moscow'),
       (100100,'OOO Beta', 'Moscow', 'Moscow');

INSERT INTO divisions (ID,NAME, CONTACTS, ORGANIZATION_ID)
VALUES (100003,'shop', '+ 77 77 77', 100001 ),
       (100004,'accounting', '+ 88 88 88', 100001),
       (100005,'developers', '+ 99 99 99', 100002 ),
       (100006,'testers', '+ 55 55 55', 100002 );

INSERT INTO employees (ID,FIRST_NAME, LAST_NAME, MIDDLE_NAME, POSITION, organization_id)
VALUES (100007,'Vasya', 'Vasilev', 'Vasilevich', 'seller', 100001),
       (100008,'Petya', 'Petrov', 'Petrovich', 'accountant', 100001),
       (100009,'Ivan', 'Ivanov', 'Ivanovich', 'programmer', 100001),
       (1000010,'Vasya', 'Vasilev', 'Vasilevich', 'tester', 100001);

INSERT INTO orders (ID,SUBJECT, AUTHOR_ID, EXECUTOR_ID, DEADLINE, CONTROLLED, EXECUTED,TEXT, STATE)
VALUES (1000011,'salary', 100007, 100008, '2016-12-31 00:00:00', FALSE, FALSE,'give me my money', 'PREPARE');
