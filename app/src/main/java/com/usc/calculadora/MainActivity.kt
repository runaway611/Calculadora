package com.usc.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var num1: Double = 0.0
    var op: Int = 0
    lateinit var num1textView: TextView
    lateinit var num2textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num2textView = findViewById(R.id.num2Txtview)
        num1textView = findViewById(R.id.num1Txtview)

        val btnDelete: Button = findViewById(R.id.deleteBT)
        val btnigual: Button = findViewById(R.id.equalBT)

        btnigual.setOnClickListener{
            var numer2: Double = num2textView.text.toString().toDouble()
            var result: Double = 0.0
            when(op){
                1 -> result = num1 + numer2
                2 -> result = num1 - numer2
                3 -> result = num1 * numer2
                4 -> result = num1 / numer2
            }
            num2textView.setText(result.toString())
            num1textView.setText("")
        }
        btnDelete.setOnClickListener {
            num1textView.setText("")
            num2textView.setText("")
            num1 = 0.0
            op = 0
        }

    }

    fun getNumber(view: View){
        var num2: String = num2textView.text.toString()
        when(view.id){
            R.id.zeroBT -> num2textView.setText(num2+'0')
            R.id.oneBT -> num2textView.setText(num2+'1')
            R.id.twoBT -> num2textView.setText(num2+'2')
            R.id.threeBT -> num2textView.setText(num2+'3')
            R.id.fourBT -> num2textView.setText(num2+'4')
            R.id.fiveBT -> num2textView.setText(num2+'5')
            R.id.sixBT -> num2textView.setText(num2+'6')
            R.id.sevenBT -> num2textView.setText(num2+'7')
            R.id.eightBT -> num2textView.setText(num2+'8')
            R.id.nineBT -> num2textView.setText(num2+'9')
        }

    }

    fun ope(view: View) {
        var num2 = num2textView.text.toString()
        num1 = num2.toString().toDouble()
        num2textView.setText("")
        when (view.id) {
            R.id.sumBT -> {
                num1textView.setText(num2 + "+")
                op = 1
            }

            R.id.restBT -> {
                num1textView.setText(num2 + "-")
                op = 2
            }

            R.id.multBT -> {
                num1textView.setText(num2 + "*")
                op = 3
            }

            R.id.divBT -> {
                num1textView.setText(num2 + "/")
                op = 4
            }
        }
    }
}