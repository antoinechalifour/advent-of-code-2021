package day1

class DepthMeasurer {
    fun measure(logs: String): Int {
        val (head, rest) = logs.split("\n").map { it.toInt() }.split()

        return doMeasure(head, rest)
    }

    private fun doMeasure(current: Int, tail: List<Int>): Int {
        val (nextHead, nextRest) = tail.split()
        val iterationValue = if (nextHead > current) 1 else 0

        if (nextRest.isEmpty()) return iterationValue

        return iterationValue + doMeasure(nextHead, nextRest)
    }
}

private fun <E> List<E>.split() = Pair(first(), drop(1))
