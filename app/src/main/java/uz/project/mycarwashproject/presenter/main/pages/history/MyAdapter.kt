package uz.project.mycarwashproject.presenter.main.pages.history

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import uz.project.mycarwashproject.R

class MyAdapter(private val carList: List<Car>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.car_history_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = carList[position]
            holder.carName.text = currentItem.carName
            holder.carNum.text = currentItem.carNumber
            holder.time.text = currentItem.time
            holder.price.text = currentItem.price
        }

    override fun getItemCount(): Int {
        return carList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carName: TextView = itemView.findViewById(R.id.display_name)
        val carNum: TextView = itemView.findViewById(R.id.display_num)
        val time: TextView = itemView.findViewById(R.id.display_time)
        val price: TextView = itemView.findViewById(R.id.display_price)
    }
}