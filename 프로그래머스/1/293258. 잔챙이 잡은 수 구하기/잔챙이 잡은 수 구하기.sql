select count(*) fish_count
from fish_info
where ifnull(length,0) <= 10