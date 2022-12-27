package exceptionTest

import exception.UpDownException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UpdownExceptionTest {
    private val upDownException = UpDownException()
    @Test
    fun `이동할 칸 입력 시 null 인지 check`(){
        assertThrows<IllegalArgumentException> {
            upDownException.nullCheck(null)
        }
    }
    @Test
    fun `이동할 칸을 잘못 입력할 시 check`(){
        assertThrows<IllegalArgumentException> {
            upDownException.wrongInputCheck("R")
        }
    }
}