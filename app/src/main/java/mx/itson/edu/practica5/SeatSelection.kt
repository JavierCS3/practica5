package mx.itson.edu.practica5

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.inappmessaging.model.Text

class SeatSelection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val title: TextView = findViewById(R.id.titleSeats)
        val confirm: Button = findViewById(R.id.confirm)

        var posMovie = -1

        val bundle = intent.extras
        if (bundle != null) {
            title.text = bundle.getString("name")
            posMovie = bundle.getInt("id")
        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        val rows = listOf(row1, row2, row3, row4)

        row1.setOnCheckedChangeListener { _, checkedId -> if (checkedId > -1) {
            row2.clearCheck()
            row3.clearCheck()
            row4.clearCheck()
        }
        }

        row2.setOnCheckedChangeListener { _, checkedId -> if (checkedId > -1) {
            row1.clearCheck()
            row3.clearCheck()
            row4.clearCheck()
        }
        }

        row3.setOnCheckedChangeListener { _, checkedId -> if (checkedId > -1) {
            row1.clearCheck()
            row2.clearCheck()
            row4.clearCheck()
        }
        }

        row4.setOnCheckedChangeListener { _, checkedId -> if (checkedId > -1) {
            row1.clearCheck()
            row2.clearCheck()
            row3.clearCheck()
        }
        }

        confirm.setOnClickListener {

            var selectedRadio: RadioButton? = null

            for (row in rows) {
                if (row.checkedRadioButtonId != -1) {
                    selectedRadio = findViewById(row.checkedRadioButtonId)
                    break
                }
            }

            if (selectedRadio != null) {

                selectedRadio.isEnabled = false
                selectedRadio.setBackgroundResource(R.drawable.radio_disabled)

                Toast.makeText(this, "Enjoy the movie! :D", Toast.LENGTH_LONG).show()


            } else {
                Toast.makeText(this, "Select a seat first", Toast.LENGTH_SHORT).show()
            }
        }
    }
}