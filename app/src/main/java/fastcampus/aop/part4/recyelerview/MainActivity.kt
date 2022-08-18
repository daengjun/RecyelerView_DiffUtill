package fastcampus.aop.part4.recyelerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import fastcampus.aop.part4.recyelerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    // 어뎁터에 전달할 데이터 목록
    private val dataSet = arrayListOf<Monster>().apply {
        add(Monster("타일런트", Race.Zombie, 10, listOf(100, 10, 50), false))
        add(Monster("조커", Race.Human, 23, listOf(200, 20, 100), false))
        add(Monster("그렘린", Race.Goblin, 2, listOf(10, 1, 5), true))
        add(Monster("리오레우스", Race.Dragon, 2500, listOf(10000, 1000, 50000), false))
        add(Monster("사우론", Race.Human, 100, listOf(1000, 200, 1000), false))
        add(Monster("리바이어던", Race.Dragon, 50, listOf(2000, 250, 10000), true))
    }

    // 리사이클러뷰 객체 생성
    private val myRecyclerViewAdapter: MyRecyclerViewAdapter by lazy{
        MyRecyclerViewAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recyclerview.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL)) // 리사이클러뷰 가로 세로 여백 지정
            adapter = myRecyclerViewAdapter
        }

        // subList로 데이터 전달
        myRecyclerViewAdapter.submitList(dataSet)

        // 플로팅 버튼 온클릭 리스너 (셔플 기능)
        binding.fab.setOnClickListener {
            myRecyclerViewAdapter.submitList(dataSet.shuffled())
        }


        // itemTouchHelper 활용 해서 리사이클러뷰 터치 구현
        val itemTouchHelper = ItemTouchHelper(MyItemTouchHelperCallback(binding.recyclerview))
        itemTouchHelper.attachToRecyclerView(binding.recyclerview)


    }
}