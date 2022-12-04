package day01

class Day01(input: String){
    private val allElves =
        input.split("\r\n\r\n")
            .map { oneElf -> oneElf.split("\r\n").sumOf { it.toInt() }}

    fun part1() = allElves.maxOf { it }

    fun part2() = allElves.map { it }.sortedDescending().take(3).sum()
}

fun main() {
    check(Day01(InputReader.testFileAsString("01")).part1() == 24000)
    println(Day01(InputReader.asString("01")).part1())

    check(Day01(InputReader.testFileAsString("01")).part2() == 45000)
    println(Day01(InputReader.asString("01")).part2())
}
