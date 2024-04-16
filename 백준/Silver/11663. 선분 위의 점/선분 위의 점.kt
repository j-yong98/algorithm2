import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()


    val arr = IntArray(N)
    st = StringTokenizer(readLine())
    for (i: Int in 0..<N) {
        arr[i] = st.nextToken().toInt()
    }
    val upper = fun(value: Int): Int {
        var l = 0
        var r = N

        while (l < r) {
            val mid = (l + r) shr 1

            if (arr[mid] <= value) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        return r
    }

    val lower = fun(value: Int): Int {
        var l = 0
        var r = N

        while (l < r) {
            val mid = (l + r) shr 1

            if (arr[mid] < value) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        return r
    }

    arr.sort()
    val sb = StringBuilder();
    for (i: Int in 0..<M) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val low = lower(a)
        val up = upper(b)
        sb.append(up - low).append("\n")
    }
    println(sb)
}
