-- 코드를 입력하세요
SELECT b.book_id, a.author_name, to_char(b.published_date, 'YYYY-MM-DD') published_date
from book b, author a
where b.category = '경제'
and a.author_id = b.author_id
order by b.published_date;