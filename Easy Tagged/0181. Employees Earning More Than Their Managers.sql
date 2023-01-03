-- Query 1 (Inner Join)
# Write your MySQL query statement below
SELECT a.name AS "Employee" FROM Employee as a
INNER JOIN Employee as b
ON a.managerId=b.id AND a.salary>b.salary

-- Query 2 (Self-Join)
# Write your MySQL query statement below
SELECT a.name AS "Employee" FROM Employee as a, Employee as b
WHERE a.managerId=b.id AND a.salary>b.salary
