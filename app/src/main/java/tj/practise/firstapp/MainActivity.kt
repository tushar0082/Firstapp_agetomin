package tj.practise.firstapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var datetext:TextView?=null
    private var agemin:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btndatepicker:Button=findViewById(R.id.button)
        datetext=findViewById(R.id.datetext)
        agemin=findViewById(R.id.agemin)

        btndatepicker.setOnClickListener{
            this.clickDatepicker()


        }
    }
    fun clickDatepicker()
    {
        val mycalendar=Calendar.getInstance()
        val year=mycalendar.get(Calendar.YEAR)
        val month=mycalendar.get(Calendar.MONTH)
        val day=mycalendar.get(Calendar.DAY_OF_MONTH)

        val obj=DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view,Year,Month,Day->

                val selecteddate="$Day/${Month+1}/$Year"
                datetext?.text = selecteddate

                val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val thedate=sdf.parse(selecteddate)

                //Toast.makeText(this, selecteddate,Toast.LENGTH_LONG).show()

                val selecteddateinmin=thedate.time/60000
                val currentdate=((sdf.parse(sdf.format(System.currentTimeMillis()))).time)/60000
                //Toast.makeText(this, currentdate.toString(),Toast.LENGTH_LONG).show()

                val diff=currentdate-selecteddateinmin

                agemin?.text = diff.toString()
                //hello




            },year,month,day)
        obj.datePicker.maxDate=System.currentTimeMillis()-86400000

        obj.show()

    }
}
