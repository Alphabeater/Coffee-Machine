package machine
import java.util.Scanner

val s = Scanner(System.`in`)

fun main() {
    print("Write how many ml of water the coffee machine has: ")
    val water = s.nextInt()
    print("Write how many ml of milk the coffee machine has: ")
    val milk = s.nextInt()
    print("Write how many grams of coffee beans the coffee machine has: ")
    val beans = s.nextInt()
    print("Write how many cups of coffee you will need: ")
    val cups = s.nextInt()

    println(makeCoffee(water, milk, beans, cups))
}

fun makeCoffee(water: Int, milk: Int, beans: Int, cupsDesired: Int): String {
    val cupsAvailable = minOf(water / 200, milk / 50, beans / 15)
    return if (cupsAvailable == cupsDesired) {
        "Yes, I can make that amount of coffee"
    } else if (cupsAvailable < cupsDesired) {
        "No, I can make only $cupsAvailable cups of coffee"
    } else {
        "Yes, I can make that amount of coffee (and even ${cupsAvailable - cupsDesired} more than that)"
    }
}