fun main() {
    val karatsuba = Karatsuba()

    // Range of integers to test
    val rangeStart = 123456L
    val rangeEnd = 12345600L
    val step = 123456L

    // Print table header
    println("%-20s %-25s %-25s %-25s %-25s".format(
        "Number",
        "Traditional Result", "Karatsuba Result",
        "Traditional Runtime (ns)", "Karatsuba Runtime (ns)")
    )

    // Test for each integer in the range
    for (num in rangeStart..rangeEnd step step) {
        // Test traditional multiplication
        val traditionalStart = System.nanoTime()
        val traditionalResult = num * num
        val traditionalEnd = System.nanoTime()
        val traditionalTime = traditionalEnd - traditionalStart

        // Test Karatsuba multiplication
        val karatsubaStart = System.nanoTime()
        val karatsubaResult = karatsuba.multiply(num, num)
        val karatsubaEnd = System.nanoTime()
        val karatsubaTime = karatsubaEnd - karatsubaStart

        // Output results in a table format
        println("%-20d %-25d %-25d %-25d %-25d".format(
            num,
            traditionalResult, karatsubaResult,
            traditionalTime, karatsubaTime)
        )
    }

    println("========================================================================================================")
    println("Note: In-built Kotlin integer multiplication uses hardware optimization and therefore,")
    println("       the tested runtime is always faster for the traditional method.")
    println("========================================================================================================")
}
