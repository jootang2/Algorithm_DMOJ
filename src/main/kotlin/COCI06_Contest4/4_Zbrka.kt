package COCI06_Contest4

/**
 * https://dmoj.ca/problem/coci06c4p4
 * 문제
 * 1과 N 사이에 있는 상수들을 고려하자
 * 쌍으로 된 숫자들이 시퀀스에 랜덤으로 있다.
 * 작은수가 앞, 큰 수가 뒤
 *
 *
 *
 *
 * N개의 길이를 가진 문자열
 * 처음에는 5개 고정 (N개 고정) 초기값 그대로
 * 4개 고정 (N-1개 고정) 초기값 그대로
 * 3개 고정 (N-2개 고정) 초기값 에서 맨 뒷자리 두개만 바꾼 수 : N-1 , N-2
 * 2개 고정 (N-3개 고정)
 * N-3 (N-1, N-2), N-2 (N-3, N-1) , N-2 (N-1, N-3), N-1 (N-3, N-2), N-1(N-2, N-3)
 * ...
 * 0개 고정 (0개 고정)
 * 12345 초기값
 * 12354 N-1자리와 N-2 자리를 바꿈
 * 12435
 * 12453
 * 12534
 * 12543
 * 13245
 * ...
 *
 * 초기값 : 1~N
 *
 * 초기값으로 만들 수 있는 모든 경우의 수 (순열) 생성
 * 생성된 값으로 문제에서 주어진 조건에 맞는지 검사
 * ex) 1432 => (4,3) , (4,2) , (3,2) => 3
 * 1234
 * 1243
 * 1324
 * 1342
 * 1423
 * 1432
 * 2134
 * 2143
 * ...
 * 쌍으로 이뤄진 숫자 중 아프이 숫자가 더 큰 경우의 수가 C 인 경우
 *
 * 순열을 만들 때 모든 순열을 만들지 말고 제약을 걸어줘야 할 듯?
 *
 * => TLE
 */

fun main() {
    val input = readln()

    val N = input.split(" ")[0].toIntOrNull()?:throw Throwable("invalid input : int")
    val C = input.split(" ")[1].toIntOrNull()?:throw Throwable("invalid input : int")

    var initNumberList = mutableListOf<Int>()
    for(i in 1 .. N){
        initNumberList.add(i)
    }
    fun generateAllNumbers(numbers: List<Int>): MutableList<MutableList<Int>> {
        val numberList = mutableListOf<MutableList<Int>>()
        val visited = BooleanArray(numbers.size)
        val currentNumberList = mutableListOf<Int>()

        fun generateList(depth: Int) {
            if (depth == numbers.size) {
                numberList.add(currentNumberList.toMutableList())
                return
            }

            for (i in numbers.indices) {
                if (!visited[i]) {
                    visited[i] = true
                    currentNumberList.add(numbers[i])
                    generateList(depth + 1)
                    currentNumberList.removeAt(currentNumberList.size - 1)
                    visited[i] = false
                }
            }
        }

        generateList(0)
        return numberList
    }
    val sequence = generateAllNumbers(initNumberList)
    var result = 0
    sequence.forEach {
        var count = 0
        for(i in 0 until N){
            for(j in i+1 until N){
                if(it[i] > it[j]) count ++
            }
        }
        if(count == C) result ++
    }
    println(result)
}