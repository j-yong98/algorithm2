-- 코드를 입력하세요
select distinct h.car_id, 
case when exists (
    select 1
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date <= to_date('2022-10-16', 'YYYY-MM-DD')
    and end_date >= to_date('2022-10-16', 'YYYY-MM-DD')
    and h.car_id = car_id
) then '대여중'
else '대여 가능' end AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
order by car_id desc
