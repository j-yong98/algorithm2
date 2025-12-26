select category, count(*)
from (
select substr(p.product_code, 0, 2) category
from product p
    )
    group by category
    order by category 