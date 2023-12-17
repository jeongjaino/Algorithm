class Solution {
    fun solution(new_id: String): String {
        var answer: String = new_id
        answer = toLowerCase(answer) // 1
        answer = removeSpecialChar(answer) // 2
        answer = removeContinuousDot(answer) // 3
        answer = removeSuffixPrefixDot(answer) // 4
        answer = isEmptyAddA(answer) // 5
        answer = sliceFifteen(answer) // 6
        answer = isLowerThan3RepeatLast(answer) // 7
        return answer
    }
    
    fun toLowerCase(id: String): String {
        var answer = ""
        id.forEach {
            if (it.isLetter()) {
                answer += it.lowercase()
            } else {
              answer += it  
            }
        }
        return answer
    }
    
    fun removeSpecialChar(id: String): String {
        var answer = ""
        id.forEach {
            if(it.isLetterOrDigit() || it == '-' || it == '_' || it == '.') {
                answer += it
            }
        }
        return answer
    }
    
    fun removeContinuousDot(id: String): String {
        if(id.length < 2) {
            return id
        }
        
        var answer = "" + id.first()
        for(c in 1 until id.length) {
            if(answer.last() == '.' && id.get(c) == '.') {
                continue
            }
            answer += id.get(c)
        }
        return answer
    }
    
    fun removeSuffixPrefixDot(id: String): String {
        return id.removeSuffix(".").removePrefix(".")
    }
    
    fun isEmptyAddA(id: String): String {
        if(id.isEmpty()) {
            return "a"
        }
        return id
    }
    
    fun sliceFifteen(id: String): String {
        if(id.length <= 15) {
            return id
        }
        var answer = ""
        answer = id.slice(0 until 15)
        answer = removeSuffixPrefixDot(answer)
        return answer
    }
    
    fun isLowerThan3RepeatLast(id: String): String {
        if(id.length >= 3) {
            return id
        }
        
        var answer = id
        while(answer.length < 3) {
            answer += id.last()
        }
        return answer
    }
}