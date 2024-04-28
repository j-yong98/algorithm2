select count(*) fish_count
from fish_info a
join fish_name_info b
on a.fish_type = b.fish_type
where b.fish_name in ('BASS', 'SNAPPER')