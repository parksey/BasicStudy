package exception

enum class RetryQuitExceptionMessage(val message : String){
    NULL_ERROR("[ERROR] 잘못된 입력 값 입니다."),
    NOT_STRING_ERROR("[ERROR] R 또는 Q를 입력해 주세요.")
}

class RetryQuitException {
    fun checkRetryQuit(input : String){
        nullCheck(input)
        wrongInputCheck(input)
    }

    fun nullCheck(input : String?){
        input ?: throw IllegalArgumentException(RetryQuitExceptionMessage.NULL_ERROR.message)
    }

    fun wrongInputCheck(input : String){
        if (!(input == "R" || input == "Q")){
            throw IllegalArgumentException(RetryQuitExceptionMessage.NOT_STRING_ERROR.message)
        }
    }
}