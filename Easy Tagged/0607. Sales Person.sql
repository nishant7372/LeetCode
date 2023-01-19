# Write your MySQL query statement below
SELECT name
FROM SalesPerson
WHERE sales_id NOT IN
(SELECT sales_id
FROM Company AS c INNER JOIN Orders AS o USING(com_id)
GROUP BY sales_id
HAVING sum(name='RED')!=0);
