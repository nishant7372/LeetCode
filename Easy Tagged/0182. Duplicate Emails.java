# Write your MySQL query statement below
Select distinct T1.email from (Person as T1, Person as T2)
where T1.id<>T2.id and T1.email=T2.email
