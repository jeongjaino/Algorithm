class Solution {
    fun solution(expression: String): Long {
        val operater = arrayOf('*', '+', '-')
        val opSet = mutableSetOf<Char>()
        val opList = mutableListOf<Char>()
        val numList = mutableListOf<Long>()
        var num = ""
        for(e in expression){
            if(e in operater){
                opList.add(e)
                opSet.add(e)
                numList.add(num.toLong())
                num = ""
            }
            else{
                num += e
            }
        }
        numList.add(num.toLong())
        var result = 0L
        permutation(opSet.toTypedArray(), opSet.size, opSet.size).forEach{ prList ->
            val temp = calculation(numList.toList(), opList.toList(), prList)
            result = maxOf(result, Math.abs(temp))
        }
        return result
    }
    
    private fun <T> permutation(array: Array<T>, n: Int, r: Int): List<List<T>> {
        val nArray = array.sliceArray(0 until r)
        val visited = BooleanArray(n)
        val list = mutableListOf<List<T>>()
        
        fun recursionPermutation(depth: Int = 0){
            if(depth == r){
                list.add(nArray.toList()); return
            }
        
            array.forEachIndexed{ index, t ->
                if(!visited[index]){
                    visited[index] = true
                    nArray[depth] = t
                    recursionPermutation(depth + 1)
                    visited[index] = false
                }
            }
        }
        
        recursionPermutation()
        return list
    }
    
    fun calculation(numList: List<Long>, opList: List<Char>, prList: List<Char>) 
    : Long{
        val opStack = opList.toMutableList()
        val numStack = numList.toMutableList()
        for(pr in prList){ // 현재 우선 연산자
            val indexList = mutableListOf<Int>() // 제거할 사용한 인덱스
            for(i in opStack.indices){
                if(opStack[i] == pr) { // 연산자가 우선 연산자 인 경우,
                    numStack[i + 1] = operate(numStack[i], numStack[i + 1], opStack[i])
                    indexList.add(i)
                }
            }
            indexList.forEachIndexed { index, it ->
                numStack.removeAt(it - index)
                opStack.removeAt(it - index)
            }
        }
        return numStack.first()
    }
    
    fun operate(a: Long, b: Long, op: Char): Long = when(op)
    {
        '*' -> { a * b }
        '+' -> { a + b }
        '-' -> { a - b }
        else -> { 0 } 
    }
}