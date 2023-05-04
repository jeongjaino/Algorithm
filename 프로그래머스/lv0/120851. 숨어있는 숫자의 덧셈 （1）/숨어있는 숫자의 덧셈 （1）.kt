class Solution {
    fun solution(my_string: String): Int {
        var count = 0
        for(i in my_string){
            if(i.isDigit()){
                count += i.digitToInt()
            }
        }
        return count
    }
}