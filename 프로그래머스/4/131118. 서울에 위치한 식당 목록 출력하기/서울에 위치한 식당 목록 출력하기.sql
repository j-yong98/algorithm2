-- -- 코드를 입력하세요
SELECT v.REST_ID, r.REST_NAME, r.FOOD_TYPE, r.FAVORITES, r.ADDRESS, v.SCORE
from rest_info r, (
    select rest_id, round(avg(review_score), 2) score
    from rest_review
    group by rest_id
) v
where r.address like '서울%'
and v.rest_id = r.rest_id
order by v.SCORE desc, r.FAVORITES desc;