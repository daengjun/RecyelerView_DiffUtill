package fastcampus.aop.part4.recyelerview

import androidx.recyclerview.widget.DiffUtil

class MyDiffCallback : DiffUtil.ItemCallback<Monster>() {

    override fun areItemsTheSame(oldItem: Monster, newItem: Monster): Boolean {
       return  oldItem.hashCode() == newItem.hashCode()

    }

    override fun areContentsTheSame(oldItem: Monster, newItem: Monster): Boolean {
        return oldItem == newItem
    }

}