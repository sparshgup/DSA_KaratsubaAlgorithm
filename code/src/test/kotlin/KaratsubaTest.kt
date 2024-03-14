import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KaratsubaTest {

    /**
     * Tests the multiplication function of the Karatsuba algorithm.
     */
    @Test
    fun multiply() {
        val karatsuba = Karatsuba()
        assertEquals(123L * 456L, karatsuba.multiply(123L, 456L))
        assertEquals(123456789L * 0L, karatsuba.multiply(123456789L, 0L))
        assertEquals(0L * 0L, karatsuba.multiply(0L, 0L))
        assertEquals(1L * 1L, karatsuba.multiply(1L, 1L))
        assertEquals(555L * 555L, karatsuba.multiply(555L, 555L))
    }

    /**
     * Tests the sizeBase10 function of the Karatsuba algorithm.
     */
    @Test
    fun testSizeBase10() {
        val karatsuba = Karatsuba()
        assertEquals(1, karatsuba.sizeBase10(0L))
        assertEquals(1, karatsuba.sizeBase10(5L))
        assertEquals(3, karatsuba.sizeBase10(123L))
        assertEquals(9, karatsuba.sizeBase10(876543210L))
    }

    /**
     * Tests the splitAt function of the Karatsuba algorithm.
     */
    @Test
    fun testSplitAt() {
        val karatsuba = Karatsuba()
        assertEquals(Pair(0L, 0L), karatsuba.splitAt(0L, 3))
        assertEquals(Pair(0L, 123L), karatsuba.splitAt(123L, 3))
        assertEquals(Pair(123L, 456L), karatsuba.splitAt(123456L, 3))
    }
}
