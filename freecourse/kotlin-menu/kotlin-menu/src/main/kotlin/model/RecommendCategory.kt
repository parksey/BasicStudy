package model

import camp.nextstep.edu.missionutils.Randoms

object RecommendCategory {
    val checkCategory = mutableListOf<Int>()
    fun pickCategory(){
        while (true) {
            val category = Randoms.pickNumberInRange(1, 5)
            if (checkDuplicateCategory(category)) {
                checkCategory.add(category)
            }
            if (checkCategory.size == 5) {
                break
            }
        }
    }

    fun checkDuplicateCategory(category : Int) : Boolean{
        if (checkCategory.isEmpty()){
            return true
        }
        else{
            if(checkCategory.count{ it == category } > 2){
                return false
            }
        }
        return true
    }
}