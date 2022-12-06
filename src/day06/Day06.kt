package day06

class Day06(private val input: String) {

    fun solve(windowSize: Int): Int =
            input.windowedSequence(windowSize).indexOfFirst {
                it.hasOnlyUniqueCharacters()
            } + windowSize

    private fun String.hasOnlyUniqueCharacters() = toSet().size == length
}

fun main() {
    val day: String = "06"
    val windowSize1 = 4
    val windowSize2 = 14

    check(Day06("mjqjpqmgbljsphdztnvjfqwrcgsmlb").solve(windowSize1) == 7)
    check(Day06("bvwbjplbgvbhsrlpgdmjqwftvncz").solve(windowSize1) == 5)
    check(Day06("nppdvjthqldpwncqszvftbrmjlhg").solve(windowSize1) == 6)
    check(Day06("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").solve(windowSize1) == 10)
    check(Day06("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").solve(windowSize1) == 11)
    println(Day06(InputReader.asString(day)).solve(windowSize1))

    check(Day06("mjqjpqmgbljsphdztnvjfqwrcgsmlb").solve(windowSize2) == 19)
    check(Day06("bvwbjplbgvbhsrlpgdmjqwftvncz").solve(windowSize2) == 23)
    check(Day06("nppdvjthqldpwncqszvftbrmjlhg").solve(windowSize2) == 23)
    check(Day06("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").solve(windowSize2) == 29)
    check(Day06("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").solve(windowSize2) == 26)
    println(Day06(InputReader.asString(day)).solve(windowSize2))
}