package exception

enum class UpDownExceptionMessage(val message : String){
    NULL_ERROR("[ERROR] 잘못된 값이 입력되었습니다."),
    WRONG_INPUT_ERROR("[ERROR] U 또는 D를 입력해 주세요.")
}

class UpDownException {
    fun checkUpDown(input : String){
        nullCheck(input)
        wrongInputCheck(input)
    }

    fun nullCheck(input : String?){
        input ?: throw IllegalArgumentException(UpDownExceptionMessage.NULL_ERROR.message)
    }

    fun wrongInputCheck(input : String){
        if (!(input == "U" || input == "D")){
            throw IllegalArgumentException(UpDownExceptionMessage.WRONG_INPUT_ERROR.message)
        }
    }
}