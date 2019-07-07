import org.junit.jupiter.api.Test

class ValidatorTest {

    @Test
    fun validateDefault() {
        val validator = Validator()
        assert(validator.validate(""))
        assert(!validator.validate("test"))
    }

    @Test
    fun validateLength() {
        val validator = Validator(4)
        assert(validator.validate("test"))
        assert(!validator.validate("invalid"))
    }
}