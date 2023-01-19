# Write your MySQL query statement below
SELECT customer_number 
FROM Orders
GROUP BY customer_number
HAVING count(*)>=ALL(SELECT count(*) FROM Orders GROUP BY customer_number);
