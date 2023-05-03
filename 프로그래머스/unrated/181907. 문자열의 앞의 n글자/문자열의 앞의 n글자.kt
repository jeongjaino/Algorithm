class Solution {
    fun solution(my_string: String, n: Int): String {
        var answer: String = ""
        for(i in my_string.indices){
            if(i > n - 1){
                break 
            }
            answer += my_string[i]
        }
        return answer
    }
}