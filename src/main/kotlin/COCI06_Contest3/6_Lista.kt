package COCI06_Contest3

/**
 * https://dmoj.ca/problem/coci06c3p6
 * 문제
 * Mirko는 생일 선물로 linked list를 받음
 * list는 N개의 노드가 1번부터 N번까지 있음
 * 두 가지로 움직일 수 있음
 * A : 노드 X를 Y의 앞으로
 * B : 노드 X를 Y의 뒤로
 *
 * 가지고 놀다가 각각의 이동을 종이에 기록
 * Mirko는 최소한으로 움직이면서 초기상태로 움직이고 싶음
 *
 * Input
 *
 * Output
 *
 * 풀이
 * 1. Mirko가 움직인 결과 값을 알아내기
 * 2. 각 자리에서 원래 자리의 숫자가 들어갈 수를 빼줌
 *
 *                                                   (B 2 1) or (A 2 3)           B 4 3
 * 1 3 5 6 4 2 이면                        =>        1 2 3 5 6 4
 *
 * 1 2 3 4 5 6 을 빼줘서                   =>        1 2 3 4 5 6
 *
 * 0 1 2 2 1 4 를 구함(절댓값)             =>        0 0 0 0 1 2
 * 구한 절댓값에서 큰 수부터 원래 자리로 가져다 놓음
 * 위의 예시에서는 4가 가장 크니까 2를 원래 자리로 가져다 놓음
 * 이렇게 반복
 * 만약 큰 값이 중복인 경우에는 최대한 앞의 수를 고르면 됨
 *
 *
 * 좋은 코드란 : 도메인 가역성 => 코드로부터 도메인이 복원되는가?
 * 코드로 부족하면 주석
 * 주석 + 코드 => 정책 문서
 *
 */

/**
 * 1;1
 * 2;1
 * 3;1
 * 4;2
 * 5;3
 */

fun main() {
    val input = readln()
    //node 의 수
    val N = input.split(" ")[0].toIntOrNull()?:throw Throwable("invalid input")
    //옮긴 횟수
    val M = input.split(" ")[1].toIntOrNull()?:throw Throwable("invalid input")
    // 리스트 초기값 생성
    var result = ""
    for(i in 1 .. N){
        result += i.toString()
    }
    println(result)
    for(i in 0 until M){
        val moveInput = readln()
        val move = moveInput.split(" ")[0]
        val moveFirstNumber = moveInput.split(" ")[1]
        val moveSecondNumber = moveInput.split(" ")[2]
        // A인 경우
        if(move == "A"){
            //A (a, b) 인 경우 : b 앞에 a 값 추가, 기존 a 값 삭제
            result = result.replace(moveFirstNumber, "")
            val resultPuzzle1 = result.split("$moveSecondNumber")[0]
            val resultPuzzle2 = result.split("$moveSecondNumber")[1]
            result = resultPuzzle1 + moveFirstNumber + moveSecondNumber + resultPuzzle2
            println(result)
        }
        // B인 경우 : b 뒤에 a 값추가, 기존 a 값 삭제
        else {
            result = result.replace(moveFirstNumber, "")
            val resultPuzzle1 = result.split("$moveSecondNumber")[0]
            val resultPuzzle2 = result.split("$moveSecondNumber")[1]
            result = resultPuzzle1 + moveSecondNumber + moveFirstNumber + resultPuzzle2
            println(result)
        }
    }


    println("last result : $result")

    var initialNumber = ""
    for(i in 1 .. N){
       initialNumber += i.toString()
    }

    println("initialNumber : $initialNumber")

    while(result != initialNumber){
        println("result : ${result}")
        val test = StringBuilder()
        for(i in 0 until N){
            val digit1 = result[i].toInt() - '0'.toInt() // 문자를 숫자로 변환
            val digit2 = initialNumber[i].toInt() - '0'.toInt()

            val diff = Math.abs(digit1 - digit2) // 절댓값 계산
            test.append(diff)
        }
        println("test.toString(): ${test}")
        result = initialNumber
    }







}