package bridge

class MakeMap {
    private val upBridge = mutableListOf<String>()
    private val downBridge = mutableListOf<String>()
    private val tempSuccessList = mutableListOf<String>(BLANK, SUCCESS, BLANK)
    private val tempFailList = mutableListOf<String>(BLANK, FAIL, BLANK)
    private val blankList = mutableListOf<String>(BLANK, BLANK, BLANK)
    private var failFlag = false
    private var flag = false


    fun flagCheck(){
        if (upBridge.size != 0){
            flag = true
        }
    }

    fun makeSuccessMap(upDown : String){
        flagCheck()
        if (!flag){
            makeOneMap(upDown)
        }
        else{
            makeMoreMap(upDown)
        }
    }

    fun makeFailMap(upDown : String){
        flagCheck()
        failFlag = true
        if (!flag){
            makeOneMap(upDown)
        }
        else{
            makeMoreMap(upDown)
        }
        failFlag = false
    }

    fun makeOneMap(upDown : String){
        when (upDown){
            UP -> insertUpMap()
            DOWN -> insertDownMap()
        }
    }

    fun makeMoreMap(upDown : String){
        when (upDown){
            UP -> {
                upBridge.add(JOIN)
                downBridge.add(JOIN)
                insertUpMap()
            }
            DOWN -> {
                upBridge.add(JOIN)
                downBridge.add(JOIN)
                insertDownMap()
            }
        }
    }

    fun insertUpMap(){
        if(!failFlag){
            for (map in tempSuccessList){
                upBridge.add(map)
            }
            for (map in blankList){
                downBridge.add(map)
            }
        }
        else{
            for (map in tempFailList){
                upBridge.add(map)
            }
            for (map in blankList){
                downBridge.add(map)
            }
        }
    }

    fun insertDownMap(){
        if(!failFlag){
            for (map in tempSuccessList){
                downBridge.add(map)
            }
            for (map in blankList){
                upBridge.add(map)
            }
        }
        else{
            for (map in tempFailList){
                downBridge.add(map)
            }
            for (map in blankList){
                upBridge.add(map)
            }
        }
    }

    fun clearMap(){
        flag = false
        upBridge.clear()
        downBridge.clear()
    }

    fun getMap() : Pair<String, String>{
        return Pair(upBridge.joinToString("", OPEN, CLOSE), downBridge.joinToString("", OPEN, CLOSE))
    }

    companion object{
        const val UP = "U"
        const val DOWN = "D"
        const val OPEN = "["
        const val CLOSE = "]"
        const val SUCCESS = "O"
        const val FAIL = "X"
        const val JOIN = "|"
        const val BLANK = " "
    }

}