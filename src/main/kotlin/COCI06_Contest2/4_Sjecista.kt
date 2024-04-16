package COCI06_Contest2

/**
 * https://dmoj.ca/problem/coci06c2p4
 * 문제
 * N개 꼭짓점을 가지고 있는 도형의 대각선들의 교점의 개수를 구하라
 *
 * Input
 * N값 (꼭짓점의 개수) (3이상 100이하)
 *
 * Output
 * 대각선들의 교점 개수
 *
 * 풀이
 * 1. input 검사
 * 1-1. 3이상 100 이하인지 검사
 * 2. nC4 출력
 *
 * 꼭짓점 4개마다 교점의 개수 1개
 * 꼭짓점 N개의 교점의 개수 => n개의 숫자 중에서 4개를 고르는 조합의 수
 * nC4
 * = n! / 4!(n-4)!
 * = n * (n-1) * (n-2) * (n-3) * (n-4) ... / 4 * 3 * 2 * 1 * (n-4) * (n-5) ...
 * = n * (n-1) * (n-2) * (n-3) / (4 * 3* 2 * 1)
 *
 */

fun main() {
    /** 1. input 검사*/
    readlnOrNull()?.toIntOrNull()?.let {
        /**1-1. 3이상 100 이하인지 검사*/
        if(it < 3 || it > 100) throw Throwable("invalid range : 3 <= R1 <= 100 \n your input : $it")
        val N = it
        /**2. nC4 출력*/
        println( N * (N-1) * (N-2) * (N-3) / 24)
    }?: throw Throwable("invalid input Int")
}