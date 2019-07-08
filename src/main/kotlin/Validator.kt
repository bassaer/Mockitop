class Validator(private val limiter: Limiter) {
    fun validate(input: String) = input.length < limiter.get()
}