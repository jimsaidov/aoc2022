package day04

class Day04(input: List<String>) {
    private val splitInput = input.map { it.replace(',', '-').split("-") }

    fun part1(): Int = splitInput.count { fullOverlap(it) }

    fun part2(): Int = splitInput.count { partialOverlap(it) }

    private fun fullOverlap(parts: List<String>) =
        fullOverlap(parts[0].toInt() .. parts[1].toInt(), parts[2].toInt() .. parts[3].toInt())

    private fun fullOverlap(a: IntProgression, b: IntProgression): Boolean =
        ((b.first in a) && (b.last in a)) || ((a.first in b) && (a.last in b))

    private fun partialOverlap(parts: List<String>) =
        (parts[0].toInt() .. parts[1].toInt() intersect parts[2].toInt() .. parts[3].toInt()).isNotEmpty()
}

fun main() {
    check(Day04(InputReader.testFileAsList("04")).part1() == 2)
    println(Day04(InputReader.asList("04")).part1())

    check(Day04(InputReader.testFileAsList("04")).part2() == 4)
    println(Day04(InputReader.asList("04")).part2())
}