package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

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
        val buttonpi = findViewById<Button>(R.id.buttonpi)
        val buttonlnawias = findViewById<Button>(R.id.buttonpnawias)
        val buttonpnawias = findViewById<Button>(R.id.buttonlnawias)
        val buttonpercent = findViewById<Button>(R.id.buttonpercent)
        val buttonxdoy = findViewById<Button>(R.id.buttonxy)
        val buttonclear = findViewById<Button>(R.id.buttonclear)
        val buttonbackspace = findViewById<Button>(R.id.buttonbackspace)
        val buttonequals = findViewById<Button>(R.id.buttonequals)
        val textview = findViewById<TextView>(R.id.textView3)

        if (savedInstanceState != null) {
            myString = savedInstanceState.getString("expression").toString()
            textview.text = myString
        }

        buttonzero.setOnClickListener {
            addToString("0")
        }

        buttonzeros.setOnClickListener {
            addToString("00")
        }

        buttondot.setOnClickListener {
            addToString(".")
        }

        buttonone.setOnClickListener {
            addToString("1")
        }

        buttontwo.setOnClickListener {
            addToString("2")
        }

        buttonthree.setOnClickListener {
            addToString("3")
        }

        buttonfour.setOnClickListener {
            addToString("4")
        }

        buttonfive.setOnClickListener {
            addToString("5")
        }

        buttonsix.setOnClickListener {
            addToString("6")
        }

        buttonseven.setOnClickListener {
            addToString("7")
        }

        buttoneight.setOnClickListener {
            addToString("8")
        }

        buttonnine.setOnClickListener {
            addToString("9")
        }

        buttonplus.setOnClickListener {
            addToString("+")
        }

        buttonminus.setOnClickListener {
            addToString("-")
        }

        buttonmultiply.setOnClickListener {
            addToString("*")
        }

        buttondivide.setOnClickListener {
            addToString("/")
        }

        buttonpower.setOnClickListener {
            addToString("^2")
            val e = Expression(myString)
            myString = e.calculate().toString()
            textview.text = myString
        }

        buttonsin.setOnClickListener {
            if(isZnak(myString.last())){
                addToString("sin(")
            }
            else{
                var temp = "sin("
                temp += myString
                temp += ")"
                myString = temp
            }
            textview.text = myString
        }

        buttoncos.setOnClickListener {
            if(isZnak(myString.last())){
                addToString("cos(")
            }
            else{
                var temp = "cos("
                temp += myString
                temp += ")"
                myString = temp
            }
            textview.text = myString
        }

        buttontg.setOnClickListener {
            if(isZnak(myString.last())){
                addToString("tg(")
            }
            else{
                var temp = "tg("
                temp += myString
                temp += ")"
                myString = temp
            }
            textview.text = myString
        }

        buttonsqrt.setOnClickListener {
            if(isZnak(myString.last())){
                addToString("sqrt(")
            }
            else{
                var temp = "sqrt("
                temp += myString
                temp += ")"
                myString = temp
            }
            textview.text = myString
        }

        buttonln.setOnClickListener {
            if(isZnak(myString.last())){
                addToString("ln(")
            }
            else{
                var temp = "ln("
                temp += myString
                temp += ")"
                myString = temp
            }
            textview.text = myString
        }

        buttonpi.setOnClickListener {
            addToString("pi")
            textview.text = myString
        }

        buttonlnawias.setOnClickListener {
            addToString(")")
            textview.text = myString
        }

        buttonpnawias.setOnClickListener {
            addToString("(")
            textview.text = myString
        }

        buttonxdoy.setOnClickListener {
            addToString("^")
            textview.text = myString
        }

        buttonpercent.setOnClickListener {
            addToString("%")
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
            if(myString == "NaN"){
                myString = "0"
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Błąd")
                builder.setMessage("Operacja nie możliwa do wykonania")

                builder.setPositiveButton(android.R.string.yes) { dialog, which ->}
                builder.show()
            }
            textview.text = myString
        }

    }

    fun addToString(string: String) {
        if(isZnak(myString.last()) && isZnak(string.first())) {
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
        if(char == '^')
            return true;
        return false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("expression", myString)
        super.onSaveInstanceState(outState)
    }
}