import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Test

class ValidatorTest {

    @Test
    fun validateDefault() {
        val limiter = Limiter()
        val validator = Validator(limiter)
        assert(validator.validate(""))
        assert(!validator.validate("test"))
    }

    @Test
    fun validateLength() {
        val limiter = Limiter(Limiter.Level.HIGH)
        val validator = Validator(limiter)
        assert(!validator.validate("NG"))
        limiter.level = Limiter.Level.LOW
        assert(validator.validate("OK"))
    }

    @Test
    fun validateWithMock() {
        val limiter = mock<Limiter>(name = "MockLimiter")
        whenever(limiter.get()).thenReturn(10)
        val validator = Validator(limiter)
        assert(validator.validate("OK"))
        whenever(limiter.get()).thenReturn(0)
        assert(!validator.validate("NG"))
    }
}