package day07

class Day07(private val input: List<String>) {

    private data class File(val name: String, val size: Double)

    private data class Directory(
        val name: String,
        val parent: Directory?,
        val dirs: MutableList<Directory> = mutableListOf(),
        val files: MutableList<File> = mutableListOf()
    ) {
        private fun calculateSize() : Double =
            dirs.sumOf { it.calculateSize() } + files.sumOf{ it.size }

        val size : Double by lazy {
            calculateSize()
        }
    }

    private fun getDirectorySizeList(input: List<String>): List<Double> {
        var currentDir = Directory("/", null)
        val dirSizes = mutableListOf<Double>()

        input.drop(1).forEach { line ->
            when {
                line.startsWith("$ cd") -> {
                    val dirName = line.split(" ")[2]
                    currentDir = if (dirName == "..") {
                        dirSizes.add(currentDir.size)
                        currentDir.parent!!
                    } else {
                        currentDir.dirs.first { it.name == dirName }
                    }
                }

                line.startsWith("dir") -> currentDir.dirs.add(line.createDirectory(currentDir))

                line[0].isDigit() -> currentDir.files.add(line.createFile())
                else -> {}
            }
        }

        while (true) {
            dirSizes.add(currentDir.size)
            if (currentDir.name == "/") {
                break
            }
            currentDir = currentDir.parent!!
        }

        return dirSizes
    }

    private fun String.createDirectory(parent: Directory) = Directory(split(" ")[1], parent)

    private fun String.createFile() = with(split(" ")) {
        File(this.last(), this.first().toDouble())
    }

    private fun List<Double>.getTotalLessThan(other: Double) = filter { it < other }.sum()

    fun part1(): Int = getDirectorySizeList(input).getTotalLessThan(100000.00).toInt()

    fun part2(): Int  = with (getDirectorySizeList(input)) {
        this.sorted().first{it >= (30000000.00 - (70000000.00 - this.max()))}.toInt()
    }

}

fun main() {
    val day = "07"

    check(Day07(InputReader.testFileAsList(day)).part1() == 95437)
    println(Day07(InputReader.asList(day)).part1())

    check(Day07(InputReader.testFileAsList(day)).part2() == 24933642)
    println(Day07(InputReader.asList(day)).part2())
}