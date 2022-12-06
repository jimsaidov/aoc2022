package day05

class Day05(private val input: List<String>) {

    private data class MoveInstruction(val amount: Int, val fromIndex: Int, val toIndex: Int)

    private val moveInstructions: List<MoveInstruction> =
        input.drop(input.indexOf("") + 1)
            .map { row ->
                row.split(" ").let { parts ->
                    MoveInstruction(parts[1].toInt(), parts[3].toInt() - 1, parts[5].toInt() - 1)
                }
            }

    private val crateStacks: List<MutableList<Char>> by lazy {
        val crateStackRows = input.takeWhile { it.contains('[') }
        (1..crateStackRows.last().length step 4).map { index ->
            crateStackRows
                .mapNotNull { it.getOrNull(index) }
                .filter { it.isUpperCase() }
                .toMutableList()
        }
    }

    private fun moveCrates(isOneByOne: Boolean){
        moveInstructions.forEach { (amount, fromIndex, toIndex) ->
            val toMoveCrates = crateStacks[fromIndex].take(amount)
            repeat(amount) { crateStacks[fromIndex].removeFirst() }
            crateStacks[toIndex].addAll(0, if (isOneByOne) toMoveCrates.reversed() else toMoveCrates)
        }
    }

    private fun moveAndGetTop(isOneByOne: Boolean): String {
        moveCrates(isOneByOne)
        return crateStacks.map { it.first() }.joinToString("")
    }

    fun part1(): String = moveAndGetTop(true)

    fun part2(): String = moveAndGetTop(false)
}



fun main() {
    val day: String = "05"

    check(Day05(InputReader.testFileAsList(day)).part1() == "CMZ")
    println(Day05(InputReader.asList(day)).part1())

    check(Day05(InputReader.testFileAsList(day)).part2() == "MCD")
    println(Day05(InputReader.asList(day)).part2())
}