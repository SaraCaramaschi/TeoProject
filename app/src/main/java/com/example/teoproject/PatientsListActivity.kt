package com.example.teoproject

import android.annotation.SuppressLint
import android.bluetooth.BluetoothGattCharacteristic
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.teoproject.managers.PatientsManager
import com.example.teoproject.model.Patient
import kotlinx.android.synthetic.main.activity_patients_list.*
import org.jetbrains.anko.*
import java.util.*
import kotlin.collections.ArrayList

//import com.example.cpsproject.databinding.ActivityMainConnectionBinding
//import com.example.cpsproject.databinding.ActivityPatientsList4Binding

class PatientsListActivity : AppCompatActivity() {

    private lateinit var layoutMan: RecyclerView.LayoutManager
    private var patientList:ArrayList<Patient> = PatientsManager.patientsList
    //private lateinit var patientAdapter: RecyclerView.Adapter<PatientAdapter.ViewHolder>
    private val patientAdapter: PatientAdapter by lazy {
        PatientAdapter(patientList) { patient ->
            showPatientOptions(patient)
        }
    }
    //lateinit var rvPatients: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patients_list)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(true)
            title = "BLE Playground"
        }

        setupRecyclerView()

        // set dialog
        val btnNewPatient = findViewById<Button>(R.id.btnNewPatient)
        btnNewPatient.setOnClickListener {
            val intent = Intent(this, AddPatientActivity::class.java)
            startActivity(intent)
            //addInfo()
            }
        }

    private fun setupRecyclerView() {
        rvPatients.apply {
            adapter = patientAdapter
            layoutManager = LinearLayoutManager(
                this@PatientsListActivity,
                RecyclerView.VERTICAL,
                false
            )
            isNestedScrollingEnabled = false
        }

        val animator = rvPatients.itemAnimator
        if (animator is SimpleItemAnimator) {
            animator.supportsChangeAnimations = false
        }
    }

    private fun showPatientOptions(patient: Patient) {
    }

    /*@SuppressLint("InflateParams")
    private fun showWritePayloadDialog(characteristic: BluetoothGattCharacteristic) {
        val hexField = layoutInflater.inflate(R.layout.activity_patient, null) as EditText
        alert {
            customView = hexField
            isCancelable = false
            yesButton {
                with(hexField.text.toString()) {
                    if (isNotBlank() && isNotEmpty()) {
                        val bytes = hexToBytes()
                        log("Writing to ${characteristic.uuid}: ${bytes.toHexString()}")
                        ConnectionManager.writeCharacteristic(device, characteristic, bytes)
                    } else {
                        log("Please enter a hex payload to write to ${characteristic.uuid}")
                    }
                }
            }
            noButton {}
        }.show()
        hexField.showKeyboard()
    }*/


    private fun EditText.showKeyboard() {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        requestFocus()
        inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }
    private fun String.hexToBytes() =
        this.chunked(2).map { it.toUpperCase(Locale.US).toInt(16).toByte() }.toByteArray()
}

    /*private fun addInfo(){
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.activity_add_patient,null)
        // setting the view
        val name = v.findViewById<EditText>(R.id.etName)
        val surname = v.findViewById<EditText>(R.id.etSurname)
        val tax = v.findViewById<EditText>(R.id.etTax)
        val birth = v.findViewById<EditText>(R.id.etBirthDate)
        val notes = v.findViewById<EditText>(R.id.etNotes)

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)
        addDialog.setPositiveButton("Add patient"){
                dialog,_->
            val nomi = name.text.toString()
            val cognomi = surname.text.toString()
            val note = notes.text.toString()
            val data = birth.text.toString()
            val tax = tax.text.toString()
            patientList.add(Patient("Name: $nomi","Surname: $cognomi","Notes: $note", "Tax: $tax", "Data: $data"))
            patientAdapter.notifyDataSetChanged()
            Toast.makeText(this,"Adding User Information Success",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()
    }*/
}
