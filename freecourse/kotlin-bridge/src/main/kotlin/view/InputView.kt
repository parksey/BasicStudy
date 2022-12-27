package view

import camp.nextstep.edu.missionutils.Console
import exception.ExceptionMessage
import exception.InputException
import exception.RetryQuitException
import exception.UpDownException
import kotlin.IllegalArgumentException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val inputException = InputException()
    private val upDownException = UpDownException()
    private val retryQuitException = RetryQuitException()
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize() : Int {
        while(true){
            var flag = true
            val bridgeSize = Console.readLine()
            try{
                inputException.checkBridgeSizeException(bridgeSize)
            } catch(e : IllegalArgumentException){
                println(e.message) // 수정 OutputView
                flag = false
            }
            if (flag){
                return bridgeSize.toInt()
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while(true){
            var flag = true
            val upDown = Console.readLine()
            try{
                upDownException.checkUpDown(upDown)
            } catch (e : IllegalArgumentException){
                println(e.message)
                flag = false
            }
            if (flag){
                return upDown
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while (true){
            var flag = true
            val retryOrQuit = Console.readLine()
            try{
                retryQuitException.checkRetryQuit(retryOrQuit)
            } catch (e : IllegalArgumentException){
                println(e.message)
                flag = false
            }
            if (flag){
                return retryOrQuit
            }
        }
    }
}
