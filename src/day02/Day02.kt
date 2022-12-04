package day02

class Day02(private val input: List<String>) {
    private val DRAW = 3
    private val WIN = 6

    private val points = mapOf('X' to 1, 'Y' to 2, 'Z' to 3)
    private val drawPoints = mapOf("A X" to 4, "B Y" to 5, "C Z" to 6)
    private val lossPoints = mapOf("A Z" to 3, "B X" to 1, "C Y" to 2)

    fun part1(): Int {
        var totalScore = 0
        input.forEach {
            totalScore += when (it) {
                in lossPoints -> lossPoints.getValue(it)
                in drawPoints -> drawPoints.getValue(it)
                else -> points.getValue(it[2]) + WIN
            }
        }
        return totalScore
    }

    private val complementLoss = mapOf('A' to 'Z', 'B' to 'X', 'C' to 'Y')
    private val complementDraw = mapOf('A' to 'X', 'B' to 'Y', 'C' to 'Z')
    private val complementWin = mapOf('A' to 'Y', 'B' to 'Z', 'C' to 'X')

    fun part2(): Int {
        var totalScore = 0
        input.forEach{
            totalScore += when(it[2]){
                'X' -> points.getValue(complementLoss.getValue(it[0]))
                'Y' -> points.getValue(complementDraw.getValue(it[0])) + DRAW
                else -> points.getValue(complementWin.getValue(it[0])) + WIN
            }
        }
        return totalScore
    }
}

fun main() {
    check(Day02(InputReader.testFileAsList("02")).part1() == 15)
    println(Day02(InputReader.asList("02")).part1())

    check(Day02(InputReader.testFileAsList("02")).part2() == 12)
    println(Day02(InputReader.asList("02")).part2())
}