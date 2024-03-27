package COCI06
import kotlin.math.*
/**
 * https://dmoj.ca/problem/coci06c1p2\
 * 문제
 * taxicab 기하학과 일반적인 기하학(유클리드 기하학)이 있다.
 * r값이 주어졌을 때, 각각의 방법으로 원의 넓이를 출력하라.
 *
 * Input
 * R값이 주어진다.
 * 10,000보다 작거나 같은 범위임.
 * 검사 1 : 숫자인지?
 * 검사 2 : 10,000보다 작거나 같은 범위인지?
 *
 * Output (소수점 6자리까지 표현)
 *  첫 번째 줄 : 일반적인 기하학(유클리드 기하학)에서의 R을 이용해 원의 넓이를 구한다.
 *  유클리드 기하학에서의 원의 넓이 : r의 제곱 * PI
 *  두 번째 줄 : taxicab 기하학에서의 R을 이용해 원의 넓이를 구한다.
 *  taxicab 기하학에서의 원의 넓이 : r * r * 2 (이해 안됨... 입력값과 출력값을 보고 추측함)
 *
 *  참고 : 출력값은 오차범위 0.0001이다.
 */
fun main() {
    /**
     * Input
     * R값이 주어진다.
     */
    readlnOrNull()?.toIntOrNull()?.let {
        /**검사 2 : 10,000보다 작거나 같은 범위인지?*/
        if(it > 10000) throw Throwable("invalid range x<=10000: $it")
        /**
         * Output (소수점 6자리까지 표현)
         * 첫 번째 줄 : 일반적인 기하학(유클리드 기하학)에서의 R을 이용해 원의 넓이를 구한다.
         * 유클리드 기하학에서의 원의 넓이 : r의 제곱 * PI
         */
        val euclidean = String.format("%.6f", it.toDouble().pow(2) * PI)
        println(euclidean)
        /**
         * 두 번째 줄 : taxicab 기하학에서의 R을 이용해 원의 넓이를 구한다.
         * taxicab 기하학에서의 원의 넓이 : r * r * 2 (이해 안됨... 입력값과 출력값을 보고 추측함)
         */
        val taxicab = String.format("%.6f", (it * it * 2).toDouble())
        println(taxicab)
        it
    } ?:
    /**검사 1 : 숫자인지?*/
    throw Throwable("invalid Int")
}