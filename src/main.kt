import java.lang.Math.random

fun main(){
    val n = 10
    println("$n arrays")
    val resArray = arrays(n)
    for (I in 0 until n){
        resArray[I].forEach { it -> print("$it ") }
        println()
    }
}

fun arrays(n: Int): Array<Array<Int>>{

    val minRandom = 1
    val maxRandom = n+n

    val minRandomVal = 1
    val maxRandomVal = 10

    val listArraysLength: Array<Int> = Array (n) {0}

    val result: Array<Array<Int>> = Array(n) {
        Array (0) {0}
    }

    for(I in 0 until n){

        var lenghthArray = 0
        var newLength = true

        while(newLength) {
            lenghthArray = randomValue(minRandom,maxRandom)
            newLength = listArraysLength.any{it -> it == lenghthArray}
        }

        listArraysLength[I]=lenghthArray
        result[I] =  Array (lenghthArray) {
            randomValue(minRandomVal,maxRandomVal)}
    }

    for(I in 0 until n){
        if ((I+1) % 2 == 0)
            result[I] = (result[I].sorted()).toTypedArray()
        else
            result[I] = (result[I].sortedDescending()).toTypedArray()
    }

    return result
}

fun randomValue (
    min: Int,
    max: Int): Int{
    return (random() * (max - min)).toInt() + min
}