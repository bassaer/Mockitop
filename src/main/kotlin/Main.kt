fun main() {
    val limiter = Limiter()
    val validator = Validator(limiter)
    println(validator.validate("OK"))
}