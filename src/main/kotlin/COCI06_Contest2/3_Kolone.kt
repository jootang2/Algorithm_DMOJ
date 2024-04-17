package COCI06_Contest2
/**
 * https://dmoj.ca/problem/coci06c2p3
 * 문제
 *  반대방향으로 가는 두 줄의 개미들이 만나면 점프해서 자리를 바꿔가며 이동한다.
 *  T초 후에 개미들의 순서를 구하라.
 *
 * Input
 * 첫째 줄에 N1, N2 가 주어진다. - 첫째 줄 개미의 숫자, 둘째 줄 개미의 숫자
 * 그 다음 두 줄은 개미들의 순서를 나타낸다. 각각의 개미들의 알파벳은 유일하다.
 * 마지막 줄은 숫자 T (0 이상 50 이하)
 *
 * Output
 * T초 후에 개미들의 순서를 한 줄로 표현하라.
 * 첫째 줄의 개미는 왼쪽에서 오고 둘째 줄의 개미은 오른쪽에서 온다.
 *
 * 풀이
 * 1. input 검사
 * 1-1. N1 (첫째 줄 개미의 숫자) 검사 : 숫자인지, 양수인지
 * 1-2. N1 (둘째 줄 개미의 숫자) 검사 : 숫자인지, 양수인지
 * 1-3. 첫째 줄 개미의 문자열 검사 : 길이가 N1인지, 알파벳 대문자인지
 * 1-4. 둘째 줄 개미의 문자열 검사 : 길이가 N2인지, 알파벳 대문자인지
 * 1-5. T 검사 : (0이상 50이하)
 *
 * 2. T초 후 바뀐 개미들의 순서를 담을 (N1 + N2) 사이즈 빈 배열 생성
 *
 * 3. T초 후 첫째 줄 개미들의 바뀐 자리를 빈 배열에 담아줌
 * 3-1. 첫째 줄 개미은 왼쪽에서 옴 : 입력받은 값을 반대로 생각해야함
 * 3-2. T초 후 자리가 바뀌는 개미인지 아니인지 분기
 * 3-3. 자리가 바뀌는 개미
 * 3-3-1. 바뀐 자리가 본인이 갈 수 있는 최대 인덱스를 넘어가는 경우
 * 3-3-2. 최대 인덱스 이하인 경우
 * 3-4. 자리가 바뀌지 않는 개미라면 그대로
 *
 * 4. T초 후 둘째 줄 개미들의 바뀐 자리를 빈 배열에 담아줌
 * 4-1. T초 후 자리가 바뀌는 개미인지 아니인지 분기
 * 4-2. 자리가 바뀌는 개미라면 바뀌는 자리 구하기
 * 4-3. 자리가 바뀌지 않는 개미라면 그대로
 *
 * 5. 개미들의 자리를 담아준 배열 출력
 *
 * 3 3
 * 0 CBADEF
 * 1 CBDAEF
 * 2 CDBEAF
 * 3 DCEBFA
 * 4 DECFBA
 * 5 DEFCBA
 *
 *    왼 -> 오른
 *    T         움직이지 않는 INDEX    움직이는 INDEX
 *    0        0 ~ N1-1 (안움직임)        -
 *    1        0 ~ N1-1-1 (안움직임)        N1-1
 *    2        0 ~ N1-1-2 (안움직임)        N1-2 ~ N1-1
 *    3        0 ~ N1-1-3 (안움직임)        N1-3 ~ N1-1
 *    T        0 ~ N1-1-T (안움직임)        N1-T ~ N1-1
 *    오른 -> 왼
 *    T         움직이지 않는 INDEX    움직이는 INDEX
 *    0        N1 ~ N1+N2-1 (안움직임)        -
 *    1        N1+1 ~ N1+N2-1 (안움직임)    N1
 *    2        N1+2 ~ N1+N2-1 (안움직임)    N1 + 1
 *    3        N1+3 ~ N1+N2-1 (안움직임)    ...
 *    T        N1+T ~ N1+N2-1 (안움직임)    ...
 */
fun main() {
    /**1. input 검사*/
    readlnOrNull()?.let{
        /**1-1. N1 (첫째 줄 개미의 숫자) 검사 : 숫자인지, 양수인지*/
        val N1 = it.trim().split(" ")[0].toIntOrNull()?.let {
            if(it <= 0) throw Throwable("invalid range : N1 > 0 \n your input : $it")
            it
        }?: throw Throwable("invalid input type : Int \n your input : ${it::class.simpleName}")

        /**1-2. N1 (둘째 줄 개미의 숫자) 검사 : 숫자인지, 양수인지*/
        val N2 = it.trim().split(" ")[1].toIntOrNull()?.let {
            if(it <= 0) throw Throwable("invalid range : N1 > 0 \n your input : $it")
            it
        }?: throw Throwable("invalid input type : Int \n your input : ${it::class.simpleName}")

        /**1-3. 첫째 줄 개미의 문자열 검사 : 길이가 N1인지, 알파벳 대문자인지*/
        val firstLineAnt = readlnOrNull()?.let{
            val regex = Regex("^[A-Z]+$")
            if(!it.matches(regex)) throw Throwable("invalid input regex : only uppercase alphabet \n your input : $it ")
            if(it.length != N1) throw Throwable("invalid input length : $N1 \n your input length: ${it.length}")
            it
        }?: throw Throwable("invalid input : null")

        /**1-4. 둘째 줄 개미의 문자열 검사 : 길이가 N2인지, 알파벳 대문자인지*/
        val secondLineAnt = readlnOrNull()?.let{
            val regex = Regex("^[A-Z]+$")
            if(!it.matches(regex)) throw Throwable("invalid input regex : only uppercase alphabet \n your input : $it ")
            if(it.length != N2) throw Throwable("invalid input length : $N2 \n your input length: ${it.length}")
            it
        }?: throw Throwable("invalid input : null")

        /**1-5. T 검사 : (0이상 50이하)*/
        val T = readlnOrNull()?.toIntOrNull()?.let{
            if(it < 0 || it > 50) throw Throwable("invalid range : 0 < T < 50 \n your input : $it")
            it
        }?: throw Throwable("invalid input : null")

        /**2. T초 후 바뀐 개미들의 순서를 담을 (N1 + N2) 사이즈 빈 배열 생성*/
        val resultArray = CharArray(N1 + N2)

        /**3. T초 후 첫째 줄 개미들의 바뀐 자리를 빈 배열에 담아줌*/
        /**3-1. 첫째 줄 개미은 왼쪽에서 옴 : 입력받은 값을 반대로 생각해야함*/
        firstLineAnt.reversed().forEachIndexed { index, c ->
            val newIndex =
                /**3-2. T초 후 자리가 바뀌는 개미인지 아니인지 분기 (T + INDEX > N1 -1 이면 움직이는 INDEX)*/
                if(T + index > N1 - 1) {
                    /**3-3. 자리가 바뀌는 개미*/
                    /**3-3-1. 바뀐 자리가 본인이 갈 수 있는 최대 인덱스를 넘어가는 경우 (최대 인덱스 : N1+N2-1-(N1-1-INDEX))*/
                    if(index + T - (N1 - 1 - index)> N1+N2-1-(N1-1-index)) N1+N2-1-(N1-1-index)
                    /**3-3-2. 최대 인덱스 이하인 경우 (바뀐 인덱스 : INDEX + T - (N1 - 1 - INDEX)) */
                    else index + T - (N1 - 1 - index)
                }
                /**3-4. 자리가 바뀌지 않는 개미라면 그대로*/
                else index
            resultArray[newIndex] = c
        }

        /*** 4. T초 후 둘째 줄 개미들의 바뀐 자리를 빈 배열에 담아줌*/
        secondLineAnt.forEachIndexed { index, c ->
            val realIndex = index + N1
            val newIndex =
                /*** 4-1. T초 후 자리가 바뀌는 개미인지 아니인지 분기*/
                if((realIndex - T) < N1) {
                    /*** 4-2. 자리가 바뀌는 개미라면 바뀌는 자리 구하기*/
                    if(realIndex - T + (index)< 0 + (realIndex - N1)) 0 + (realIndex - N1)
                    else realIndex - T + (index)
                }
                /*** 4-3. 자리가 바뀌지 않는 개미라면 그대로*/
                else realIndex
            resultArray[newIndex] = c
        }

        /*** 5. 개미들의 자리를 담아준 배열 출력*/
        resultArray.forEach {  ant -> print("$ant") }

    }?:throw Throwable("invalid input : null")
}
//fun main() {
//    // 숫자 입력
//    val n = readln().toInt()
//    val m = readln().toInt()
//
//    // 첫째줄개미알파벳
//    val firstLineAnt = readln()
//    // 둘째줄개미알파벳
//    val secondLineAnt = readln()
//
//    //개미배열 0초일 떄 생성
//    val zeroSecondOrder = firstLineAnt + secondLineAnt
//    val antOrderArray = mutableListOf<Char>()
//    //개미 리스트 생성
//    zeroSecondOrder.forEach { antOrderArray.add(it) }
//
//    val resultArray = CharArray(n + m)
//    resultArray.forEachIndexed { index, c ->
//        println("[resultArray]index : $index value : $c")
//    }
//    //T초 후
//    val T = readln().toInt()
//    //첫번재 줄
//    firstLineAnt.reversed().forEachIndexed { index, c ->
//        val newIndex =
//            if(T+index > firstLineAnt.length-1) {
//                println("움직일 시간")
//                if(index + T - (firstLineAnt.length-1 - index) > n+m-1-(firstLineAnt.length-1 - index)) n+m-1-(firstLineAnt.length-1 - index) else index + T - (firstLineAnt.length-1 - index)
//            }
//            else index
//        println("index : $index , newIndex : $newIndex")
//        // 1초
//        resultArray[
//           newIndex
//        ] = c
//
//    }
//    //두번재 줄
//    secondLineAnt.forEachIndexed { index, c ->
//        val realIndex = index + n
//        val newIndex =
//            if(T >= index + (index)) {
//                println("움직일 시간")
//                if(realIndex - T + index < 0 ) 0 else realIndex-T + index
//            }
//            else realIndex
//        println("realIndex : $realIndex , newIndex : $newIndex")
//        // 1초
//        resultArray[
//            newIndex
//        ] = c
//    }
//
//    resultArray.forEachIndexed { index, c ->
//        println("[resultArray]index : $index value : $c")
//    }
//
//}