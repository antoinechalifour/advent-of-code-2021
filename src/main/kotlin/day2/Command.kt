package day2

import java.lang.Exception

data class Command(val horizontalChange: Int = 0, val depthChange: Int = 0) {
    companion object {
        fun fromInput(input: String): Command {
            val (command, change) = input.parseCommand()

            return when (command) {
                "forward" -> forward(change)
                "down" -> down(change)
                "up" -> up(change)
                else -> throw Exception("Invalid command $input")
            }
        }

        private fun forward(change: Int) = Command(change, 0)
        private fun down(change: Int) = Command(0, change)
        private fun up(change: Int) = Command(0, -change)
    }
}

private fun String.parseCommand() = split(" ").let { Pair(it[0], it[1].toInt()) }