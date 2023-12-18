class Solution {
    fun solution(
        wants: Array<String>, numbers: IntArray, discounts: Array<String>
    ): Int {
        var wantSize = 0
        numbers.forEach { number ->
            wantSize += number
        }
        
        val discountMap = HashMap<String, Int>() 
        var result = 0
        discounts.forEachIndexed { index, discount -> 
            // discount 추가 
            if(discountMap.containsKey(discount)) {
                val discountNumber = discountMap.get(discount)!!
                discountMap.put(discount, discountNumber + 1)
            }
            else { // key가 없을 떄 
                discountMap.put(discount, 1)
            }
            
            // 10일 지난 것들 소멸 
            if(index + 1 > wantSize) {
                val disappearFood = discounts[index - wantSize]
                val number = discountMap.get(disappearFood)!!
                discountMap.put(disappearFood, number - 1)
            }
            
            if(index + 1 >= wantSize) {
                if(checkDiscount(wants, numbers, discountMap)) {
                    result += 1
                }
            }
        }
        return result
    }
    
    fun checkDiscount(
        wants: Array<String>, numbers: IntArray, discountMap: HashMap<String, Int>
    ): Boolean { 
        wants.forEachIndexed { index, want ->
            if(discountMap.containsKey(want).not()) {
                return false
            }
            
            if(discountMap.get(want)!! != numbers[index]) {
                return false
            }
        }
        
        return true
    }
}