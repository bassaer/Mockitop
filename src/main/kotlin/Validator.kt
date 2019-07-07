class Validator(private val length: Int = 0) {
    fun validate(input: String) = input.length == length
}