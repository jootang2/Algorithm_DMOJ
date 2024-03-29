package COCI06


/**
 * https://dmoj.ca/problem/coci06c1p3
 * 문제
 * '피터팬 프레임'은 다이아몬드 형태로 문자 주변을 감싸는 프레임
 * '웬디 프레임'은 3의 배수인 문자에 적용되는 프레임
 * '웬디 프레임'은 피터팬 프레임을 덮어쓴다.
 *
 * Input
 * 최대 15자의 알파벳 대문자
 *
 * Output
 * 5줄로 '피터팬 프레임', '웬디 프레임'을 사용해서 출력
 *
 * 풀이
 * 1. input 검사
 * 1-1. input의 모든 공백 제거
 * 1-2. 검사 1 : 알파벳 대문자인지?
 * 1-3. 검사 2 : 15자를 넘어가는지?
 * 2. 프레임에 맞게 5줄 출력 -> 5번 반복
 * 3. 문자의 개수만큼 반복
 * 4. 문자의 순서가 3의 배수인 경우 ( 웬디 프레임 )
 * 4-1. 문자가 마지막 문자인 경우
 * 4-2. 문자가 마지막 문자가 아닌 경우
 * 5. 문자의 순서가 3의 배수가 아닌 경우 ( 피터팬 프레임 )
 * 5-1. 문자가 마지막 문자인 경우
 * 5-1-1. 첫 번째 순서가 아니고, 웬디 프레임 다음 순서인 경우 ( 웬디 프레임이 피터팬 프레임을 덮음)
 * 5-1-2. 일반적인 피터팬 프레임인 경우
 * 5-2 문자가 마지막 문자가 아닌 경우
 * 5-2-1. 첫 번째 순서가 아니고, 웬디 프레임 다음 순서인 경우 ( 웬디 프레임이 피터팬 프레임을 덮음)
 * 5-2-2. 일반적인 피터팬 프레임인 경우
 * 6. 줄 마다 개행
 *
 */

fun main() {
    /**
     * 1. input 검사
     * 1-1. input의 모든 공백 제거
     */
    readlnOrNull()?.replace("\\s+".toRegex(), "")?.let {
        /**1-2. 검사 1 : 알파벳 대문자인지?*/
        val regex = Regex("^[A-Z]+$")
        if (regex.matches(it)) {
            /** 검사 2 : 15자를 넘어가는지?*/
            if(it.length > 15) throw Throwable("invalid input : length range : x<=15: $it")
            /** 2. 프레임에 맞게 5줄 출력 -> 5번 반복*/
            for(i in 1 .. 5){
                /**3. 문자의 개수만큼 반복*/
                it.forEachIndexed { index, char->
                    /**문자의 순서*/
                    val count = index + 1
                    /** 4. 문자의 순서가 3의 배수인 경우 ( 웬디 프레임 )*/
                    if(count % 3 == 0) {
                        /** 4-1. 문자가 마지막 문자인 경우*/
                        if(count == it.length) {
                            if(i == 1) print("..*..")
                            if(i == 2) print(".*.*.")
                            if(i == 3) print("*.$char.*")
                            if(i == 4) print(".*.*.")
                            if(i == 5) print("..*..")
                        }
                        /** 4-2. 문자가 마지막 문자가 아닌 경우*/
                        else {
                            if(i == 1) print("..*.")
                            if(i == 2) print(".*.*")
                            if(i == 3) print("*.$char.")
                            if(i == 4) print(".*.*")
                            if(i == 5) print("..*.")
                        }
                    }
                    /** 5. 문자의 순서가 3의 배수가 아닌 경우 ( 피터팬 프레임 )*/
                    else {
                        /** 5-1. 문자가 마지막 문자인 경우*/
                        if(count == it.length) {
                            if(i == 1) print("..#..")
                            if(i == 2) print(".#.#.")
                            if(i == 3) {
                                /** 5-1-1. 첫 번째 순서가 아니고, 웬디 프레임 다음 순서인 경우 ( 웬디 프레임이 피터팬 프레임을 덮음)*/
                                if(count % 3 == 1 && count != 1) print("*.$char.#")
                                /** 5-1-2. 일반적인 피터팬 프레임인 경우*/
                                else print("#.$char.#")
                            }
                            if(i == 4) print(".#.#.")
                            if(i == 5) print("..#..")
                        }
                        /** 5-2 문자가 마지막 문자가 아닌 경우*/
                        else {
                            if(i == 1) print("..#.")
                            if(i == 2) print(".#.#")
                            if(i == 3) {
                                /** 5-2-1. 첫 번째 순서가 아니고, 웬디 프레임 다음 순서인 경우 ( 웬디 프레임이 피터팬 프레임을 덮음)*/
                                if(count % 3 == 1 && count != 1) print("*.$char.")
                                /** 5-2-2. 일반적인 피터팬 프레임인 경우*/
                                else print("#.$char.")
                            }
                            if(i == 4) print(".#.#")
                            if(i == 5) print("..#.")
                        }
                    }
                }
                /** 6. 줄 마다 개행*/
                println()
            }
        } else throw Throwable("invalid input : not uppercase alphabet: $it")
    } ?: Throwable("invalid input : null")
}
