package com.example.teoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teoproject.model.Patient
import org.jetbrains.anko.intentFor

//import com.example.cpsproject.databinding.ActivityMainConnectionBinding
//import com.example.cpsproject.databinding.ActivityPatientsList4Binding

class PatientsListActivity : AppCompatActivity() {

    private lateinit var layoutMan: RecyclerView.LayoutManager
    private lateinit var patientAdapter: RecyclerView.Adapter<PatientAdapter.ViewHolder>
    lateinit var rvPatients: RecyclerView
    private lateinit var patientList:ArrayList<Patient>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patients_list)

        layoutMan = LinearLayoutManager(this)
        rvPatients = findViewById<RecyclerView>(R.id.rvPatients)
        rvPatients.layoutManager = layoutMan
        patientAdapter = PatientAdapter()
        rvPatients.adapter = patientAdapter

        // set dialog
        val btnNewPatient = findViewById<Button>(R.id.btnNewPatient)
        btnNewPatient.setOnClickListener {
            val intent = Intent(this, AddPatientActivity::class.java)
            startActivity(intent)
            //addInfo()
            }
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
