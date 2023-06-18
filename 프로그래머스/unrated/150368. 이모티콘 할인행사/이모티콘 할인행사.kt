class Solution {
    private var result = intArrayOf(0, 0)
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        val emoSize = emoticons.size
        val arr = IntArray(emoSize){ 0 }
        permutation(arr, emoticons, users, 0, emoSize)
        return result
    }
    
    private fun permutation(arr: IntArray, emoticons: IntArray, users: Array<IntArray>, depth: Int, r: Int){
        if(depth == r){
            val temp = calculateEmoticons(arr, emoticons, users)
            if(result[0] < temp[0] || (result[0] == temp[0] && result[1] < temp[1])){
                result = temp
            }
            return
        }
        for(i in 1 .. 4){
            arr[depth] = i * 10
            permutation(arr, emoticons, users, depth + 1, r)
        }
    }

    fun calculateEmoticons(percents : IntArray, emoticons: IntArray, users: Array<IntArray>): IntArray{
        val temp = intArrayOf(0, 0)
        for(user in users){
            var price = 0
            emoticons.forEachIndexed{ index, value ->
                if(user[0] <= percents[index]){
                    price += (value * (100 - percents[index]) / 100)
                }
            }
            if(user[1] <= price){ // 가격이 리미트 이상인 경우
                temp[0] += 1
            }
            else{ // 가격이 리미트 미만인 경우
                temp[1] += price
            }
        }
        return temp
    }
}