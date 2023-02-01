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

    fun getCategory() : String{
        val categoryList = mutableListOf<String>("카테고리")
        for (cate in checkCategory){
            when (cate){
                1 -> categoryList.add("일식")
                2 -> categoryList.add("한식")
                3 -> categoryList.add("중식")
                4 -> categoryList.add("아시안")
                5 -> categoryList.add("양식")
            }
        }
        return categoryList.joinToString(" | ", "[ ", " ]")
    }
}