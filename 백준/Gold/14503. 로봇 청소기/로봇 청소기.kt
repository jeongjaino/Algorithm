import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 보는 방향 북 동 남 서
private val direction = mapOf(0 to Pair(-1, 0), 1 to Pair(0, 1), 2 to Pair(1, 0), 3 to Pair(0, -1))
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var stk = StringTokenizer(br.readLine())
    val a = stk.nextToken().toInt()
    val b = stk.nextToken().toInt()
    val cur = br.readLine().split(" ").map{ it.toInt() }.toIntArray()
    val graph = Array(a){ IntArray(b) }
    for(i in 0 until a){
        stk = StringTokenizer(br.readLine())
        for(j in 0 until b){
            graph[i][j] = stk.nextToken().toInt()
        }
    }
    var result = 0
    turn@ while(true){
        if(graph[cur[0]][cur[1]] == 0){
            graph[cur[0]][cur[1]] = 2
            result += 1
        }
        else if(graph[cur[0]][cur[1]] == 1){
            break
        }

        for(i in 0 until 4){
            if(--cur[2] == -1) cur[2] = 3
            val nx = cur[0] + direction[cur[2]]!!.first
            val ny = cur[1] + direction[cur[2]]!!.second

            if(graph[nx][ny] == 0){
                cur[0] = nx
                cur[1] = ny
                continue@turn
            }
        }
        // 빈칸이 없는 경우
        cur[0] = cur[0] - direction[cur[2]]!!.first
        cur[1] = cur[1] - direction[cur[2]]!!.second
    }
    print(result)
}