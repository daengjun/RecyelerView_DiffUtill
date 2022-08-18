package fastcampus.aop.part4.recyelerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fastcampus.aop.part4.recyelerview.databinding.LayoutViewholderBinding
import java.util.*


class MyRecyclerViewAdapter : ListAdapter<Monster, RecyclerView.ViewHolder>(MyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = MyViewHolder(
            LayoutViewholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        // is는 타입 체크 , as는 형변환
        if(holder is MyViewHolder){
            val monster = getItem(position) as Monster
            holder.bind(monster)
        }
    }
    
    // 아이템 포지션값 순서 변경
    fun moveItem(fromPosition: Int , toPosition:Int){
        val newList = currentList.toMutableList()
        Collections.swap(newList,fromPosition,toPosition)
        submitList(newList)
    }

    // 아이템 삭제
    fun removeItem(position:Int){
        val newList = currentList.toMutableList()
        newList.removeAt(position)
        submitList(newList)
    }


}