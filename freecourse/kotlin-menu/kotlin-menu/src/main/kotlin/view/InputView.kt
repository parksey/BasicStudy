package view

import camp.nextstep.edu.missionutils.Console
import exception.InputException
import exception.NoFoodException

class InputView {
    private val inputException = InputException()
    private val noFoodException = NoFoodException()

    fun readName() : List<String?>{
        val inputName : List<String?> = Console.readLine().split(",")
        inputException.checkCoachNameException(inputName)
        return inputName
    }

    fun readNoFood() : List<String?>{
        val noFoodList : List<String?> = Console.readLine().split(",")
        noFoodException.checkNoFoodException(noFoodList)
        return noFoodList
    }
}