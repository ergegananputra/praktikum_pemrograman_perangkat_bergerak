 package com.ppb.tugaspertemuan6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.ppb.tugaspertemuan6.databinding.ActivityMainBinding
import java.util.Calendar

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val dropdownKehadiran = resources.getStringArray(R.array.status_kehadiran)
        val namaBulan = resources.getStringArray(R.array.nama_bulan)

        with(binding) {

            // initialize value
            var time ="${timePicker.hour}:${timePicker.minute}"
            val _tempCalendar : Calendar = Calendar.getInstance()
            _tempCalendar.timeInMillis = System.currentTimeMillis()
            var date = "${_tempCalendar.get(Calendar.DAY_OF_MONTH)} ${namaBulan[_tempCalendar.get(Calendar.MONTH)]} ${_tempCalendar.get(Calendar.YEAR)}"


            spinnerStatusKehadiran.adapter = ArrayAdapter<String>(
                this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item,
                dropdownKehadiran
            )


            spinnerStatusKehadiran.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (dropdownKehadiran[position] == "Sakit"){
                        editTextKeterangan.visibility = View.VISIBLE
                    } else {
                        editTextKeterangan.visibility = View.GONE
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

            timePicker.setOnTimeChangedListener { _, hourOfDay, minute->
                val hour = hourOfDay.toString()
                val minutes = minute.toString()
                time = "$hour:$minutes"

            }


            calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
                date = "$dayOfMonth ${namaBulan[month]} $year"
            }


            buttonSubmit.setOnClickListener{
                Toast.makeText(this@MainActivity, "Presensi berhasil $date jam $time", Toast.LENGTH_SHORT).show()

            }




        }
    }
}