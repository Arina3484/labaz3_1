import kotlin.random.Random

fun main() {
    println("Добро пожаловать в игру \"Камень-Ножницы-Бумага\"!")

    while (true) {
        println("Выберите ваш ход (1 - Камень, 2 - Ножницы, 3 - Бумага, 0 - Выход):")
        val playerChoice = readLine()?.toIntOrNull()

        when (playerChoice) {
            1, 2, 3 -> {
                val computerChoice = Random.nextInt(1, 4)
                printResult(playerChoice, computerChoice)
            }
            0 -> {
                println("Игра завершена. Спасибо за участие!")
                break
            }
            else -> {
                println("Неверный выбор. Пожалуйста, введите 1, 2, 3 или 0.")
            }
        }
    }
}

fun printResult(playerChoice: Int, computerChoice: Int) {
    println("Ваш выбор: ${getChoiceName(playerChoice)}")
    println("Выбор компьютера: ${getChoiceName(computerChoice)}")

    when {
        playerChoice == computerChoice -> println("Ничья! Попробуйте еще раз.")
        playerChoice == 1 && computerChoice == 3 ||
                playerChoice == 2 && computerChoice == 1 ||
                playerChoice == 3 && computerChoice == 2 -> println("Вы победили!")
        else -> println("Вы проиграли. Попробуйте еще раз.")
    }
}

fun getChoiceName(choice: Int): String {
    return when (choice) {
        1 -> "Камень"
        2 -> "Ножницы"
        3 -> "Бумага"
        else -> "Неизвестный выбор"
    }
}