class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        var answer = ""
        val mlen = my_string.length - 1
        val olen = overwrite_string.length - 1
        for(i in 0 .. mlen){
            if(s - 1 < i && i < s + olen + 1){
                answer += overwrite_string[i - s]
                continue
            }
            answer += my_string[i]
        }        
        return answer
    }
}