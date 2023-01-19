# Write your MySQL query statement below
SELECT customer_id,sum(visit_id NOT IN(SELECT visit_id FROM Transactions)) AS count_no_trans
FROM Visits
GROUP BY customer_id
HAVING count_no_trans>0;
