// 키와 누르는 횟수를 하나의 맵으로 저장 
// 맵에 조회시 없을 경우, -1

class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val keyHashMap = HashMap<Char, Int>() // key, 최소 횟수 
        
        keymap.forEach { keys ->
            for(index in keys.indices) {
                val key = keys[index]
                val time = index + 1
                
                if(keyHashMap.containsKey(key)) {
                    val value = keyHashMap.get(key) !! 
                    if(time >= value) { // 이전의 값이 더 작은 경우, 
                        continue
                    }
                }
                
                keyHashMap.put(key, time)
            }
        }
        
        val result = IntArray(targets.size){ 0 }
        targets.forEachIndexed { index, target ->
            for(c in target) {
                val time: Int? = keyHashMap.get(c)
                if (time == null) { 
                    result[index] = -1 
                    break
                }
                result[index] += time
            }
        }
        
        return result
    }
}