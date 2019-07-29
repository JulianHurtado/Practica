package com.example.ejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

import java.text.DecimalFormat


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var moption: Spinner
    lateinit var result: TextView

    lateinit var moneynum : EditText // = etCantidad.text.toString()

    var nupesos:Double = 0.0
    //nupesos = 0.0
    var nudollar = 0.0
    var nueuro = 0.0
    var nulibra = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moption = findViewById(R.id.spinner1) as Spinner
        result = findViewById(R.id.txResult) as TextView


        moneynum =  etCantidad

        spinner1!!.setOnItemSelectedListener(this)


        val moptions = ArrayAdapter.createFromResource(this, R.array.moneyOptions, android.R.layout.simple_spinner_item)
        moptions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1!!.setAdapter(moptions)

        bnConverter.setOnClickListener{

            nmpesos.text= nupesos.toString()
            //nmdollars.text= ("%.2d".format(nudollar.toString()))
            nmdollars.text= nudollar.toString()
            nmeuros.text= nueuro.toString()
            nmlibras.text= nulibra.toString()
        }

     }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
        result!!.text = getResources().getStringArray(R.array.moneyOptions)[position]

        var moneytex = txResult.text.toString()
        //var pesos1 = (df.format(moneytex))

        if (moneynum.text.toString().equals("") == false ) {

            when (result.id) {
                R.id.txResult ->

                    if (moneytex.equals("Pesos")) {

                        nupesos = (moneynum.text.toString().toDouble() * 1)
                        nudollar = moneynum.text.toString().toDouble() * 0.00031
                        nueuro = moneynum.text.toString().toDouble() * 0.00028
                        nulibra = moneynum.text.toString().toDouble() * 0.00025

                    } else if (moneytex.equals("Dollars")) {

                        nupesos = (moneynum.text.toString().toDouble() * 3241)
                        nudollar = moneynum.text.toString().toDouble() * 1
                        nueuro = moneynum.text.toString().toDouble() * 0.9
                        nulibra = moneynum.text.toString().toDouble() * 0.82

                    } else if (moneytex.equals("Euros")) {

                        nupesos = (moneynum.text.toString().toDouble() * 3605)
                        nudollar = moneynum.text.toString().toDouble() * 1.11
                        nueuro = moneynum.text.toString().toDouble() * 1
                        nulibra = moneynum.text.toString().toDouble() * 0.91

                    } else if (moneytex.equals("Libras")) {

                        nupesos = (moneynum.text.toString().toDouble() * 3972)
                        nudollar = moneynum.text.toString().toDouble() * 1.23
                        nueuro = moneynum.text.toString().toDouble() * 1.1
                        nulibra = moneynum.text.toString().toDouble() * 1

                    }


            }
        }

    }

    override fun onNothingSelected(arg0: AdapterView<*>) {
        result!!.text = ""
    }
}



