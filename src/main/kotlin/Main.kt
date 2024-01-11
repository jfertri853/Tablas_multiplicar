fun pedirNum(min: Int, max: Int): Int {
    /**
     * Solicita un número entero en un rango.
     *
     * @param min Int - valor mínimo
     * @param max Int - valor máximo
     *
     * @return Int - número entero válido dentro del rango especificado
     */
    var number = min - 1

    do {
        try {
            print("Introduzca un numero entre $min y $max: ")
            number = readln().toInt()
            if (number < min || number > max) {
                throw NumberFormatException()
            }
        } catch (e: NumberFormatException) {
            print("**Número no válido** (pulse ENTER para continuar...)")
            readln()
        }
    } while (number < min || number > max)

    return number
}


fun pregunta(text: String): Boolean {
    /**
     * Realiza una pregunta para contestar con s/si ó n/no
     *
     * @param text String - Texto de la pregunta
     *
     * @return Boolean - true/false dependiendo de la respuesta válida a la pregunta
     */
    var answer = ""
    var userCommand: String

    do {
        try {
            print("$text (s/n) -> ")
            userCommand = readln().uppercase()
            answer = when (userCommand) {
                "S", "SI" -> "SI"
                "N", "NO" -> "NO"
                else -> ""
            }
            if (answer != "SI" && answer != "NO") {
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException) {
            print("**Respuesta no válida** (pulse ENTER para continuar...)")
            readln()
        }
    } while (answer != "SI" && answer != "NO")

    val answerIsYes: Boolean = when (answer) {
        "SI" -> true
        else -> false
    }

    return answerIsYes
}


fun mostrarTablas(tablas: Array<String>, number: Int) {
    /**
     * Muestra las tablas desde el 1 hasta el tamaño final del Array
     *
     * @param tablas Array<String> - Contiene las tablas en formato de texto
     *@param number Int - El número de la tabla que se imprime
     */
    println("La tabla de multiplicar del número $number es:")
    for (i in 1..<tablas.size){
        println(tablas[i])
    }
}


fun main() {
    var again: Boolean

    do {
        val num = pedirNum(min = 1, max = 100)
        val tablas = Array(size = 11){"$it x $num = ${num * it}"}
        mostrarTablas(tablas, num)

        again = pregunta("¿Desea generar otra tabla de multiplicación?")
    } while (again)

    println("Cerrando el programa...")
}