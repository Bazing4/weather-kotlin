package marco.weatherapp.domain.commands

public interface Command<out T> {
    fun execute(): T
}