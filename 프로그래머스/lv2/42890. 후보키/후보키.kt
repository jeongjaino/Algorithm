class Solution {
    private val resultKeys = mutableListOf<List<Int>>()
    fun solution(relation: Array<Array<String>>): Int {
        val cols = relation.first().size
        var arr = Array<Int>(cols){ it + 1 }
        for(i in 1 .. cols){
            combination(arr, cols, i).forEach{
                checkKeys(relation, it)
            }
        }
        return resultKeys.size
    }
    
    private fun checkKeys(relation: Array<Array<String>>, keys: List<Int>){
        if(resultKeys.any{ keys.containsAll(it) }) return 
        
        val valueSet = mutableSetOf<List<String>>()
        
        var count = 0
        for(row in relation){
            val tempList = mutableListOf<String>()
            for(key in keys){
                tempList.add(row[key - 1])
            }
            valueSet.add(tempList)
            count ++ 
        }
        if(valueSet.size == relation.size){ // 구분 성공
            resultKeys.add(keys)
        }
    }
    
    private fun <T> combination(array: Array<T>, n: Int, r : Int): List<List<T>>{
        val list = mutableListOf<List<T>>()
        
        fun recursionCombination(depth: Int = 0, index: Int = 0,
            resultArray: Array<T> = array.sliceArray(0 until r)
        ){
            if(depth == r){
                list.add(resultArray.toList()); return
            }
            
            for(arrayIndex in index until n){
                resultArray[depth] = array[arrayIndex]
                recursionCombination(depth + 1, arrayIndex + 1, resultArray)
            }
        }
        recursionCombination()
            return list
    }
}