select v.month, v.car_id, count(*) records
from (
    select extract(month from start_date) month, car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where extract(year from start_date) = 2022
    and extract(month from start_date) between 8 and 10
) v
where exists (
    select 1
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    where v.car_id = h.car_id
    and extract(year from start_date) = 2022
    and extract(month from start_date) between 8 and 10
    group by h.car_id
    having count(*) >= 5
)
group by v.month, v.car_id
order by v.month, v.car_id desc