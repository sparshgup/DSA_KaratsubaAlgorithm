import java.lang.Integer.max
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

class Karatsuba() {

    fun multiply(num1: Int, num2: Int): Int {
        // fall back to traditional multiplication if num < 10
        if (num1 < 10 || num2 < 10)
            return num1 * num2

        // Calculates the size of the numbers
        val m = max(sizeBase10(num1), sizeBase10(num2))
        val m2 = floor(m.toDouble() / 2).toInt()

        // Split the digit sequences in the middle
        val (high1, low1) = splitAt(num1, m2)
        val (high2, low2) = splitAt(num2, m2)

        // 3 recursive calls made to numbers approximately half the size
        val z0 = multiply(low1, low2)
        val z1 = multiply(low1 + high1, low2 + high2)
        val z2 = multiply(high1, high2)

        return (z2 * 10.0.pow(m2 * 2).toInt()) +
                ((z1 - z2 - z0) * 10.0.pow(m2.toDouble()).toInt()) + z0
    }

    fun sizeBase10(num: Int): Int {
        return if (num == 0) 1 else (log10(abs(num.toDouble())) + 1).toInt()
    }

    fun splitAt(num: Int, position: Int): Pair<Int, Int> {
        val divisor = 10.0.pow(position.toDouble()).toInt()
        val high = num / divisor
        val low = num % divisor
        return Pair(high, low)
    }
}