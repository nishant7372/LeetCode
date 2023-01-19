# Query 1
# Write your MySQL query statement below
SELECT user_id,max(time_stamp) as last_stamp        
FROM Logins
WHERE time_stamp BETWEEN '2020-01-01 00:00:00' AND '2020-12-31 23:59:59'
GROUP BY user_id;

# Query 2
# Write your MySQL query statement below
SELECT user_id,max(time_stamp) as last_stamp        
FROM (SELECT a.user_id,a.time_stamp
      FROM Logins as a,Logins as b
      WHERE a.user_id=b.user_id AND a.time_stamp BETWEEN '2020-01-01 00:00:00' AND '2020-12-31 23:59:59') as NewLogins
GROUP BY user_id;
