# Query 1
# Write your MySQL query statement below
SELECT * FROM Patients
WHERE conditions LIKE '% DIAB1%'

UNION

SELECT * FROM Patients
WHERE conditions LIKE 'DIAB1%';

# Query 2
# Write your MySQL query statement below
SELECT * FROM Patients
WHERE conditions LIKE '% DIAB1%' OR conditions LIKE 'DIAB1%';
