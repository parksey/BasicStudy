package model

import camp.nextstep.edu.missionutils.Randoms

class RecommendMenu(val name : String?, val noFoodList : List<String?>) {
    private val menuList = mutableListOf<String?>()
    private val category = RecommendCategory.checkCategory

    fun pickMenu(){
        menuList.add(name)
        for (cate in category){
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

    fun getRecommendMenu() : String{
        return menuList.joinToString(" | ", "[ ", " ]")
    }

    fun getCategory() : String{
        val categoryList = mutableListOf<String>("카테고리")
        for (cate in category){
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