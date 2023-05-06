class Solution {
    fun solution(n: Long): Long {
        val str = n.toString()
        val array = IntArray(str.length)
        var index = 0
        for(i in str){
            array[index] = i.digitToInt()
            index ++
        }
        array.sortDescending()
        var result = ""
        for(i in array){
            result += i.toString()
        }
        return result.toLong()
    }
}