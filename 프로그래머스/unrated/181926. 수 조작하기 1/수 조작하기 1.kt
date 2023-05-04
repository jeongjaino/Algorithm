class Solution {
    fun solution(n: Int, control: String): Int {
        var answer: Int = n
        for(i in control.indices){
            val j = control[i].toString()
            if(j == "w"){
                answer += 1
            }
            else if(j == "s"){
                answer -= 1
            }
            else if(j == "d"){
                answer += 10
            }
            else{
                answer -= 10
            }
        }
        return answer
    }
}