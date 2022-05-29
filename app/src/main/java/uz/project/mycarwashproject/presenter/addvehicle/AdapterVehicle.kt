package uz.project.mycarwashproject.presenter.addvehicle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.HorizontalCardItemBinding
import uz.project.mycarwashproject.presenter.addvehiclenum.VehicleNumClass
import uz.project.mycarwashproject.presenter.main.pages.history.Car
import uz.project.mycarwashproject.presenter.main.pages.history.MyAdapter

class AdapterVehicle(private val carList: List<VehicleNumClass>): RecyclerView.Adapter<AdapterVehicle.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_card_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = carList[position]
        holder.modelName.text = currentItem.modelName
        holder.modelNum.text = currentItem.modelNumber
        holder.Img.setImageResource(currentItem.modelImg)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val modelName: TextView = itemView.findViewById(R.id.companyName)
        val modelNum: TextView = itemView.findViewById(R.id.modelName)
        val Img: ImageView = itemView.findViewById(R.id.carPhotoo)
    }
}