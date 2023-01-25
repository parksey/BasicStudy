package view

import camp.nextstep.edu.missionutils.Console
import exception.InputException

class InputView {
    private val inputException = InputException()

    fun readName() : List<String?>{
        val inputName : List<String?> = Console.readLine().split(",")
        inputException.checkCoachNameException(inputName)
        return inputName
    }
}