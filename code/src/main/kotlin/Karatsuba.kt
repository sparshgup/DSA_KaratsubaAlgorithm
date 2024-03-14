import kotlin.math.ceil
import kotlin.math.log10
import kotlin.math.abs
import kotlin.math.pow

class Karatsuba {

    /**
     * Performs multiplication using the Karatsuba algorithm.
     *
     * @param num1 The Long number 1 to multiply.
     * @param num2 The Long number 2 to multiply.
     * @return The product of num1 and num2.
     */
    fun multiply(num1: Long, num2: Long): Long {
        // fall back to traditional multiplication if num < 100
        if (num1 < 100 || num2 < 100)
            return num1 * num2

        // Calculates the size of the numbers
        val m = maxOf(sizeBase10(num1), sizeBase10(num2))
        val m2 = ceil(m.toDouble() / 2).toInt()

        // Split the digit sequences in the middle
        val (high1, low1) = splitAt(num1, m2)
        val (high2, low2) = splitAt(num2, m2)

        // 3 recursive calls made to numbers approximately half the size
        val z0 = multiply(low1, low2)
        val z1 = multiply(low1 + high1, low2 + high2)
        val z2 = multiply(high1, high2)

        return (z2 * 10.0.pow((m2 * 2).toDouble()).toLong()) +
                ((z1 - z2 - z0) * 10.0.pow(m2.toDouble()).toLong()) + z0
    }

    /**
     * Calculates the number of digits in a Long number.
     *
     * @param num The Long number.
     * @return The number of digits in the given number.
     */
    fun sizeBase10(num: Long): Int {
        return if (num == 0L) 1 else (log10(abs(num.toDouble())) + 1).toInt()
    }

    /**
     * Splits a Long number into two parts at the specified position.
     *
     * @param num The Long number to split.
     * @param position The position at which to split the number.
     * @return A Pair containing the high and low parts of the number after splitting.
     */
    fun splitAt(num: Long, position: Int): Pair<Long, Long> {
        val divisor = 10.0.pow(position.toDouble()).toLong()
        val high = num / divisor
        val low = num % divisor
        return Pair(high, low)
    }
}
