package com.example.mvptest

import  android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mvptest.databinding.ActivityMainBinding
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        val listener = View.OnClickListener {
           val current = when (it.id) {
                R.id.btn_counter1 -> Buttons.FIRST
                R.id.btn_counter2 -> Buttons.SECOND
                R.id.btn_counter3 -> Buttons.THIRD
               else -> throw IllegalArgumentException("Something wrong")
           }
            presenter.counterClick(current)
        }

        _binding?.btnCounter1?.setOnClickListener(listener)
        _binding?.btnCounter2?.setOnClickListener(listener)
        _binding?.btnCounter3?.setOnClickListener(listener)
    }

    override fun setButtonText(index: Int, text: String) {
        when(index){
            0 -> _binding?.btnCounter1?.text = text
            1 -> _binding?.btnCounter2?.text = text
            2 -> _binding?.btnCounter3?.text = text
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

