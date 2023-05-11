class Solution {
    fun solution(new_id: String): String {
        var answer = new_id.toLowerCase()
        var new = ""
        for(i in answer){
            if(i.isDigit() || i.isLetter() || i == '_' || i == '-' || i == '.'){
                new += i
            }
        }
        answer = new

        answer = answer.replace("[.]*[.]".toRegex(), ".")

        answer = answer.removePrefix(".").removeSuffix(".")
        if(answer.isEmpty()){
            answer = "a"
        }
        
        if(answer.length >= 16){
            answer = answer.slice(0 until 15).removeSuffix(".")
        }
        
        while(answer.length < 3){
           answer += answer.last()
        }
        
        return answer
    }
}