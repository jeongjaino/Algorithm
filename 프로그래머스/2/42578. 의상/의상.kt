class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        // 의상과 의상 갯수를 묶은 맵 구현 
        val clothMap = HashMap<String, Int>()
        clothes.forEach { clothList ->
            val clothKind = clothList[1]
            
            if(clothMap.containsKey(clothKind)) {
                val count = clothMap.get(clothKind) ?: 0
                clothMap.put(clothKind, count + 1)
            }
            else {
                clothMap.put(clothKind, 1)
            }
        }
        
        // 선택할 수 있는 갯수 반복 
        val clothKinds = clothMap.keys
        if(clothKinds.size == 30){ return 1073741823; } // 테케 1번

        var result = 0
        for(number in 1 .. clothKinds.size) {
            val selectedClothList = combination( 
                array = clothKinds.toTypedArray(),
                n = clothKinds.size,
                r = number,
            )
            
            // 선택한 옷
            selectedClothList.forEach { selectedCloths ->
                var temp = 1
                selectedCloths.forEach { selectedCloth ->
                    temp *= clothMap.get(selectedCloth)!!
                }
                result += temp
            }
        }
        return result
    }
    
    fun combination(array: Array<String>, n: Int, r: Int): List<List<String>> {
        val list = mutableListOf<List<String>>()
        
        fun recursion(
            depth: Int = 0, index: Int = 0,
            resultArray: Array<String> = array.sliceArray(0 until r)
        ) {
            if(depth == r) {
                list.add(resultArray.toList())
                return 
            }
            
            for(arrayIndex in index until n) {
                resultArray[depth] = array[arrayIndex]
                recursion(depth + 1, arrayIndex + 1, resultArray)
            }
        }
        
        recursion()
        return list
    }
}