class Solution {
    fun solution(
        name: Array<String>, yearning: IntArray, photos: Array<Array<String>>
    ): IntArray {
        var answer = IntArray(photos.size) { 0 }
        val yearnNameHashMap = HashMap<String, Int>()
        
        repeat(yearning.size) { index ->
            yearnNameHashMap.put(name[index], yearning[index])
        }
        
        photos.forEachIndexed { index, photo ->
            photo.forEach { name -> 
                answer[index] += yearnNameHashMap.get(name) ?: 0
            }
        }
        
        return answer
    }
}