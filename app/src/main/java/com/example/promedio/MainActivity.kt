package com.example.promedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.promedio.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    val pass = "PASS"
    val notPass = "NOT PASS"
    val error = "ERROR"

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        /*Llamada al boton de envio*/
        send()
        /*Llamada del boton reset*/
        reset()
    }
    //Función designada para el botón reset
    private fun reset() {
        binding.btnReset.setOnClickListener {
            binding.firstGrade.text = null
            binding.secondGrade.text = null
            binding.thirdGrade.text = null
            binding.fourthGrade.text = null
            binding.fifthGrade.text = null
            binding.grade.text = null
            binding.status.text = null

        }
    }
    //Función designada para el boton send
    private fun send() {
        binding.btnSend.setOnClickListener {
            /*Llamada de vistas */
            val firstGrade = binding.firstGrade.text.toString()
            val secondGrade = binding.secondGrade.text.toString()
            val thirdGrade = binding.thirdGrade.text.toString()
            val fourthGrade = binding.fourthGrade.text.toString()
            val fifthGrade = binding.fifthGrade.text.toString()


            /*Conversión de vistas a flotantes*/
            val fgf = firstGrade.toFloat()
            val sgf = secondGrade.toFloat()
            val tgf = thirdGrade.toFloat()
            val fogf = fourthGrade.toFloat()
            val figf = fifthGrade.toFloat()

            //código de la lógica
            if ((fgf in 0.0..10.0) && (sgf in 0.0..10.0) && (tgf in 0.0..10.0) && (fogf in 0.0..10.0) && (figf in 0.0..10.0)) {
                val sum = fgf + sgf + tgf + fogf + figf
                val num: Float = 5.0f
                val average = sum / num
                val averageString = average.toString()

                if (average >= 6.0) {
                    binding.grade.text = averageString
                    binding.status.text = pass
                } else {
                    binding.grade.text = averageString
                    binding.status.text = notPass
                }
            } else {
                binding.status.text = error
            }
        }
    }
}