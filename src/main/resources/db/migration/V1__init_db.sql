CREATE TABLE workers(
    id INT PRIMARY KEY,
    name VARCHAR NOT NULL,
    birthday DATE CHECK (birthday >= '1900-01-01'),
    levelTechSkill VARCHAR NOT NULL CHECK (levelTechSkill in ('Trainee', 'Junior', 'Middle', 'Senior')),
    salary INT CHECK (salary > 100  AND  salary<100000)
);

CREATE TABLE clients  (
    id int  PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR   NOT NULL CHECK (LENGTH(name) >2 AND  LENGTH(name) <1000)
 );

CREATE TABLE projects  (
    id int PRIMARY KEY,
    client_id  INT,
    start_date   DATE,
    finish_date  DATE
    );

CREATE TABLE project_worker  (
    project_id  INT ,
    worker_id  INT
    );
