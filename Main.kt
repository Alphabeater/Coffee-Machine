package machine
import java.util.Scanner

val s = Scanner(System.`in`)

open class Coffee(var water: Int, var milk: Int, var beans: Int, var cups: Int, var money: Int) {

    fun printState() = println("The coffee machine has:\n" +
            "$water of water\n" +
            "$milk of milk\n" +
            "$beans of coffee beans\n" +
            "$cups of disposable cups\n" +
            "$money of money\n")
    fun buy(option: Int) {
        when (option) {
            1 -> makeCoffee(waterNeeded = 250, beansNeeded = 16, cost = 4) //espresso
            2 -> makeCoffee(350, 75, 20, 7) //latte
            3 -> makeCoffee(200, 100, 12, 6) //cappuccino
            else -> println("No such option.")
        }
    }

    private fun makeCoffee(waterNeeded: Int, milkNeeded: Int = 0, beansNeeded: Int, cost: Int) {
        if (cups > 0) {
            if (waterNeeded > water || milkNeeded > milk || beansNeeded > beans) println("Not enough resouces")
            else {
                water -= waterNeeded
                milk -= milkNeeded
                beans -= beansNeeded
                money += cost
                cups -= 1
            }
        } else println("Not enough cups.")
    }

    fun fill(addWater: Int, addMilk: Int, addBeans: Int, addCups: Int) {
        water += addWater
        milk += addMilk
        beans += addBeans
        cups += addCups
    }

    fun take() {
        println("I gave you $$money")
        money = 0
    }
}

fun main() {
    val coffeeMachine = Coffee(400, 540, 120, 9, 550)

    coffeeMachine.printState()
    print("Write action (buy, fill, take): ")
    when (readLine()!!) {
        "buy" -> {
            print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
            coffeeMachine.buy(readLine()!!.toInt())
        }
        "fill" -> {
            print("Write how many ml of water do you want to add: ")
            val water = readLine()!!.toInt()
            print("Write how many ml of milk do you want to add: ")
            val milk = readLine()!!.toInt()
            print("Write how many grams of coffee beans do you want to add: ")
            val beans = readLine()!!.toInt()
            print("Write how many disposable cups of coffee do you want to add: ")
            val cups = readLine()!!.toInt()
            coffeeMachine.fill(water, milk, beans, cups)
        }
        "take" -> {
            coffeeMachine.take()
        }
        else -> println("No such option.")
    }
    println()
    coffeeMachine.printState()
}
