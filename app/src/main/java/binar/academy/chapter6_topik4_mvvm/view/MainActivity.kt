package binar.academy.chapter6_topik4_mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.chapter6_topik4_mvvm.databinding.ActivityMainBinding
import binar.academy.chapter6_topik4_mvvm.viewmodel.CarViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val viewModel : CarViewModel by viewModels()
    private lateinit var carAdapter : CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRvData()
    }

    private fun setRvData() {
        viewModel.showAllDataCars()
        viewModel.getLiveDataCars().observe(this){
            if ( it != null){
                binding.apply {
                    rvCar.layoutManager = LinearLayoutManager(this@MainActivity)
                    rvCar.adapter = CarAdapter(it)
                }
            }
        }
    }
}