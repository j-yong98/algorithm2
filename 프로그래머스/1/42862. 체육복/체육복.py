def solution(n, lost, reserve):
    answer = 0
    set_lost = set(lost) - set(reserve)
    set_reserve = set(reserve) - set(lost)
    cnt = 0
    i = 0
    for x in set_reserve:
        if(x-1 in set_lost):
            set_lost.remove(x-1)
        elif(x+1 in set_lost):
            set_lost.remove(x+1)
    answer = n-len(set_lost)
            
    return answer