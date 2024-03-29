package marco.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import marco.weatherapp.R
import marco.weatherapp.domain.commands.model.Forecast
import marco.weatherapp.domain.commands.model.ForecastList
import marco.weatherapp.ui.ctx

class ForecastListAdapter(private val weekForecast: ForecastList, private val itemClick: (Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindForecast(weekForecast[position])
    }

    interface OnItemClickListener{
        operator fun invoke(forecast: Forecast)
    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(view: View, private val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view){
        private val iconView = view.findViewById<ImageView>(R.id.icon)
        private val dateView = view.findViewById<TextView>(R.id.date)
        private val descriptionView = view.findViewById<TextView>(R.id.description)
        private val maxTemperatureView = view.findViewById<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.findViewById<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast){
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}
