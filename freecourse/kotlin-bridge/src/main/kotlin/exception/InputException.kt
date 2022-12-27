package exception

enum class ExceptionMessage(val message : String){
    NULL_ERROR("[ERROR] null Error 입니다. 다시 입력해 주세요."),
    RANGE_ERROR("[ERROR] 다리 사이즈는 3~20 사이여야 합니다. 다시 입력해 주세요."),
    NOT_NUMBER_ERROR("[ERROR] 다리 사이즈는 숫자여야 합니다. 다시 입력해 주세요.")
}

class InputException {
    fun checkBridgeSizeException(input : String){
        sizeNullCheck(input)
        sizeNotNumberCheck(input)
        sizeRangeCheck(input)
    }

    fun sizeNullCheck(input : String?){
        input ?: throw IllegalArgumentException(ExceptionMessage.NULL_ERROR.message)
    }

    fun sizeRangeCheck(input : String){
        val inputNum = input.toInt()
        if (inputNum < 3 || inputNum > 20){
            throw IllegalArgumentException(ExceptionMessage.RANGE_ERROR.message)
        }
    }

    fun sizeNotNumberCheck(input : String){
        for (i in input.indices){
            if (!(input[i].isDigit())){
                throw IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR.message)
            }
        }
    }
}