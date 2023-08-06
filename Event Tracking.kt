data class Event(
    val title: String,
    val description: String? = null,
    val dayPart: String,
    val durationInMinutes: Int
)

fun main() {
    val event = Event("Study Kotlin", "Commit to studying Kotlin at least 15 minutes per day.", "Evening", 15)
}