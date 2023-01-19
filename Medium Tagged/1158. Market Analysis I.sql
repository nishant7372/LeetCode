# Write your MySQL query statement below
SELECT t1.user_id AS buyer_id,join_date,COALESCE(orders_in_2019,0) AS orders_in_2019
FROM 
Users AS t1 LEFT JOIN
(SELECT user_id,count(order_id) AS orders_in_2019
FROM Users AS u INNER JOIN (SELECT * 
                            FROM Orders
                            WHERE order_date BETWEEN '2019-01-01' AND '2019-12-31') as o ON user_id=buyer_id
GROUP BY user_id) AS t2 ON t1.user_id=t2.user_id
