-- 코드를 입력하세요
SELECT u.user_id, u.nickname, total_sales
from used_goods_user u, (
    select writer_id, sum(price) total_sales
    from USED_GOODS_BOARD
    where status = 'DONE'
    group by writer_id
    having sum(price) >= 700000
) b
where b.writer_id = u.user_id
order by total_sales asc;