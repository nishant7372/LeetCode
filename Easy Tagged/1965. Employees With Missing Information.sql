# Write your MySQL query statement below
SELECT e.employee_id
FROM Employees AS e 
LEFT OUTER JOIN 
Salaries AS s USING(employee_id)
WHERE s.employee_id IS NULL

UNION

SELECT s.employee_id
FROM Employees AS e 
RIGHT OUTER JOIN 
Salaries AS s USING(employee_id)
WHERE e.employee_id IS NULL
ORDER BY employee_id;
