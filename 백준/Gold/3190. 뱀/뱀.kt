import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = Array<IntArray>(n){ IntArray(n) }
    val k = br.readLine().toInt() // apple n
    var stk : StringTokenizer
    repeat(k){ i ->
        stk = StringTokenizer(br.readLine())
        map[stk.nextToken().toInt() - 1][stk.nextToken().toInt() - 1] = 1 // apple -> 1
    }
    val l = br.readLine().toInt() // snake change direction count
    val dirQueue = ArrayDeque<Pair<Int, String>>() // Pair(time, dir)
    repeat(l){ i ->
        stk = StringTokenizer(br.readLine())
        dirQueue.add(Pair(stk.nextToken().toInt(), stk.nextToken()))
    }

    // 동 남 서 북
    var direction = 0
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    val snakeBody = ArrayDeque<Pair<Int, Int>>() // FIFO
    var headPos = Pair(0, 0)
    var count = 0 // 이동 횟수, 1초에 머리가 움직이는 것까지 포함.
    while(true){
        if(headPos.first !in 0 until n || headPos.second !in 0 until n){
            break
        }

        val cur = map[headPos.first][headPos.second]
        if(cur == 2){
            break
        }
        else if(cur == 0) {
            if(snakeBody.isNotEmpty()){
                val lastBody = snakeBody.first()
                snakeBody.removeFirst()
                map[lastBody.first][lastBody.second] = 0
            }
        }
        else{
            map[headPos.first][headPos.second] = 0 // eat apple
        }
        count += 1
        // 이동 -> 방향전환
        snakeBody.add(headPos)
        map[headPos.first][headPos.second] = 2
        headPos = Pair(headPos.first + dx[direction], headPos.second + dy[direction])
        if(dirQueue.isNotEmpty() && count == dirQueue.first().first){
            if(dirQueue.first().second == "L"){
                direction -= 1
                if(direction < 0) direction = 3
            }
            else{
                direction = (direction + 1) % 4
            }
            dirQueue.removeFirst()
        }
    }
    print(count)
}