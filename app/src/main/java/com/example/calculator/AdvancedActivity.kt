package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression

class AdvancedActivity : AppCompatActivity() {
    private var myString = "0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced)
        val buttonzero = findViewById<Button>(R.id.buttonzero)
        val buttonzeros = findViewById<Button>(R.id.buttonzeros)
        val buttondot = findViewById<Button>(R.id.buttondot)
        val buttonone = findViewById<Button>(R.id.buttonone)
        val buttontwo = findViewById<Button>(R.id.buttontwo)
        val buttonthree = findViewById<Button>(R.id.buttonthree)
        val buttonfour = findViewById<Button>(R.id.buttonfour)
        val buttonfive = findViewById<Button>(R.id.buttonfive)
        val buttonsix = findViewById<Button>(R.id.buttonsix)
        val buttonseven = findViewById<Button>(R.id.buttonseven)
        val buttoneight = findViewById<Button>(R.id.buttoneight)
        val buttonnine = findViewById<Button>(R.id.buttonnine)
        val buttonplus = findViewById<Button>(R.id.buttonplus)
        val buttonminus = findViewById<Button>(R.id.buttonminus)
        val buttonmultiply = findViewById<Button>(R.id.buttonmultiply)
        val buttondivide = findViewById<Button>(R.id.buttondivide)
        val buttonpower = findViewById<Button>(R.id.buttonpower)
        val buttonsin = findViewById<Button>(R.id.buttonsin)
        val buttoncos = findViewById<Button>(R.id.buttoncos)
        val buttontg = findViewById<Button>(R.id.buttontg)
        val buttonsqrt = findViewById<Button>(R.id.buttonsqrt)
        val buttonln = findViewById<Button>(R.id.buttonln)
        val buttonclear = findViewById<Button>(R.id.buttonclear)
        val buttonbackspace = findViewById<Button>(R.id.buttonbackspace)
        val buttonequals = findViewById<Button>(R.id.buttonequals)
        val textview = findViewById<TextView>(R.id.textView3)

        if (savedInstanceState != null) {
            myString = savedInstanceState.getString("expression").toString()
            textview.text = myString
        }

        buttonzero.setOnClickListener {
            evaluateExpression("0")
        }

        buttonzeros.setOnClickListener {
            evaluateExpression("00")
        }

        buttondot.setOnClickListener {
            evaluateExpression(".")
        }

        buttonone.setOnClickListener {
            evaluateExpression("1")
        }

        buttontwo.setOnClickListener {
            evaluateExpression("2")
        }

        buttonthree.setOnClickListener {
            evaluateExpression("3")
        }

        buttonfour.setOnClickListener {
            evaluateExpression("4")
        }

        buttonfive.setOnClickListener {
            evaluateExpression("5")
        }

        buttonsix.setOnClickListener {
            evaluateExpression("6")
        }

        buttonseven.setOnClickListener {
            evaluateExpression("7")
        }

        buttoneight.setOnClickListener {
            evaluateExpression("8")
        }

        buttonnine.setOnClickListener {
            evaluateExpression("9")
        }

        buttonplus.setOnClickListener {
            evaluateExpression("+")
        }

        buttonminus.setOnClickListener {
            evaluateExpression("-")
        }

        buttonmultiply.setOnClickListener {
            evaluateExpression("*")
        }

        buttondivide.setOnClickListener {
            evaluateExpression("/")
        }

        buttonpower.setOnClickListener {
            evaluateExpression("^2")
            val e = Expression(myString)
            myString = e.calculate().toString()
            textview.text = myString
        }

        buttonsin.setOnClickListener {
            var temp = "sin("
            temp += myString
            temp += ")"
            myString = temp
            textview.text = myString
        }

        buttoncos.setOnClickListener {
            var temp = "cos("
            temp += myString
            temp += ")"
            myString = temp
            textview.text = myString
        }

        buttontg.setOnClickListener {
            var temp = "tg("
            temp += myString
            temp += ")"
            myString = temp
            textview.text = myString
        }

        buttonsqrt.setOnClickListener {
            var temp = "sqrt("
            temp += myString
            temp += ")"
            myString = temp
            textview.text = myString
        }

        buttonln.setOnClickListener {
            var temp = "ln("
            temp += myString
            temp += ")"
            myString = temp
            textview.text = myString
        }

        buttonbackspace.setOnClickListener {
            if(myString.length == 1){
                myString = "0"
            } else{
                myString = myString.dropLast(1)
            }

            textview.text = myString
        }

        buttonclear.setOnClickListener {
            myString = "0"
            textview.text = myString
        }

        buttonequals.setOnClickListener {
            val e = Expression(myString)
            myString = e.calculate().toString()
            textview.text = myString
        }

    }

    fun evaluateExpression(string: String) {
        if(isZnak(myString.last()) && isZnak(string.last())) {
            if(string == "-" && (myString.last() == '/' || myString.last() == '*' || myString.last() == '+')){
                myString += string
                val textview = findViewById<TextView>(R.id.textView3)
                textview.text = myString
            }
            return
        }

        if(myString == "0" &&  (string == "0" || string == "00")){
            return
        }

        if(myString.length == 1 && isZnak(string[0])){
            if(string != "-"){
                return
            }
        }

        if(myString.length == 1 && myString[0] == '0') {
            if(string != "."){
                myString = ""
            }
        }
        myString += string
        val textview = findViewById<TextView>(R.id.textView3)
        textview.text = myString
    }

    fun isZnak(char: Char): Boolean {
        if(char == '+')
            return true;
        if(char == '-')
            return true;
        if(char == 'x')
            return true;
        if(char == '/')
            return true;
        if(char == '.')
            return true;
        if(char == '*')
            return true;
        return false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("expression", myString)
        super.onSaveInstanceState(outState)
    }
}