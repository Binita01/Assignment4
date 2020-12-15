package com.binitasimbu.calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder



class MainActivity : AppCompatActivity() {
    private lateinit var tvExpression:TextView
    private lateinit var tvresult:TextView
    private lateinit var btnDivide: Button
    private lateinit var btnClear: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn0: Button
    private lateinit var btnMul: Button
    private lateinit var btnDel: Button
    private lateinit var btnPlus: Button
    private lateinit var btnMinus: Button
    private lateinit var btnEqual: Button
    private lateinit var btnDot: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        btn2.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        btn3.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        btn4.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        btn5.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        btn6.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        btn7.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        btn8.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        btn9.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        btn0.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /*Operators*/

        btnPlus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        btnMinus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        btnMul.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        btnDivide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        btnDot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        btnClear.setOnClickListener {
            tvExpression.text = ""
            tvresult.text = ""
        }

        btnEqual.setOnClickListener {
            val text = tvExpression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvresult.text = longResult.toString()
            } else {
                tvresult.text = result.toString()
            }
        }

        btnDel.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                tvExpression.text = text.drop(1)
            }

            tvresult.text = ""
        }
    }
    fun evaluateExpression(string: String, clear: Boolean) {
        if(clear) {
            tvresult.text= ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvresult.text)
            tvExpression.append(string)
            tvresult.text = ""
        }
    }
}