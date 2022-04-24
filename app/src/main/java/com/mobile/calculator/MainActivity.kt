package com.mobile.calculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var tvinput: TextView
    private lateinit var tvhasil: TextView
    private lateinit var bt0: Button
    private lateinit var bt1: Button
    private lateinit var bt2: Button
    private lateinit var bt3: Button
    private lateinit var bt4: Button
    private lateinit var bt5: Button
    private lateinit var bt6: Button
    private lateinit var bt7: Button
    private lateinit var bt8: Button
    private lateinit var bt9: Button
    private lateinit var btAC: Button
    private lateinit var btplus: Button
    private lateinit var btmin: Button
    private lateinit var btkali: Button
    private lateinit var btbagi: Button
    private lateinit var btpersen: Button
    private lateinit var btpangkat: Button
    private lateinit var btkoma: Button
    private lateinit var bthapus: Button
    private lateinit var bthasil: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvinput = findViewById(R.id.tvinput)
        tvhasil = findViewById(R.id.tvhasil)
        bt0 = findViewById(R.id.bt0)
        bt1 = findViewById(R.id.bt1)
        bt2 = findViewById(R.id.bt2)
        bt3 = findViewById(R.id.bt3)
        bt4 = findViewById(R.id.bt4)
        bt5 = findViewById(R.id.bt5)
        bt6 = findViewById(R.id.bt6)
        bt7 = findViewById(R.id.bt7)
        bt8 = findViewById(R.id.bt8)
        bt9 = findViewById(R.id.bt9)
        btAC = findViewById(R.id.btAC)
        btplus = findViewById(R.id.btplus)
        btmin = findViewById(R.id.btmin)
        btkali = findViewById(R.id.btkali)
        btbagi = findViewById(R.id.btbagi)
        btpersen = findViewById(R.id.btpersen)
        btpangkat = findViewById(R.id.btpangkat)
        btkoma = findViewById(R.id.btkoma)
        bthapus = findViewById(R.id.bthapus)
        bthasil = findViewById(R.id.bthasil)

        bt0.setOnClickListener { tambahinput("0", true) }
        bt1.setOnClickListener { tambahinput("1", true) }
        bt2.setOnClickListener { tambahinput("2", true) }
        bt3.setOnClickListener { tambahinput("3", true) }
        bt4.setOnClickListener { tambahinput("4", true) }
        bt5.setOnClickListener { tambahinput("5", true) }
        bt6.setOnClickListener { tambahinput("6", true) }
        bt7.setOnClickListener { tambahinput("7", true) }
        bt8.setOnClickListener { tambahinput("8", true) }
        bt9.setOnClickListener { tambahinput("9", true) }
        btkoma.setOnClickListener { tambahinput(".", true) }

        btplus.setOnClickListener { tambahinput("+",false) }
        btmin.setOnClickListener { tambahinput("-",false) }
        btkali.setOnClickListener { tambahinput("*",false) }
        btbagi.setOnClickListener { tambahinput("/",false) }
        btpersen.setOnClickListener { tambahinput(")",false) }
        btpangkat.setOnClickListener { tambahinput("(",false) }

        btAC.setOnClickListener {
            tvhasil.text = ""
            tvinput.text = ""
        }
        bthapus.setOnClickListener {
            val string = tvinput.text.toString()
            if (string.isNotEmpty()){
                tvinput.text = string.substring(0,string.length-1)
            }
            tvhasil.text = ""
        }

        bthasil.setOnClickListener {
            try {
                val input = ExpressionBuilder(tvinput.text.toString()).build()
                val hasil = input.evaluate()
                val desimal = hasil.toLong()
                if (hasil == desimal.toDouble()){
                    tvhasil.text = desimal.toString()
                }else{
                    tvhasil.text = hasil.toString()
                }

            }catch (e:Exception){
                Log.d("Exeption","message : " + e.message)
            }
        }
    }



    fun tambahinput (string: String,bisahapus : Boolean){

        if(tvhasil.text.isNotEmpty()){
            tvinput.text =""
        }

        if (bisahapus){
            tvhasil.text = ""
            tvinput.append(string)
        }else{
            tvinput.append(tvhasil.text)
            tvinput.append(string)
            tvhasil.text = ""
        }
    }
}


