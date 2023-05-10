class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = IntArray(commands.size)
        var i = 0 
        for(c in commands){
            val temp = array.slice(c[0] - 1 .. c[1] - 1).sorted()
            answer[i] = temp[c[2] - 1]
            i++
        }
        return answer
    }
}