fun main() {
    gui()
}
//User Interface
fun gui() {
    println("""
Hello! Thank you for using my calculator to help with all basic equations!""")
    //https://www.programiz.com/kotlin-programming/input-output
    val num1 = checkNumValues("What is the first number?").toInt()
    val num2 = checkNumValues("What is the second number?").toInt()
    chooseOption(num1, num2,"""
        What is the operator you wish to use? (Type the respective symbol) 
        Add(+)
        Subtract(-)
        Multiply(*)
        Divide(/)
        Exponent(^)
        """)
}
//Displays an output message
fun createEquation(a: String, b: String, c: String) {
    println("Creating Output of: ${a} ${c} ${b}")
    timer()
}
//a fun visualized timer
fun timer() {
    for( i in 1..100 ){
        print("\r ${"=".repeat(i)}> $i%");
        Thread.sleep(40);
    }
}//Takes the operator input from the user and determines what operator to use
fun chooseOption(a: Int, b: Int, optext: String) {
    var op = ""
    var check = true
    var result = ""
    while (check) {
        println(optext)
        op = readlnOrNull().toString().removeBlank()
        if (op == "+") {
            result = "Result: ${Operators.add(a.toDouble(), b.toDouble())}"
            check = false
        } else if (op == "-") {
            result = "Result: ${Operators.sub(a.toDouble(), b.toDouble())}"
            check = false
        } else if (op == "*") {
            result = "Result: ${Operators.multi(a.toDouble(), b.toDouble())}"
            check = false
        } else if (op == "/") {
            if (b == 0)
            {
                println("Attempted to divide by 0, try a different operator, if you wish to divide, reload the program and input a different second number.")
            }
            else
            {
                result = "Result: ${Operators.divide(a.toDouble(), b.toDouble())}"
                check = false
            }
        } else if (op == "^") {
            result = "Result: ${Operators.exp(a.toDouble(), b.toDouble())}"
            check = false
        } else {
            println("Please enter the one of the requested values!:")
        }
    }
    createEquation(a.toString(), b.toString(), op)
    println("""
    $result""")
}
//Erases any blank spaces
fun String.removeBlank() = replace(" ", "")

fun checkNumValues(numtext: String): String {
    var check = true
    var number = ""
    //Checks and loops around if an invalid input is detected. If not, continue the code as normal
    while (check) {
        check = false
        println(numtext)
        number = readlnOrNull().toString().removeBlank()
        try {
            number.toInt()
        } catch (e: NumberFormatException) {
            println("Please enter the requested value, try again")
            check = true
        }
    }
    return number
}
