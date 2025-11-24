-- 코드를 입력하세요
SELECT c.car_id
from CAR_RENTAL_COMPANY_CAR c
where c.car_type = '세단'
and exists (
    select 1
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    where h.car_id = c.car_id
    and extract(month from h.start_date) = 10
)
order by c.car_id desc
