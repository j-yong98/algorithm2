import java.util.*
import kotlin.math.max


fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val N: Int = st.nextToken().toInt()
    val K: Int = st.nextToken().toInt()
    val arr: IntArray = IntArray(N)

    st = StringTokenizer(readLine())
    for (i: Int in 1..N) {
        arr[i - 1] = st.nextToken().toInt()
    }
    var l = 0
    var r = 0
    var ans = 0
    var tmp = K
    var cnt = 0
    while (r < N) {
        if (arr[r] % 2 == 0) {
            r++
            cnt++
            ans = max(ans, cnt)
        } else if (tmp > 0) {
            r++
            tmp--
        } else {
            var flag = if (arr[l] % 2 == 0) true else false
            tmp = if (flag) tmp else tmp + 1
            cnt = if (flag) cnt - 1 else cnt
            l++
        }
    }
    println(ans)
}
