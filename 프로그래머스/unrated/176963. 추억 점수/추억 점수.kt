class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val result = IntArray(photo.size)
        val h = HashMap<String, Int>()
        for(i in name.indices){
            h.put(name[i], yearning[i])
        }
        for(i in photo.indices){
            for(j in photo[i]){
                if(h.containsKey(j)){
                    result[i] += h.get(j)!!
                }
            }
        }
        return result
    }
}