package mx.itson.edu.practica5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class detalle_pelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val iv_pelicula_image: ImageView = findViewById<ImageView>(R.id.iv_pelicula_imagen)
        val tv_nombre_pelicula: TextView = findViewById<TextView>(R.id.tv_nombre_pelicula)
        val tv_pelicula_desc: TextView = findViewById<TextView>(R.id.tv_pelicula_desc)
        val seatsLeft: TextView = findViewById<TextView>(R.id.seatLeft)
        val buyTickets: Button = findViewById<Button>(R.id.buyTickets)

        val bundle=intent.extras
        if(bundle!=null){
            iv_pelicula_image.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("titulo"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))

            val seats = bundle.getInt("seats")
            seatsLeft.text = "Seats available: $seats"

            buyTickets.setOnClickListener {

                val intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("titulo", bundle.getString("titulo"))
                intent.putExtra("seats", seats)

                startActivity(intent)
            }
        }
    }
}