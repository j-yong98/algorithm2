select h.history_id, (1 - nvl(
    (
    select p.discount_rate / 100
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
    where p.duration_type = (
        case
            when h.end_date - h.start_date + 1 >= 7 and h.end_date - h.start_date + 1 < 30 then '7일 이상'
            when h.end_date - h.start_date + 1 >= 30 and h.end_date - h.start_date + 1 < 90 then '30일 이상'
            when h.end_date - h.start_date + 1 >= 90 then '90일 이상'
        else null
        end
        )
    and p.car_type = c.car_type
    ), 0)
) * c.DAILY_FEE * (h.end_date - h.start_date + 1) fee
from CAR_RENTAL_COMPANY_CAR c, CAR_RENTAL_COMPANY_RENTAL_HISTORY h
where c.car_type = '트럭'
and h.car_id = c.car_id
order by fee desc, history_id desc