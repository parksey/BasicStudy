package model

class MenuData {
    private val menuData = mutableListOf<String>()

    fun addData(data : String){
        menuData.add(data)
    }

    fun getData() : MutableList<String>{
        return menuData
    }
}