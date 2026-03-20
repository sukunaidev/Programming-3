//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val studentName = "ariana"
    val middleName = null
    val name = middleName ?: "No middle name"

    println("Welcome, ${studentName} " + "${name}")
}