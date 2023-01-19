# Write your MySQL query statement below
SELECT id, (CASE WHEN id IN (SELECT p_id FROM Tree) && p_id IS NOT NULL
                 THEN 'Inner'
                 WHEN p_id IS NULL 
                 THEN 'Root'
                 ELSE 'Leaf'
                 END ) AS type
FROM Tree;
