
open class Limiter(var level: Level = Level.NORMAL) {

    open fun get() = BASE * level.value

    enum class Level(val value: Int){
        HIGH(1),
        NORMAL(3),
        LOW(5)
    }

    companion object {
        const val BASE = 1
    }
}