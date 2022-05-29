package uz.project.mycarwashproject.presenter.main.pages.queue

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.project.mycarwashproject.databinding.SelectCarItemBinding
import uz.project.mycarwashproject.presenter.addvehiclenum.VehicleNumClass

class SelectCarAdapter(private val onClick: (VehicleNumClass) -> Unit) :
    ListAdapter<VehicleNumClass, ListViewHolder>(ListViewHolder.CategoryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListViewHolder(
        SelectCarItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        ), onClick
    )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class ListViewHolder(
    private val itemBinding: SelectCarItemBinding,
    onClick: (VehicleNumClass) -> Unit,
) :
    RecyclerView.ViewHolder(itemBinding.root) {

    init {
        itemView.setOnClickListener {
            currentItem.let(onClick)
        }
    }

    private lateinit var currentItem: VehicleNumClass

    fun bind(item: VehicleNumClass) {
        currentItem = item
        itemBinding.namecar.text = currentItem.modelName
        itemBinding.numbercar.text = currentItem.modelNumber
    }

    object CategoryDiffCallback : DiffUtil.ItemCallback<VehicleNumClass>() {
        override fun areContentsTheSame(oldItem: VehicleNumClass, newItem: VehicleNumClass): Boolean {
            return true
        }

        override fun areItemsTheSame(oldItem: VehicleNumClass, newItem: VehicleNumClass): Boolean {
            return oldItem == newItem
        }
    }

}