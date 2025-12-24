select pg as "price_group", count(*) products
from (
    select (floor(p.price / 10000) * 10000) pg, p.price
    from PRODUCT p
)
group by pg
order by pg