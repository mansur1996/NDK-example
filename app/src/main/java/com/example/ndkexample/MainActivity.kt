package com.example.ndkexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ndkexample.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var result: Int? = null
    private var number1: Int? = null
    private var number2: Int? = null
    private var operation: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        result = 0
        number1 = 0
        number2 = 0
        operation = 0
        initViews()
    }

    private fun initViews() {
        // Example of a call to a native method
        continueGame()
        binding.btnCheck.setOnClickListener {
            if(binding.etResult.text.isNotEmpty()){
                if(binding.etResult.text.toString().toInt() == result){
                    continueGame()
                    binding.etResult.setText("")
                    Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show()
                }else{
                    binding.etResult.setText("")
                    Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun continueGame() {
        number1 = randomNumber(15)
        number2 = randomNumber(10)
        binding.number1.text = number1.toString()
        binding.number2.text = number2.toString()
        operation = randomNumber(4)

        when(operation){
            0->{
                binding.operation.text = " + "
                result = add(number1!!, number2!!)
            }
            1->{
                binding.operation.text = " - "
                result = sub(number1!!, number2!!)
            }
            2->{
                binding.operation.text = " * "
                result = mult(number1!!, number2!!)
            }
            else->{
                binding.operation.text = " / "
                result = div(number1!!, number2!!)
            }
        }
    }

    /**
     * A native method that is implemented by the 'ndkexample' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun add(a : Int, b : Int): Int
    external fun sub(a : Int, b : Int): Int
    external fun mult(a : Int, b : Int): Int
    external fun div(a : Int, b : Int): Int
    external fun randomNumber(a : Int): Int

    companion object {
        // Used to load the 'ndkexample' library on application startup.
        init {
            System.loadLibrary("ndkexample")
        }
    }
}