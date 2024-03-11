import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertEquals

class KaratsubaTest {

    @Test
    fun multiply() {
        val karatsuba = Karatsuba()
        assertEquals(123 * 456, karatsuba.multiply(123, 456))
        assertEquals(123456789 * 0, karatsuba.multiply(123456789, 0))
        assertEquals(0 * 0, karatsuba.multiply(0, 0))
        assertEquals(1 * 1, karatsuba.multiply(1, 1))
        assertEquals(555 * 555, karatsuba.multiply(555, 555))
    }

    @Test
    fun testSizeBase10() {
        val karatsuba = Karatsuba()
        assertEquals(1, karatsuba.sizeBase10(0))
        assertEquals(1, karatsuba.sizeBase10(5))
        assertEquals(3, karatsuba.sizeBase10(123))
        assertEquals(9, karatsuba.sizeBase10(876543210))
    }

    @Test
    fun testSplitAt() {
        val karatsuba = Karatsuba()
        assertEquals(Pair(0, 0), karatsuba.splitAt(0, 3))
        assertEquals(Pair(0, 123), karatsuba.splitAt(123, 3))
        assertEquals(Pair(123, 456), karatsuba.splitAt(123456, 3))
    }
}