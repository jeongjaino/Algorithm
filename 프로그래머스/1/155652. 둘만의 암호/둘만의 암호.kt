class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val skipAsciiArray = IntArray(skip.length) { 0 }
        
        skip.forEachIndexed { index, value -> 
            skipAsciiArray[index] = value.toInt()
        }
                        
        var result = ""
        s.forEach { value -> 
            var skipIndex = value.toInt()
            var count = 0 
            while(count < index) {
                skipIndex = ifOverZtoA(++skipIndex)
                
                // skip이 아닌 경우, 
                if(skipIndex !in skipAsciiArray) {
                    count ++
                }
            }
            result += skipIndex.toChar()
        }
        return result
    }
    
    fun ifOverZtoA(value: Int): Int {
         if(value > 122) {
             return 96 + (value % 122)
         }
         return value
    }
}