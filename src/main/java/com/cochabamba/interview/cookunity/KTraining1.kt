class KTraining1 {

    fun main(args: Array<String>) {
        val A = intArrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5)
        println(solution(A)) // Example usage
    }

    fun solution(A: IntArray): Int {
        val n = A.size
        if (n == 0) return 0

        val left = IntArray(n)
        val right = IntArray(n)

        left[0] = A[0]
        for (i in 1 until n) {
            left[i] = Math.max(left[i - 1], A[i])
        }

        right[n - 1] = A[n - 1]
        for (i in n - 2 downTo 0) {
            right[i] = Math.max(right[i + 1], A[i])
        }

        var maxDiff = 0
        for (i in 0 until n - 1) {
            maxDiff = Math.max(maxDiff, left[i] - right[i + 1])
        }

        return maxDiff
    }


}
