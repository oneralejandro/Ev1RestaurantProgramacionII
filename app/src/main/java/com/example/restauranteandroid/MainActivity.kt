package com.example.restauranteandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var editTextPastelCantidad: EditText
    lateinit var textViewPastelTotal: TextView
    lateinit var textViewTotalPastel: TextView
    lateinit var editTextCazuelaCantidad: EditText
    lateinit var txtViewCazuelaTotal: TextView
    lateinit var button2: Button
    lateinit var textViewTotal2Comidas: TextView
    private var switchPropina: Switch? = null
    private var conPropina = false
    lateinit var txtViewTotal2ComidasConPropina: TextView
    lateinit var  txtViewValorPropina: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editTextCazuelaCantidad = findViewById(R.id.editTextCazuelaCantidad)
        txtViewCazuelaTotal = findViewById(R.id.txtViewCazuelaTotal)
        editTextPastelCantidad = findViewById(R.id.editTextPastelCantidad)
        textViewTotalPastel = findViewById(R.id.textViewTotalPastel)
        txtViewTotal2ComidasConPropina = findViewById(R.id.txtViewTotal2ComidasConPropina)
        txtViewValorPropina = findViewById((R.id.txtViewValorPropina))



        //button2 = findViewById(R.id.button2)

        //button2.setOnClickListener {

          //  totalComida()

        //}

        val textWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                mostrarTotalPastel()



            }

        }

        editTextPastelCantidad.addTextChangedListener(textWatcher)



        val textWatcher2:TextWatcher = object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                    mostrarTotalCazuela()




            }

        }
        editTextCazuelaCantidad.addTextChangedListener(textWatcher2)


        val textWatcher3: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                    totalComida()

            }

        }

        txtViewCazuelaTotal.addTextChangedListener(textWatcher3)

    }




    private fun mostrarTotalPastel(){

        val V = Integer.parseInt(editTextPastelCantidad.text.toString())
        textViewTotalPastel.setText(""+CalculoTotalPastel(V))

    }


    private fun mostrarTotalCazuela(){
        val I = Integer.parseInt(editTextCazuelaCantidad.text.toString())
        txtViewCazuelaTotal.setText(""+CalculoTotalCazuela(I))
    }





    fun CalculoTotalPastel(cantidad: Int ): Int{
        return 12000 * cantidad
    }

    fun CalculoTotalCazuela(cantidad: Int):Int{
        return 10000 * cantidad

    }


    private fun totalComida(){



        val textViewTotalPastel: TextView = findViewById(R.id.textViewTotalPastel)
        val txtViewCazuelaTotal: TextView = findViewById(R.id.txtViewCazuelaTotal)

        val totalPastelSTR  = textViewTotalPastel.text.toString()
        val totalCazuelaSTR = txtViewCazuelaTotal.text.toString()

        val totalPastel = totalPastelSTR.toInt()
        val totalCazuela = totalCazuelaSTR.toInt()

        val resultado = totalPastel + totalCazuela
        val ValorPropina = ((totalPastel + totalCazuela) / 100) * 10

        val switchPropina = findViewById<Switch>(R.id.switchPropina )
        switchPropina.setOnCheckedChangeListener{_, isChecked ->
            if (isChecked){
                val propina = ((totalPastel + totalCazuela) / 100) * 10
                val resultado = totalPastel + totalCazuela + propina
                val txtViewTotal2Comidas: TextView = findViewById(R.id.txtViewTotal2ComidasConPropina)
                txtViewTotal2Comidas.text = "Total comida con propina: $resultado "
            }else{
                val propina = ((totalPastel + totalCazuela) / 100) * 10
                val resultado = totalPastel + totalCazuela
                val txtViewTotal2Comidas: TextView = findViewById(R.id.txtViewTotal2ComidasConPropina)
                txtViewTotal2Comidas.text = "Total comida con propina: $resultado "
            }

        }

        val txtViewTotal2Comidas: TextView = findViewById(R.id.txtViewTotal2Comidas)
        txtViewTotal2Comidas.text = "Total solo comida: $resultado "

        val txtViewValorPropina: TextView = findViewById(R.id.txtViewValorPropina)
        txtViewValorPropina.text = "Total solo propina : $ValorPropina "


    }






}