package COCI06_Contest5

/**
 * https://dmoj.ca/problem/coci06c5p4
 *
 * 문제
 *
 * 게임을 진행한 횟수 , 이긴 횟수, 비긴 횟수, 진 횟수, 총 얻은 포인트
 *
 * 이김 : 3점
 * 비김 : 1점
 *
 * 각 팀들은 연관이 없음
 *
 *
 * input
 * 첫째 줄 : N : 팀의 수
 *
 * output
 * ?을 채운 결과값
 *
 * 풀이
 *
 * G:게임을 진행한 횟수 , W:이긴 횟수, D:비긴 횟수, L:진 횟수, P:총 얻은 포인트
 *
 * G = W + D + L
 * W = G - D - L
 * D = G - W - L
 * L = G - W - D
 * P = 3 * W + D
 *
 * */

fun main() {
    /**1. 팀 수 입력*/
    val N = readln().toIntOrNull()?:throw Throwable("invalid input - int")

    var result = ""

    /**2. N개의 팀만큼 반복*/
    for(i in 0 until N) {
        val input = readln()
        /**3. ?인 점수는 0으로 변환*/
        val (G, W, D, L, P)
        = input.split(" ").map { if (it == "?") 0 else it.toIntOrNull() ?: throw Throwable("invalid input - int") }

        val resultG = if(G == 0) W + D + L else G

        result += "$resultG $W $D $L $P\n"
    }
    println(result)
}