-- 코드를 입력하세요
select ingredient_type, sum(total_order) total_order
from (
SELECT f.flavor, f.total_order, i.ingredient_type
from FIRST_HALF f, ICECREAM_INFO i
where f.flavor = i.flavor
    )
    group by ingredient_type
    order by total_order asc;