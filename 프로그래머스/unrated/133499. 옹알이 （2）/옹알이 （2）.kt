class Solution {
    fun solution(babbling: Array<String>): Int {
        // b의 string 최소, 최댓값을 구한다음.
        // 배블링의 원소하나씩 최소 ~ 최댓값까지 슬라이싱한다음. 해당 값이 있으면 다음 번째로 넘어감
        // 이전의 값 저장하고, 해당 값인지도 대조해야 함.
        val b = arrayOf("aya", "ye", "woo", "ma")
        var result = 0
        for(i in babbling){
            var comparator = ""
            var pre = ""
            for(j in i.indices){
                comparator += i[j]
                if(b.contains(comparator) && comparator != pre){
                    pre = comparator
                    comparator = ""
                    if(j == i.lastIndex){
                        result += 1
                    }
                }
                if(comparator.length > 3){
                    break
                }
            }
        }
        return result
    }
}