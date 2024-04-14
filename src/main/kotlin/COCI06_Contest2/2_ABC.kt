package COCI06_Contest2

/**
 * https://dmoj.ca/problem/coci06c2p2
 * 문제
 *  A, B, C 세개의 숫자를 가지고 있다.
 *  순서는 보장되지 않지만 A는 B보다 작고, B는 C보다 작다.
 *  숫자를 주어진 순서대로 정렬하라.
 *
 * Input
 * 첫째 줄에 양수 A, B, C 를 가지고 있다. (순서 X )
 * 세 숫자 모두 100 이하의 숫자.
 * 두번째 줄에 ABC (공백 없이) 주어진다.
 * 이 순서대로 정렬하라.
 *
 * Output
 * 주어진 순서대로 출력
 *
 * 풀이
 * 0. ABC값을 담을 맵 생성
 * 1. 첫째 줄 input 검사
 * 1-1. 첫 번째 숫자 범위 검사 ( 1 ~ 100 )
 * 1-2. 두 번째 숫자 범위 검사 ( 1 ~ 100 )
 * 1-3. 세 번째 숫자 범위 검사 ( 1 ~ 100 )
 * 2. 주어진 숫자를 크기로 정렬
 * 3. A값 맵에 담아주기(제일 작은 수)
 * 4. B값 맵에 담아주기(중간 수)
 * 5. C값 맵에 담아주기(제일 큰 수)
 * 6. 둘째 줄 input 검사
 * 6-1. 주어진 문자열의 길이가 3인지
 * 6-2 ABC인지
 * 7. 주어진 값대로 맵에서 찾아 출력
 */

fun main() {
    val abcMap = mutableMapOf<Char, Int>()
    /**첫째 줄 input 검사*/
    readlnOrNull()?.let {
        /**1-1. 첫 번째 숫자 범위 검사 ( 1 ~ 100 )*/
        val firstNumber = it.trim().split(" ")[0].toIntOrNull()?.let{
            if(it < 1 || it > 100) throw Throwable("invalid range : 1 < R1 < 100 \n your input : $it")
            it
        } ?: throw Throwable("invalid input type : Int \n your input : ${it::class.simpleName}")

        /**1-2. 두 번째 숫자 범위 검사 ( 1 ~ 100 )*/
        val secondNumber = it.trim().split(" ")[1].toIntOrNull()?.let{
            if(it < 1 || it > 100) throw Throwable("invalid range : 1 < R1 < 100 \n your input : $it")
            it
        } ?: throw Throwable("invalid input type : Int \n your input : ${it::class.simpleName}")

        /**1-3. 세 번째 숫자 범위 검사 ( 1 ~ 100 )*/
        val thirdNumber = it.trim().split(" ")[2].toIntOrNull()?.let{
            if(it < 1 || it > 100) throw Throwable("invalid range : 1 < R1 < 100 \n your input : $it")
            it
        } ?: throw Throwable("invalid input type : Int \n your input : ${it::class.simpleName}")
        /**2. 주어진 숫자를 크기로 정렬*/
        val tempAbcArray = arrayOf(firstNumber, secondNumber, thirdNumber).sorted()
        /**3. A값 맵에 담아주기(제일 작은 수)*/
        abcMap['A'] = tempAbcArray[0]
        /**4. B값 맵에 담아주기(중간 수)*/
        abcMap['B'] = tempAbcArray[1]
        /**5. C값 맵에 담아주기(제일 큰 수)*/
        abcMap['C'] = tempAbcArray[2]
    } ?: throw Throwable("invalid input : null")

    /** 6. 둘째 줄 input 검사 (공백없는 알파벳 대문자 A,B,C 인지)*/
    readlnOrNull()?.let{
        /**6-1. 주어진 문자열의 길이가 3인지*/
        if(it.length != 3) throw Throwable("invalid input length : 3 \n your input : ${it.length}")
        /**6-2 ABC인지*/
        if(!(it.contains('A') && it.contains('B') && it.contains('C')))
            throw Throwable("invalid input : uppercase alphabet in ABC : \n your input : $it")
        /**7. 주어진 값대로 맵에서 찾아 출력*/
        print("${abcMap[it[0]]} ${abcMap[it[1]]} ${abcMap[it[2]]}")
    } ?: throw Throwable("invalid input : null")
}