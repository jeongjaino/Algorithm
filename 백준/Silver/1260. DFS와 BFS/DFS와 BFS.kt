import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    var visited = BooleanArray(n + 1) { false }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        graph[j].add(i)
        graph[i].add(j)
    }
    dfs(v, graph, visited)
    println()
    visited = BooleanArray(n + 1) { false }
    bfs(v, graph, visited)
}
fun bfs(v : Int, graph : Array<MutableList<Int>>, visited : BooleanArray){
    val q : Queue<Int> = LinkedList<Int>()
    q.add(v)
    visited[v] = true
    while(q.isNotEmpty()){
        val cur = q.poll()
        print("$cur ")
        graph[cur].sort()
        for(i in graph[cur]){
            if(!visited[i]){
                q.add(i)
                visited[i] = true
            }
        }
    }
}

fun dfs(v : Int, graph : Array<MutableList<Int>>, visited : BooleanArray){
    visited[v] = true
    graph[v].sort()
    print("$v ")
    for(i in graph[v]){
        if(!visited[i]){
            dfs(i, graph, visited)
        }
    }
}
