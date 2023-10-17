# select * from used_goods_board;
# select * from used_goods_reply;

#작성된 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일
select 
    b.title TITLE, 
    b.board_id BOARD_ID, 
    r.reply_id REPLY_ID,
    r.writer_id WRITER_ID,
    r.contents CONTENTS,
    DATE_FORMAT(r.created_date, "%Y-%m-%d") CREATED_DATE
from used_goods_board b
join used_goods_reply r
on b.board_id = r.board_id
where date_format(b.created_date, "%Y-%m-%d") between "2022-10-01" and "2022-10-31"
order by r.created_date, b.title