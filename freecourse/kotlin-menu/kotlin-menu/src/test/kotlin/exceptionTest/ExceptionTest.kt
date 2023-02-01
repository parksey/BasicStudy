package exceptionTest

import exception.NoFoodException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTest {
    private val noFoodException = NoFoodException()

    @Test
    fun `못 먹는 음식이 count가 세어지는지 test`(){
        assertEquals(true, noFoodException.checkInclude(listOf("test1", "test2")))
    }
    @Test
    fun `못 먹는 음식이 점심 메뉴 추천 목록에 있는지 test`(){
        assertThrows<IllegalArgumentException> {
            noFoodException.noIncludeList(listOf("test1", "test2"))
        }
    }
}