fun main(args: Array<String>) {
    val s1 = readLine()!!
    for(i in s1.indices){
        if(s1[i].isUpperCase()){
            print(s1[i].lowercaseChar())
        }else{
            print(s1[i].uppercaseChar())
        }
    }
}