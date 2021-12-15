package day2

data class Position(val horizontal: Int, val depth: Int) {
    fun runCommand(command: Command) = Position(
        horizontal = horizontal + command.horizontalChange,
        depth = depth + command.depthChange
    )

    fun asAnswer() = horizontal * depth
}