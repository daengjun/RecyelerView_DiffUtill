package fastcampus.aop.part4.recyelerview

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import fastcampus.aop.part4.recyelerview.databinding.LayoutViewholderBinding

class MyViewHolder(private val binding: LayoutViewholderBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Monster) {

        with(binding) {
            tvName.text = "Name: ${data.name}"
            tvRace.text = "Race: ${data.race}"
            tvLevel.text = "Level: ${data.level}"
            tvStats.text = "HP: ${data.stats[0]} / MP: ${data.stats[1]} / Exp: ${data.stats[2]}"
            tvEncount.text = "Encounted: ${data.encount}"

            vhLayout.setOnClickListener {
                Snackbar.make(it, "Item $layoutPosition touched!", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    // 투명도값 설정하기 위해서 생성한 매서드 (터치시에 동작)
    fun setAlpha(alpha: Float) {
        with(binding) {
            tvName.alpha = alpha
            tvRace.alpha = alpha
            tvLevel.alpha = alpha
            tvStats.alpha = alpha
            tvEncount.alpha = alpha
        }
    }

}