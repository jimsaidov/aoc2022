package day03

class Day03(private val input: List<String>) {

    fun part1(): Int {
        var totalScore = 0
        input.forEach{ line ->
            val (compartment1, compartment2) = line.chunked(line.length / 2)
            totalScore+=
                compartment1.toSet()
                    .intersect(compartment2.toSet())
                    .sumOf { it.toPriority() }
        }

        return totalScore
    }

    fun part2(): Int {
        var totalScore = 0
        input.chunked(3).map {
            totalScore +=
                it[0].toSet()
                    .intersect(it[1].toSet())
                    .intersect(it[2].toSet())
                    .sumOf { badge -> badge.toPriority() }
        }
        return totalScore
    }
}


fun Char.toPriority(): Int {
    return if (this.isLowerCase()) {
        code - 'a'.code + 1
    } else {
        code - 'A'.code + 27
    }
}

fun main() {
    check(Day03(InputReader.testFileAsList("03")).part1() == 157)
    println(Day03(InputReader.asList("03")).part1())

    check(Day03(InputReader.testFileAsList("03")).part2() == 70)
    println(Day03(InputReader.asList("03")).part2())
}