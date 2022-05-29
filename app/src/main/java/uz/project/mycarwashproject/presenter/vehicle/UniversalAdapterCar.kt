package uz.project.mycarwashproject.presenter.vehicle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.project.mycarwashproject.databinding.HorizontalCardItemBinding

class UniversalAdapterCar(private val onClick: (ObjectClass) -> Unit) :
    ListAdapter<ObjectClass, ListViewHolder>(ListViewHolder.CategoryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListViewHolder(
        HorizontalCardItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        ), onClick
    )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class ListViewHolder(
    private val itemBinding: HorizontalCardItemBinding,
    onClick: (ObjectClass) -> Unit,
) :
    RecyclerView.ViewHolder(itemBinding.root) {

    init {
        itemView.setOnClickListener {
            currentItem.let(onClick)
        }
    }

    private lateinit var currentItem: ObjectClass

    fun bind(item: ObjectClass) {
        currentItem = item
        itemBinding.carPhotoo.setImageResource(currentItem.img_car)
        itemBinding.companyName.text = currentItem.companyName
        itemBinding.modelName.text = currentItem.modelName
    }

    object CategoryDiffCallback : DiffUtil.ItemCallback<ObjectClass>() {
        override fun areItemsTheSame(oldItem: ObjectClass, newItem: ObjectClass): Boolean {
            return oldItem == newItem

        }

        override fun areContentsTheSame(oldItem: ObjectClass,newItem: ObjectClass): Boolean {
            return oldItem==newItem
        }
    }

}