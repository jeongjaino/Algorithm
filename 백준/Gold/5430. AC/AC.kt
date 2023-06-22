import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var stk : StringTokenizer
    turn@ for(i in 0 until n) {
        val command = br.readLine()
        val size = br.readLine().toInt()
        val arr = ArrayDeque<Int>()
        stk = StringTokenizer(br.readLine().drop(1).dropLast(1), ",")
        while(stk.hasMoreTokens()){
            arr.add(stk.nextToken().toInt())
        }
        var isReversed = false
        for (c in command) {
            if (c == 'R') {
                isReversed = !isReversed
            } else if (c == 'D') {
                if (arr.isEmpty()) {
                    println("error")
                    continue@turn
                }
                if (isReversed) arr.removeLast()
                else arr.removeFirst()
            }
        }
        if (isReversed) arr.reverse()
        println("[${arr.joinToString(",")}]")
    }
}
