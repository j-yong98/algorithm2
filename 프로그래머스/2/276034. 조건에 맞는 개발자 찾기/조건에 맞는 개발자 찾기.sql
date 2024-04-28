select distinct d.id, d.email, d.first_name, d.last_name
from skillcodes s
join developers d 
where (s.name = 'C#' or s.name = 'python') and d.skill_code & s.code != 0
order by d.id asc