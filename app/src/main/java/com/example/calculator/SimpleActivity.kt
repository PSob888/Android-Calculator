package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression

class SimpleActivity : AppCompatActivity() {
    private var myString = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
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
        if(isZnak(myString.last()) && isZnak(string.last())) {
            if(string == "-" && (myString.last() == '/' || myString.last() == '*' || myString.last() == '+')){
                myString += string
                val textview = findViewById<TextView>(R.id.textView3)
                textview.text = myString
            }
            return
        }

        if(myString == "0" && (string == "0" || string == "00")){
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
        return false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("expression", myString)
        super.onSaveInstanceState(outState)
    }
}