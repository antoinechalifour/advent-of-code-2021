package day2

class Submarine {
    var position = Position(0, 0)

    fun pilot(input: String): Int = Course.fromInput(input)
        .computeNextPosition(initialPosition = position)
        .asAnswer()
}

