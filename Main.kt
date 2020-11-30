package machine
import java.util.Scanner

val s = Scanner(System.`in`)

fun main() {
    print("Write how many cups of coffee you will need: ")
    s.nextInt().let {
        println("For $it cups of coffee you will need:\n" +
                "${it * 200} ml of water\n" +
                "${it * 50} ml of milk\n" +
                "${it * 15} g of coffee beans")
    }
}
