package com.demirli.a39drawingapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.widget.Button
import android.widget.SeekBar
import com.demirli.a39drawingapp.view.DrawingView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeColor(gray_btn)
        changeColor(red_btn)
        changeColor(green_btn)
        changeColor(blue_btn)
        changeColor(black_btn)

        clear_btn.setOnClickListener {
            drawing_view.clear()
        }

        setSeekBarChangeListener()
    }

    private fun setSeekBarChangeListener(){

        seekBar.progress = 35

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                println(seekBar)
                println(progress)
                println(fromUser)
                drawing_view.changeSizeOfTool(progress/5f)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    private fun changeColor(button: Button){
        button.setOnClickListener {
            when(button){
                black_btn -> drawing_view.changeColor(Color.BLACK)
                gray_btn -> drawing_view.changeColor(Color.GRAY)
                red_btn -> drawing_view.changeColor(Color.RED)
                green_btn -> drawing_view.changeColor(Color.GREEN)
                blue_btn -> drawing_view.changeColor(Color.BLUE)
            }
        }
    }
}
