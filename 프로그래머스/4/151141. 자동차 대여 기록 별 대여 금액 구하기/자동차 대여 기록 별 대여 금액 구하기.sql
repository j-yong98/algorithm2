select h.history_id,  (1 - nvl((
        select 
            case    
                when h.end_date - h.start_date + 1 >= 90 then discount_rate
                when h.end_date - h.start_date + 1 >= 30 then discount_rate
                when h.end_date - h.start_date + 1 >= 7  then discount_rate
            end
        from CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
        where p.car_type = c.car_type
        and (
            (p.duration_type = '7일 이상'  and h.end_date - h.start_date + 1 >= 7  and h.end_date - h.start_date + 1 < 30) or
            (p.duration_type = '30일 이상' and h.end_date - h.start_date + 1 >= 30 and h.end_date - h.start_date + 1 < 90) or
            (p.duration_type = '90일 이상' and h.end_date - h.start_date + 1 >= 90)
        )
    ), 0) / 100) * c.daily_fee * (h.end_date - h.start_date + 1) fee
from CAR_RENTAL_COMPANY_CAR c, CAR_RENTAL_COMPANY_RENTAL_HISTORY h 
where h.car_id = c.car_id(+)
and c.car_type = '트럭'
order by fee desc, h.history_id desc

