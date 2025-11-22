-- 코드를 입력하세요
select '/home/grep/src/' || f.board_id || '/' || f.file_id || f.file_name || f.file_ext file_path
from USED_GOODS_FILE f, (
    select board_id
    from (
        SELECT board_id
        from USED_GOODS_BOARD
        order by views desc
    )
    where rownum <= 1
) b
where b.board_id = f.board_id
order by f.file_id desc; 

