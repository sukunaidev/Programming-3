data class Laptop(val brand: String, val ramGB: Int)
{
}
fun Laptop.toLehmanGigabtye(): String = "Laptop Ram: $ramGB GB| 16 GB is the Lehman standard."

fun main(){
    val laptop1 = Laptop("Acer", 16)
    val laptop2 = Laptop("HP", 32)
    println(laptop1.toLehmanGigabtye())
    println(laptop2.toLehmanGigabtye())



}

