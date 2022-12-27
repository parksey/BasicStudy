package exceptionTest

import exception.InputException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputExceptionTest {
    private val inputException = InputException()
    @Test
    fun `다리 사이즈 입력이 null 인지 check`(){
        assertThrows<IllegalArgumentException> {
            inputException.sizeNullCheck(null)
        }
    }
    @Test
    @ParameterizedTest
    @ValueSource(strings = arrayOf("100", "245"))
    fun `다리 사이즈 범위 check`(userInput : String){
        assertThrows<IllegalArgumentException> {
            inputException.sizeRangeCheck(userInput)
        }
    }
    @Test
    fun `다리 사이즈가 숫자인지 check`(){
        assertThrows<IllegalArgumentException> {
            inputException.sizeNotNumberCheck("abc")
        }
    }

}