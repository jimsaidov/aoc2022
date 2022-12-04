import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

object InputReader {
    fun asString(day: String) = inputFile(day).readText()
    fun asList(day: String) = inputFile(day).readLines()

    private fun inputFile(day: String): File {
        return File("src\\Day$day", "Day$day.txt")
    }

    fun testFileAsString(day: String) = testFile(day).readText()
    fun testFileAsList(day: String) = testFile(day).readLines()

    private fun testFile(day: String): File {
        return File("src\\Day$day", "Day${day}_test.txt")
    }
}

fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
