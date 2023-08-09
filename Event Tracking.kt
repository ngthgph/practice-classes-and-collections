enum class DayPart {
    MORNING,
    AFTERNOON,
    EVENING
}

data class Event(
    val title: String,
    val description: String? = null,
    val dayPart: DayPart,
    val durationInMinutes: Int
)

val Event.durationOfEvent: String
    get() = if(durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    val events = mutableListOf<Event>()

    events.add(Event(title = "Study Kotlin", description = "Commit to studying Kotlin at least 15 minutes per day.", dayPart = DayPart.EVENING, durationInMinutes = 15))
    events.add(Event(title = "Wake up", description = "Time to get up", dayPart = DayPart.MORNING, durationInMinutes = 0))
    events.add(Event(title = "Eat breakfast", dayPart = DayPart.MORNING, durationInMinutes = 15))
    events.add(Event(title = "Learn about Kotlin", dayPart = DayPart.AFTERNOON, durationInMinutes = 30))
    events.add(Event(title = "Practice Compose", dayPart = DayPart.AFTERNOON, durationInMinutes = 60))
    events.add(Event(title = "Watch latest DevBytes video", dayPart = DayPart.AFTERNOON, durationInMinutes = 10))
    events.add(Event(title = "Check out latest Android Jetpack library", dayPart = DayPart.EVENING, durationInMinutes = 45))

    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("You have ${shortEvents.size} short events")
    println()

    val groupDayPart = events.groupBy { it.dayPart }
    groupDayPart.forEach { (dayPart, events) -> println("$dayPart: ${events.size} events") }
    println()

    println("Last event of the day: ${events.last().title}")
    println()

    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}