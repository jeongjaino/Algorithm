import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val stk = StringTokenizer(br.readLine())
    val numbers = IntArray(n)
    repeat(n){ i ->
        numbers[i] = stk.nextToken().toInt()
    }
    val stack = mutableListOf<Int>()
    val result = IntArray(numbers.size){ -1 }
    for(i in numbers.indices){
        while(stack.isNotEmpty() && numbers[i] > numbers[stack.last()]){
            result[stack.last()] = numbers[i]
            stack.removeLast()
        }
        stack.add(i)
    }
    print(result.joinToString(" "))
}