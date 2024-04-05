package COCI06_Contest2

/**
 * https://dmoj.ca/problem/coci06c2p1
 * 문제
 * S : 두 숫자의 합을 2로 나눈 값
 * 두 숫자 (R1, R2) 중 R2를 모를 때 R2의 값을 구하라
 *
 * Input
 * R1과 S의 값이 주어짐
 * 범위 : -1000 ~ 1000
 *
 * Output
 * R2
 *
 * 풀이
 * 1. input 검사
 * 1-1 . R1의 범위 검사 ( -1000 ~ 1000 )
 * 1-2 . S의 범위 검사 ( -1000 ~ 1000 )
 * 2. R2 = 2S - R1 공식 사용해서 R2 출력
 */

fun main() {
    /**1. input 검사*/
    readlnOrNull()?.let {
        /**1-1 . R1의 범위 검사 ( -1000 ~ 1000 )*/
        val R1 = it.trim().split(" ")[0].toIntOrNull()?.let{
            if(it < -1000 || it > 1000) throw Throwable("invalid range : -1000 < R1 < 1000 \n your input : $it")
            it
        } ?: throw Throwable("invalid input type : Int \n your input : ${it::class.simpleName}")

        /**1-2 . S의 범위 검사 ( -1000 ~ 1000 )*/
        val S = it.trim().split(" ")[1].toIntOrNull()?.let{
            if(it < -1000 || it > 1000) throw Throwable("invalid range : -1000 < S < 1000 \n your input : $it")
            it
        } ?: throw Throwable("invalid input type : Int \n your input : ${it::class.simpleName}")

        /**2. R2 = 2S - R1 공식 사용해서 R2 출력*/
        val R2 = 2 * S - R1
        println(R2)
    } ?: throw Throwable("invalid input : null")
}