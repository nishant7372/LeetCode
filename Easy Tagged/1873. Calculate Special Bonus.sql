#Query 1
# Write your MySQL query statement below
SELECT employee_id,salary as bonus
FROM Employees
WHERE name NOT LIKE 'M%' AND employee_id%2=1

UNION

SELECT employee_id,0 as bonus
FROM Employees
WHERE name LIKE 'M%' OR employee_id%2=0
ORDER BY employee_id;

#Query 2
# Write your MySQL query statement below
SELECT employee_id,(CASE WHEN name LIKE 'M%' OR employee_id%2=0 
                         THEN 0
                         ELSE salary
                         END ) as bonus
FROM Employees
ORDER BY employee_id;
