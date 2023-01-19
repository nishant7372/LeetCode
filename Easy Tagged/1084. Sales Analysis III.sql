# Write your MySQL query statement below
SELECT p.product_id, product_name  
FROM Product AS p INNER JOIN Sales AS s ON p.product_id=s.product_id
GROUP BY p.product_id
HAVING min(sale_date)>='2019-01-01' AND max(sale_date)<='2019-03-31';
