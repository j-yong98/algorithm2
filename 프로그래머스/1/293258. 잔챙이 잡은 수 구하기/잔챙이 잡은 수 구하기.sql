select count(*) fish_count
from fish_info
where length is null or length <= 10