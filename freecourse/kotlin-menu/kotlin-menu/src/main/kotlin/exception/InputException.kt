package exception
import constant .*

class InputException {
    fun checkCoachNameException(input : List<String?>){
        nameNullCheck(input)
        nameRangeCheck(input)
        listRangeCheck(input)
        containEmpty(input)
    }

    fun nameNullCheck(input : List<String?>){
        for (name in input){
            name ?: throw IllegalArgumentException(NULL_ERROR)
        }
    }

    fun nameRangeCheck(input : List<String?>){
        for (name in input){
            if(name!!.length < 2 || name.length > 4){
                throw IllegalArgumentException(RANGE_ERROR)
            }
        }
    }

    fun listRangeCheck(input : List<String?>){
        if (input.size < 2 || input.size > 5){
            throw IllegalArgumentException(LIST_RANGE_ERROR)
        }
    }

    fun containEmpty(input : List<String?>){
        for(name in input){
            if (name!!.contains(EMPTY)){
                throw IllegalArgumentException(EMPTY_ERROR)
            }
        }
    }
}