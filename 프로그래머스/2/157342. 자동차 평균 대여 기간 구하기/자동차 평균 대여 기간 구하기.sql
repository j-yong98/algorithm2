-- 코드를 입력하세요
SELECT car_id, TO_CHAR(ROUND(AVG(end_date - start_date + 1), 1), 'FM9999.0') AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
having avg(end_date - start_date + 1) >= 7
order by to_number(AVERAGE_DURATION) desc, car_id desc
