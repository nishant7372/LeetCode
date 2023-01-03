-- Query 1
# Write your MySQL query statement below
SELECT name FROM Customer
WHERE coalesce(referee_id,"")!=2

-- Query 2
# Write your MySQL query statement below
select name from Customer
where referee_id<>2 OR referee_id IS NULL

-- Query 3
# Write your MySQL query statement below
select name from Customer
where referee_id!=2 OR referee_id IS NULL

-- Query 4
# Write your MySQL query statement below
select name from Customer
where NOT referee_id=2 OR referee_id IS NULL
