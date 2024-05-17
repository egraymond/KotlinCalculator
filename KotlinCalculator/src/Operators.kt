import kotlin.math.pow

//https://kotlinlang.org/docs/object-declarations.html#inheriting-anonymous-objects-from-supertypes
object Operators {
    fun exp(a: Double, b: Double): Double {
        val expProduct = a.pow(b)
        return expProduct
    }
    fun add(a: Double, b: Double): Double {
        val sum = a + b
        return sum
    }
    fun sub(a: Double, b: Double): Double {

        val difference = a - b
        return difference
    }
    fun multi(a: Double, b: Double): Double {

        val product = a * b
        return product
    }
    fun divide(a: Double, b: Double): Double {

        val quotient = a / b
        return quotient
    }
}