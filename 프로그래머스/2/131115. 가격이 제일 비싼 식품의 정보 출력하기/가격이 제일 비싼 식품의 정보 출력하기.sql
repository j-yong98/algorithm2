select *
from (
select *
from food_product
order by price desc
)
where rownum <= 1