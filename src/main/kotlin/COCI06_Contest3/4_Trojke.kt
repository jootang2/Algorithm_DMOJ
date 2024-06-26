package COCI06_Contest3

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * https://dmoj.ca/problem/coci06c3p4
 * 문제
 * N * N 정사각형 맵에서 배틀필드놀이를 함.
 * 각 탱크는 주변의 이웃된 네가지 방향으로 한번에 한번 움직일 수 있음.
 * 탱크는 같은 행 또는 같은 열에 있는 탱크를 쏠 수 있음 (장기의 차와 같음)
 * 같은 칸에는 두개의 탱크가 들어갈 수 없음.
 * 게임 하다가 엄마가 밥먹으라고 소리침
 * 탱크들을 다시 재배치 하기로 결심했고, 각 탱크는 다른 행과 열을 지키고 있음 => 각 행, 열에 탱크는 하나씩 있음
 * 그들은 재배치할 때 최소한으로 움직이고싶음.
 *
 * Input
 * N (3 이상 500 이하)
 * N 만큼 R, C 입력됨 => R: row, C:column => 엄마가 소리치기 전의 탱크들의 위치
 * 행은 위에서 아래로, 열은 왼쪽에서 오른쪽으로
 *
 * Output
 * 최소한의 움직임의 수 K 출력
 * 탱크의 번호 (인풋 들어온 순서대로),  방향 출력
 * L : left , R : right, U : up, D : down
 *
 * 풀이
 * 1. input 검사
 * 1-1. N (3이상 50이하) 인지
 * 1-2. R, C (1이상 N이하) 인지
 * 1-3. N만큼 들어오는 동안 중복되는 R, C 가 없는지 (R, C 페어로 봄)
 *
 * 2. 입력받은 좌표를 담을 Map 생성 : key : tank의 번호, values : 좌표
 * 3. (1,1) ~ (N,N) 을 담은 Map 생성
 * 4. tanksMap을 돌면서 각각의 tank가 이동해야할 좌표 구함
 * 4-1. 각각의 tank마다 (1,1) ~ (N,N)을 돌면서 거리가 가장 짧은 좌표 선택
 * 4-2. 현재 탱크의 위치에서 선택한 좌표로 이동하기 위해 움직이는 Pair 를 담을 리스트 생성
 * 5. 리스트의 길이 출력
 * 6. 리스트의 내용 출력
 *
 * 패턴 : 모든 행에 겹치는 숫자가 없어야 함, 모든 행에 겹치는 숫자가 없어야 함
 * 2. 결국 탱크의 결과 위치는 (1,1) , (2,2) , (3,3) ... (N,N) 에 각각 하나씩 있어야 함
 * 3. N만큼 돌면서 제일 가까운 (m,m)의 자리를 찾아감
 * 4. (m,m) 과 (l,l) 이동하는 거리가 같다면 일단 보류
 * 5. 다 배정 후에 남은곳에 배정
 */

fun main() {
}