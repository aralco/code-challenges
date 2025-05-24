import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KTraining1Test {

    @Test
    fun testSolution() {
        val kTraining1 = KTraining1()

        // Test case 1: General case
        val input1 = intArrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5)
        val expected1 = 8 // Example expected result
        assertEquals(expected1, kTraining1.solution(input1))

        // Test case 2: Empty array
        val input2 = intArrayOf()
        val expected2 = 0
        assertEquals(expected2, kTraining1.solution(input2))

        // Test case 3: Single element
        val input3 = intArrayOf(7)
        val expected3 = 0
        assertEquals(expected3, kTraining1.solution(input3))

        // Test case 4: All elements are the same
        val input4 = intArrayOf(5, 5, 5, 5)
        val expected4 = 0
        assertEquals(expected4, kTraining1.solution(input4))

        // Test case 5: Decreasing order
        val input5 = intArrayOf(9, 7, 5, 3, 1)
        val expected5 = 0
        assertEquals(expected5, kTraining1.solution(input5))
    }
}
