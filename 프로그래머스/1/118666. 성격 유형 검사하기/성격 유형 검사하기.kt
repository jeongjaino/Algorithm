class Solution {
    val TypeMap: HashMap<Char, Int> = hashMapOf(
        'R' to 0, 'T' to 0, 'C' to 0, 'F' to 0, 
        'J' to 0, 'M' to 0, 'A' to 0, 'N' to 0,
    )
    
    fun solution(surveys: Array<String>, choices: IntArray): String {
        for(index in surveys.indices) {
            addPoint(surveys[index], choices[index])
        }
        
        val typeArray = arrayOf(arrayOf('R', 'T'), arrayOf('C', 'F'),
                                arrayOf('J', 'M'), arrayOf('A', 'N'))
        
        var result = ""
        typeArray.forEach { types ->
            result += getBiggerPointKey(types[0], types[1])
        }
        return result
    }
    
    fun addPoint(survey: String, choice: Int) {
        if(choice < 4) {
            // 1 -> 3, 2 -> 2, 3 -> 1
            val type = survey.get(0)
            val point = 4 - choice
            
            val value = TypeMap.get(type) ?: 0
            TypeMap.put(type, value + point)
            
            return 
        }
        
        if(choice > 4) {
            val type = survey.get(1) 
            val point = choice - 4 // 5 -> 1, 6 -> 2, 7 -> 3
            
            val value = TypeMap.get(type) ?: 0
            TypeMap.put(type, value + point)
        }
    }
    
    fun getBiggerPointKey(key1: Char, key2: Char): Char {
        val value1 = TypeMap.get(key1) ?: 0
        val value2 = TypeMap.get(key2) ?: 0
        
        if(value1 == value2) { // 값이 같은 경우 
            if(key1 < key2) {
                return key1
            }
            return key2
        }
        else if(value1 > value2) {// 첫번째가 더 큰경우 
            return key1
        }
        else { // 그 외의 경우 (두번째가 더 큰 경우)
            return key2
        }
    }
}