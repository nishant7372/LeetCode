# Write your MySQL query statement below
SELECT a.id FROM Weather as a, Weather as b
WHERE dateDiff(a.recordDate,b.recordDate)=1 AND b.temperature<a.temperature;
