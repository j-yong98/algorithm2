-- 코드를 입력하세요
select u.user_id, u.nickname, (u.city || ' ' || u.STREET_ADDRESS1 || ' ' || STREET_ADDRESS2) "전체주소", (substr(u.TLNO, 1, 3) || '-' || substr(u.TLNO, 4,4) || '-' || substr(u.TLNO, 8,4)) "전화번호" 
from (
    select writer_id
    from USED_GOODS_BOARD
    group by writer_id
    having count(*) >= 3
) b, USED_GOODS_USER u
where u.user_id = b.writer_id
order by u.user_id desc;