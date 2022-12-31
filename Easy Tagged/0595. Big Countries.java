# Query 1
# Write your MySQL query statement below
Select name,population,area From World
where area>2999999

UNION 

Select name,population,area From World
where population>24999999


# Query 2
# Write your MySQL query statement below
Select name,population,area FROM World
where area>2999999
or
population>24999999
