// 세개를 선택하는 경우의 수 조합으로 세 개 
// 반복문 세번으로 구하고, 더한 값을 소수 검증 

class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0

        for (i in nums.indices) {
            for (j in (i + 1) .. nums.lastIndex) {
                for (k in (j + 1) .. nums.lastIndex) {
                    val sum = (nums[i] + nums[j] + nums[k])
                    if(isPrime(sum)) {
                        answer += 1
                    }
                }
            }
        }

        return answer
    }
    
    fun isPrime(value: Int): Boolean {
        if(value == 1) return false
        
        for(element in 2 .. Math.sqrt(value.toDouble()).toInt()) {
            if(value % element == 0) {
                return false
            }
        }
        return true
    }
}