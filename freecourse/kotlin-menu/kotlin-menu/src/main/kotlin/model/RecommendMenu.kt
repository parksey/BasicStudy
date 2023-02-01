package model

import camp.nextstep.edu.missionutils.Randoms

class RecommendMenu(val name : String?, val noFoodList : List<String?>) {
    private var checkCategory : MutableList<Int> = mutableListOf()
    private val menuList = mutableListOf<String?>()
    private val completeMenu = mutableListOf<String>()

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
        pickMenu()

    }

    fun pickMenu(){
        menuList.add(name)
        for (cate in checkCategory){
            when (cate){
                1 -> makeMenuList(FoodData.foodMap["일식"])
                2 -> makeMenuList(FoodData.foodMap["한식"])
                3 -> makeMenuList(FoodData.foodMap["중식"])
                4 -> makeMenuList(FoodData.foodMap["아시안"])
                5 -> makeMenuList(FoodData.foodMap["양식"])
            }
        }
    }

    fun makeMenuList(menus : List<String>?) {
        while (true) {
            val menu = Randoms.shuffle(menus)[0]
            if (!menuList.contains(menu) && checkNoFood(menu)) {
                menuList.add(menu)
                break
            }
        }
    }
    fun checkNoFood(menu : String) : Boolean{
        if (!noFoodList.contains(menu)){
            return true
        }
        return false
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

    fun getRecommendMenu() : String{
        return menuList.joinToString(" | ", "[ ", " ]")
    }
}