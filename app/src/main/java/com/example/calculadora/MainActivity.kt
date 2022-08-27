package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Variable inicializada
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root) /// bindig permite tener acceso a las vistas

        var operation = 0
        var var1 = ""
        var result: String

        binding.button0.setOnClickListener { concatenar("0") }
        binding.button1.setOnClickListener { concatenar("1") }
        binding.button2.setOnClickListener { concatenar("2") }
        binding.button3.setOnClickListener { concatenar("3") }
        binding.button4.setOnClickListener { concatenar("4") }
        binding.button5.setOnClickListener { concatenar("5") }
        binding.button6.setOnClickListener { concatenar("6") }
        binding.button7.setOnClickListener { concatenar("7") }
        binding.button8.setOnClickListener { concatenar("8") }
        binding.button9.setOnClickListener { concatenar("9") }
        binding.buttonPoint.setOnClickListener { concatenar(".") }

        // Calculo operacional
        // SUMA
        binding.add.setOnClickListener {
            operation = 1
            var1 = addoperation().toString()
        }
        // Resta
        binding.subtract.setOnClickListener {
            operation = 2
            var1 = subtractoperation().toString()
         }
        // multiplicacion
        binding.multiply.setOnClickListener {
            operation = 3
            var1 = multiplyOperation().toString()
        }
        // Division
        binding.division.setOnClickListener {
            operation = 4
            var1 = divisionOperation().toString()
        }

        // Resultado

        binding.equal.setOnClickListener {

            var result = equal(operation,var1).toString()
            binding.parameter.text = result.toString()


            binding.add.isEnabled = true
            binding.subtract.isEnabled = true
            binding.division.isEnabled = true
            binding.multiply.isEnabled = true
        }

        // Reseteo

        binding.reset.setOnClickListener {
            binding.parameter.text = ""
            operation  = 0
            binding.add.isEnabled = true
            binding.subtract.isEnabled = true
            binding.division.isEnabled = true
            binding.multiply.isEnabled = true
        }

    }

    private fun divisionOperation():CharSequence? {
        val var1 = binding.parameter.text

        binding.parameter.text = ""

        binding.add.isEnabled = false
        binding.subtract.isEnabled = false
        binding.multiply.isEnabled = false

        return var1
    }

    private fun multiplyOperation(): CharSequence? {
        val var1 = binding.parameter.text

        binding.parameter.text = ""

        binding.add.isEnabled = false
        binding.subtract.isEnabled = false
        binding.division.isEnabled = false

        return var1
    }

    private fun subtractoperation(): CharSequence? {
        val var1 = binding.parameter.text

        binding.parameter.text = ""

        binding.add.isEnabled = false
        binding.division.isEnabled = false
        binding.multiply.isEnabled = false

        return var1
    }



    private fun addoperation(): CharSequence? {
        val var1 = binding.parameter.text

        binding.parameter.text = ""

        binding.subtract.isEnabled = false
        binding.division.isEnabled = false
        binding.multiply.isEnabled = false

        return var1

    }

    private fun concatenar(s: String) {
        binding.parameter.text = "${binding.parameter.text}${s}"
    }

    private fun equal(operation: Int, a: String): Float {

        var var1 = a.toFloat()
        val var2 = binding.parameter.text.toString().toFloat()

        return when (operation) {
            1 -> var1 + var2
            2 -> var1 - var2
            3 -> var1 * var2
            4 -> var1 / var2
            else -> 0.0F
        }
    }

}