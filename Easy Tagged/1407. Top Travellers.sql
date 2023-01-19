# Write your MySQL query statement below
SELECT name,sum(CASE WHEN a.id=b.user_id
                     THEN distance
                     ELSE 0
                     END ) as travelled_distance
FROM users as a INNER JOIN rides as b
GROUP BY a.id
ORDER BY travelled_distance DESC,name;

