select y.cart_id
from
(
    select *
    from cart_products
    where name = 'Milk'
) m,
(
    select *
    from cart_products
    where name = 'Yogurt'
) y
 where y.cart_id = m.cart_id
 group by y.cart_id
 order by y.cart_id