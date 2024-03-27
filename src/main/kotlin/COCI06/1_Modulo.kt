package COCI06

fun main() {
    println((1..10).fold(mutableSetOf<Int>()){acc, _->
        acc.add(readLine()?.toIntOrNull()?.let{
            if(0 > it || it > 1000) throw Throwable("invalid range 1<=x<=1000: $it")
            it % 42
        } ?: throw Throwable("invalid Int"))
        acc
    }.size)
}