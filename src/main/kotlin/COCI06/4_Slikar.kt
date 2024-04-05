package COCI06

/**
 * https://dmoj.ca/problem/coci06c1p4
 * 문제
 * 가능한 빨리 Beaver의 동굴로 안전하게 가자.
 *
 * 숲에서 빈 지역은 '.' 표시
 * 침수된 지역은 '*' 표시
 * 바위는 'X' 표시
 * Beaver의 동굴은 'D' 표시
 * 나의 위치는 'S' 표시
 *
 * 매 분마다 인접한 상하좌우로 움직일 수 있음.
 * 매 분마다 침수된 지역은 비어있는 지역이 모두 침수될 때 까지 인접한 빈 지역으로 확장 됨
 * 나는 바위를 가로지를 수 있음
 * 나는 침수된 지역은 지나가지 못함
 * Beaver의 동굴은 침수되지 않음
 *
 * 안전하게 Beaver의 동굴로 가는 최단 거리를 구하라.
 *
 * Note : 나는 같은 분에 침범되는 지역을 지나가지 못함
 *
 * Input
 * 첫 째줄에는 두 개의 숫자 입력 - 50보다 작거나 같다. (가로의 길이와 세로의 길이)
 * 이 맵에는 'D', 'S' 는 무조건 한 개 포함되어 있다.
 *
 * Output
 * Beaver의 동굴로 안전하게 갈 수 있는 최단 시간을 출력
 * 만약 불가능한 경우에는 "KAKTUS" 출력
 *
 * 풀이
 * 1. input 검사
 * 1-1. 숫자인지 검사
 * 1-2. 50보다 작거나 같은지 검사
 * 2. 맵 생성 - 빈 2차원 배열 생성
 * 3. 맵 입력 검사
 * 3-1. 입력이 column의 수만큼 들어오는지 검사
 * 3-2. '.', '*', 'X', 'D', 'S' 외에 다른 값이 있는지 검사
 * 4. 맵 검사
 * 4-1. 맵에 'S' 와 'D'가 한 개 포함되어 있는지 검사
 */
fun main() {
    /**1. input 검사*/
    readlnOrNull()?.let{
        /**1-1. 숫자인지*/
        val row = it.trim().split(" ")[0].toIntOrNull()?.let {
            /**1-2. 50보다 작거나 같은지*/
            if(it > 50) throw Throwable("invalid range x<=50: $it")
            it
        } ?: throw Throwable("invalid input type Int : ${it::class.simpleName}")

        /**1-1. 숫자인지*/
        val column = it.trim().split(" ")[1].toIntOrNull()?.let {
            /**1-2. 50보다 작거나 같은지*/
            if(it > 50) throw Throwable("invalid range x<=50: $it")
            it
        } ?: throw Throwable("invalid input type Int : ${it::class.simpleName}")

        /** 2. 맵 생성 - 빈 2차원 배열 생성 */
        var map = Array(row) { arrayOfNulls<Any>(column) }

        /**3. 맵 입력받기*/
        for(i in 0 until row){
            readlnOrNull()?.let{
                /** 3-1. 입력이 column의 수만큼 들어오는지 검사*/
                if(it.trim().length != column) throw Throwable("invalid map input length x=$column : $it")

                val regex = Regex("[^.*XDS]")

                /** 3-2. '.', '*', 'X', 'D', 'S' 외에 다른 값이 있는지 검사 */
                if(!regex.matches(it)) throw Throwable("invalid map element : $it")

            } ?: throw Throwable("invalid map input : null")
        }
    } ?: throw Throwable("invalid input : null")

}
