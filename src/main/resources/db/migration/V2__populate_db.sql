insert into workers (id, name, birthday, leveltechskill, salary)
VALUES (1, 'Vinnie Pooh', '1992-03-04', 'Junior', 2500),
(2, 'Pyatachok', '1995-04-05', 'Trainee', 1500),
(3, 'Kristofer Robin', '1982-09-11', 'Senior', 4600),
(4, 'Owl', '1986-01-02', 'Senior', 4000),
(5, 'Tigra', '1998-03-02', 'Trainee', 1300),
(6, 'Little Ru', '2005-05-05', 'Trainee', 650),
(7, 'Rabbit', '1998-01-02', 'Middle', 3500),
(8, 'Ia', '2000-10-22', 'Junior', 2000),
(9, 'Kenga', '1988-03-08', 'Middle', 3800),
(10, 'Slonopotam', '2010-10-30', 'Junior', 1000);


insert into clients (name) values
('Mickey Mouse'), ('Guffie'), ('Minnie'),
('Scrooge'), ('Donald Duck');

insert into projects (id, client_id, start_date, finish_date) values
(1, 1, '2021-12-31', '2023-01-31'), (2, 1, '2022-01-31', '2023-01-31'), (3, 2, '2015-12-31', '2023-01-31'),
(4, 3, '2015-12-31', '2023-01-31'), (5, 3, '2016-05-18', '2018-02-14'), (6, 3, '2020-12-31', '2022-10-30'),
(7, 3, '2014-01-01', '2016-01-01'), (8, 4, '2016-05-18', '2017-01-02'), (9, 5, '2020-03-03', '2022-03-30'),
(10, 5, '2012-05-18', '2020-02-14');


insert into project_worker (project_id, worker_id) values (1,1), (1,2), (2,2), (2,3), (3,1), (3,2), (3,3), (3,4), (3,5),
(4,2), (4,4), (4,5), (4,6),  (5,6), (5,7), (6,3), (6, 7), (6,8), (7,8), (7,9), (7,10), (8,7), (9,8), (9,9),(9,10),
(10,1), (10,3), (10,9), (10,10);
