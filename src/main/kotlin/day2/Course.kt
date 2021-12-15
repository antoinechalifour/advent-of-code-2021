package day2

class Course(private val commands: List<Command>) {

    companion object {
        fun fromInput(input: String) =
            input.split("\n")
                .map { Command.fromInput(it) }
                .let { Course(it) }
    }

    fun computeNextPosition(initialPosition: Position) = commands
        .fold(initialPosition) { position, command -> position.runCommand(command) }
}
