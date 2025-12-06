select 
h.history_id, 
h.car_id, 
to_char(h.start_date, 'YYYY-MM-DD') start_date, 
to_char(h.end_date, 'YYYY-MM-DD') end_date,
(
    case when h.end_date - h.start_date + 1 >= 30 then '장기 대여'
    else '단기 대여'
    end
) rent_type
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
where start_date >= to_date('2022-09-01', 'YYYY-MM-DD')
and start_date < to_date('2022-10-01', 'YYYY-MM-DD')
order by h.history_id desc;