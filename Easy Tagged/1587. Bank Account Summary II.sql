# Write your MySQL query statement below
SELECT u.name,sum(t.amount) AS balance
FROM users AS u INNER JOIN transactions AS t ON u.account=t.account
GROUP BY u.account
HAVING balance>10000;
