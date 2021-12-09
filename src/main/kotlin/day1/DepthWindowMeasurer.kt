package day1

typealias Window = List<Int>

class DepthWindowMeasurer {
    fun measure(logs: String): Int {
        val (window, rest) = makeMeasurements(logs).partition()

        return doMeasure(window, rest)
    }

    private fun doMeasure(currentWindow: Window, rest: List<Int>): Int {
        val (nextWindow, nextRest) = rest.partition()

        return when {
            nextWindow.isIncomplete() -> 0
            nextWindow.isLargerThan(currentWindow) -> doMeasure(nextWindow, nextRest) + 1
            else -> doMeasure(nextWindow, nextRest)
        }
    }

    private fun makeMeasurements(logs: String) = logs.split("\n").map { it.toInt() }
}

private fun Window.isIncomplete() = size < 3

private fun Window.isLargerThan(list: Window) = sum() > list.sum()

private fun List<Int>.partition(): Pair<Window, List<Int>> = Pair(take(3), drop(1))
