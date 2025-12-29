select category, price max_price, product_name
from (
    select f.*,
    row_number() over (partition by f.category order by f.price desc) rn
    from food_product f
)
where rn = 1
and category in ('과자', '국', '김치', '식용유')
order by max_price desc