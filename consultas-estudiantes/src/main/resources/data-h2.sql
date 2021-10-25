INSERT INTO CLASSROOMS (GRADE, LETTER) VALUES ('1', 'A');
INSERT INTO CLASSROOMS (GRADE, LETTER) VALUES ('2', 'B');

INSERT INTO STUDENTS (NAME, SURNAME) VALUES ('ANAKIN', 'SKYWALKER');
INSERT INTO STUDENTS (NAME, SURNAME) VALUES ('OBI WAN', 'KENOBY');
INSERT INTO STUDENTS (NAME, SURNAME) VALUES ('HAN', 'SOLO');
INSERT INTO STUDENTS (NAME, SURNAME) VALUES ('DARTH', 'MAUL');

INSERT INTO SUBJECTS (DESCRIPTION) VALUES ('INGLES');
INSERT INTO SUBJECTS (DESCRIPTION) VALUES ('FISICA');
INSERT INTO SUBJECTS (DESCRIPTION) VALUES ('MATEMATICAS');

INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (6.0, 1, 1, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (6.0, 1, 1, '2020-10-14 17:43:37.075');
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (6.0, 1, 1, '2019-10-14 17:43:37.075');
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (8.0, 1, 1, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (4.0, 1, 2, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (3.0, 1, 2, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (9.0, 2, 1, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (2.0, 2, 1, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (10.0, 2, 2, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (9.0, 2, 2, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (7.0, 3, 1, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (6.5, 3, 1, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (9.0, 3, 2, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (5.7, 3, 2, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (3.0, 4, 1, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (6.0, 4, 1, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (8.0, 4, 2, SYSDATE);
INSERT INTO QUALIFICATIONS (QUALIFICATION, ID_STUDENT, ID_SUBJECT, CREATE_DATE) VALUES (2.5, 4, 2, SYSDATE);

INSERT INTO STUDENT_CLASSROOMS (ID_STUDENT, ID_CLASSROOM, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (1,1,1,'2021', SYSDATE, SYSDATE);
INSERT INTO STUDENT_CLASSROOMS (ID_STUDENT, ID_CLASSROOM, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (2,1,1,'2021', SYSDATE, SYSDATE);
INSERT INTO STUDENT_CLASSROOMS (ID_STUDENT, ID_CLASSROOM, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (3,2,1,'2021', SYSDATE, SYSDATE);
INSERT INTO STUDENT_CLASSROOMS (ID_STUDENT, ID_CLASSROOM, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (4,2,1,'2021', SYSDATE, SYSDATE);


INSERT INTO SUBJECTS_CLASSROOMS (ID_CLASSROOM, ID_SUBJECT) VALUES (1,1);
INSERT INTO SUBJECTS_CLASSROOMS (ID_CLASSROOM, ID_SUBJECT) VALUES (1,2);
INSERT INTO SUBJECTS_CLASSROOMS (ID_CLASSROOM, ID_SUBJECT) VALUES (2,3);
INSERT INTO SUBJECTS_CLASSROOMS (ID_CLASSROOM, ID_SUBJECT) VALUES (2,1);


INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (1,1,'Y',2021,SYSDATE, SYSDATE);
INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (1,2,'Y',2021,SYSDATE, SYSDATE);
INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (1,3,'Y',2021,SYSDATE, SYSDATE);
INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (2,1,'Y',2021,SYSDATE, SYSDATE);
INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (2,2,'Y',2021,SYSDATE, SYSDATE);
INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (2,3,'Y',2021,SYSDATE, SYSDATE);
INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (3,1,'Y',2021,SYSDATE, SYSDATE);
INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (3,2,'Y',2021,SYSDATE, SYSDATE);
INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (3,3,'Y',2021,SYSDATE, SYSDATE);
INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (4,1,'Y',2021,SYSDATE, SYSDATE);
INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (4,2,'Y',2021,SYSDATE, SYSDATE);
INSERT INTO STUDENT_SUBJECTS (ID_STUDENT, ID_SUBJECT, STATUS, SCHOOL_YEAR, CREATE_DATE, LAST_UPDATE)
VALUES (4,3,'Y',2021,SYSDATE, SYSDATE);
