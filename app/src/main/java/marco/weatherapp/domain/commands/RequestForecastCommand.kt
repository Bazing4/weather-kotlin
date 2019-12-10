package marco.weatherapp.domain.commands

import marco.weatherapp.data.ForecastRequest
import marco.weatherapp.domain.commands.mappers.ForecastDataMapper
import marco.weatherapp.domain.commands.model.ForecastList

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
     override fun execute(): ForecastList {
         val forecastRequest = ForecastRequest(zipCode)
         return ForecastDataMapper().convertFromDataModel(
             forecastRequest.execute())
         }
}