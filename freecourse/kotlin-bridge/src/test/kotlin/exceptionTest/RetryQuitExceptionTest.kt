package exceptionTest

import exception.RetryQuitException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RetryQuitExceptionTest {
    private val retryQuitException = RetryQuitException()

    @Test
    fun `재시작 또는 종료 입력이 null 인지 check`(){
        assertThrows<IllegalArgumentException> {
            retryQuitException.nullCheck(null)
        }
    }

    @Test
    fun `재시작 또는 종료 입력이 R 또는 Q인지 check`(){
        assertThrows<IllegalArgumentException> {
            retryQuitException.wrongInputCheck("A")
        }
    }
}