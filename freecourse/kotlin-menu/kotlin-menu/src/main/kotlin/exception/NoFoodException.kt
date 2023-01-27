package exception
import constant .*
import model.FoodData

class NoFoodException {

    fun checkNoFoodException(foodList : List<String?>){
        nullCheck(foodList)
        foodRangeException(foodList)
        noIncludeList(foodList)
        duplicateFood(foodList)
    }

    fun nullCheck(foodList: List<String?>){
        for (food in foodList){
            food ?: throw IllegalArgumentException(FOOD_NULL)
        }
    }

    fun foodRangeException(foodList: List<String?>){
        if (foodList.size > 2){
            throw IllegalArgumentException(FOOD_RANGE_ERROR)
        }
    }

    fun noIncludeList(foodList: List<String?>){
        if (checkEmpty(foodList)){
            if (checkInclude(foodList)){
                throw IllegalArgumentException(NoInclude_List_Error)
            }
        }
    }

    fun duplicateFood(foodList : List<String?>){
        if (foodList.size != foodList.distinct().count()){
            throw IllegalArgumentException(FOOD_DUPLICATE_ERROR)
        }
    }

    private fun checkEmpty(foodList : List<String?>) : Boolean{
        return foodList.isNotEmpty()
    }

    fun checkInclude(foodList : List<String?>) : Boolean {
        var count = 0
        for (food in foodList) {
            FoodData.foodMap.values.forEach {
                if (it.contains(food)) {
                    count++
                }
            }
        }
        return count == 0
    }
}