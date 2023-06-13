class Solution {
    fun solution(numbers: IntArray): IntArray {
        // 현재 인덱스의 뒤큰수가 아닌, 현재 밸류의 뒤큰수를 가지는 인덱스를 찾기
        // 스택을 활용, 스택의 마지막 밸류보다 현재 밸류가 더 작다면, 스택의 마지막 밸류의 뒷큰수가
        // 될수 없으므로, 스택에 넣음 / 스택은 자동적으로 내림차순의 형태를 띔 
        // 만약 스택의 마지막 밸류보다 현재 밸류가 더 크다면, 스택의 마지막 밸류의 뒷큰 수가 
        // 현재 밸류가 되고, 남아 있는 스택의 밸류 중에서 현재 밸류보다 작은 수는 뒷큰수가 정해진다.
        
        val stack = mutableListOf<Int>()
        val result = IntArray(numbers.size){ -1 }
        for(i in numbers.indices){
            while(stack.isNotEmpty() && numbers[i] > numbers[stack.last()]){
                result[stack.last()] = numbers[i]
                stack.removeLast()
            }
            stack.add(i)
        }
        return result
    }
}