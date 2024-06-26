package COCI06_Contest3

/**
 * https://dmoj.ca/problem/coci06c3p5
 * 문제
 * 오토바이 경기
 * 섬에 N개의 도시들이 있다. 1번부터 N번까지
 * 도시들 사이에는 일방통행인 도로 M개가 있다.
 * 경기는 도시1번에서 시작해서 도시2번에서 끝난다.
 * 루트의 종류는 몇개일까?
 * 경로는 완전히 같지 않으면 다르다고 생각한다.
 *
 * Input
 * N:도시의 개수 ( 1이상 10,000 이하), M: 길의 개수 ( 1이상 100,000 이하) 입력
 * M개의 입력이 주어짐 : 두개의 다른 A, B
 * A도시와 B도시 사이의 길
 * 도시들은 한가지 이상의 길로 이어져있음.
 *
 * Output
 * 경로의 개수를 출력
 * 만약 경로의 수가 9자리보다 크다면 뒤 9자리만 출력
 * 만약 무한하다면 inf 출력
 *
 * 풀이
 * 시작은 1번 도시
 * 끝은 2번 도시
 *
 * 1번 도시에서 갈 수 있는 도시
 * 도착한 도시에서 갈 수 있는 도시
 * ...
 * 2번 도시를 만나면 종료
 * 중간에 쌍방으로 연결된 도시가 있다면 inf 출력
 *
 *
 *
 *
 */