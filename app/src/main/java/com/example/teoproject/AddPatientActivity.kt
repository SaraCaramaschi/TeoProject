package com.example.teoproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.teoproject.managers.PatientsManager
import com.example.teoproject.model.Patient
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_add_patient.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

import java.io.File


const val NOME = "name"
const val COGNOME = "surname"
const val TAX = "tax"
const val COMPLE = "birth"
const val NOTE = "notes"


class AddPatientActivity : AppCompatActivity() {
    private lateinit var addName: TextInputEditText
    private lateinit var addSurname: TextInputEditText
    private lateinit var addTax: TextInputEditText
    private lateinit var addBirth: TextInputEditText
    private lateinit var addNotes: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_patient)

        //TODO i text rossi qui sotto dovrebbero essere delle caselle di testo nella pagina del singolo pz
        //chFemale.setOnCheckedChangeListener{buttonView, isChecked ->
          //  if(isChecked==true) {
            //    textview.setText("Female")
            //}
            //chMale.setOnCheckedChangeListener{buttonView, isChecked ->
              //  if(isChecked==true) {
                //    textview.setText("Male")

// CAPIRE COSA FARE NELLA ACTIVITY PER GLI SPINNER
           // val gender: Gender
            //spinnerGender.adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,gender)
            //ArrayAdapter<CharSequence>() adapter=Arrayadapter.createfrom


        // Activity related to the button add patient
        /*btnAddPat.setOnClickListener {
            if (etName.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Name required", Toast.LENGTH_SHORT).show();
                //etName.error = "Name Required";
                return@setOnClickListener
            } else if(etSurname.text.toString().trim().isEmpty()) {
                etSurname.error = "Surname Required"
                return@setOnClickListener
            }else if (etTax.text.toString().trim().isEmpty()) {
                etTax.error = "Tax Code Required"
                return@setOnClickListener
            } else if (etTax.text.toString().trim().length!=16){
                etTax.error="Tax Code not correct"
                return@setOnClickListener
            }

            // Add patient
            PatientsManager.addPatient(
                    Patient(etName.text.toString(), etSurname.text.toString(),
                    etNotes.text.toString(), etTax.text.toString(), etBirthDate.text.toString()) )


            // Json Creation (lo stampa ok)
            PatientsManager.createJson(
                        Patient(etName.text.toString(), etSurname.text.toString(), etNotes.text.toString(),
                        etTax.text.toString(), etBirthDate.text.toString()))

            // Json saving
            //PatientsManager.saveJson(json) // qui json è di tipo string!


        }

        //TODO NON SO SE VA MESSO QUI O IN PATIENTSMANAGER (E MOLTI ALTRI DUBBI)
        // PARTE DI GINEVRA TRASPORTATA IN PATIENT MANAGER IN FUNZIONE CREATEJSON
        /*var newpatient = patientsList.last()
        val gson= Gson()
        //AGGIUNGO VARIABILE NEWPATIENT O CONSIDERO TUTTA LA LISTA?: val jsonList= gson.toJson(PatientsManager.patientsList, new Filewriter(JsonList))
        val jsonList= gson.toJson(newpatient)

        //COME CREO FILE IN CUI SALVARE IL JSON? HO CREATO PACKAGE IN CPSPROJECT
        File("JsonFiles").writeText(jsonList)
        */

        /*Timber.d(PatientsManager.patientsList.elementAt(0).name)
        Timber.d(PatientsManager.patientsList.elementAt(0).surname)
        Timber.d(PatientsManager.patientsList.elementAt(0).notes)
        Timber.d(PatientsManager.patientsList.elementAt(0).taxcode)
         */

         */

        btnAddPat.setOnClickListener {
            addPatient()
        }
        addName = findViewById(R.id.etName)
        addSurname = findViewById(R.id.etSurname)
        addTax = findViewById(R.id.etTax)
        addBirth = findViewById(R.id.etBirthDate)
        addNotes = findViewById(R.id.etNotes)

    }
    private fun addPatient() {
        val resultIntent = Intent()
        val name = addName.text.toString()
        val surname = addSurname.text.toString()
        val tax = addTax.text.toString()
        val birth = addBirth.text.toString()
        val notes = addNotes.text.toString()

        /*
const val NOME = "name"
const val COGNOME = "surname"
const val TAX = "tax"
const val COMPLE = "birth"
const val NOTE = "notes"
         */
        resultIntent.putExtra(NOME, name)
        resultIntent.putExtra(COGNOME, surname)
        resultIntent.putExtra(TAX, tax)
        resultIntent.putExtra(COMPLE, birth)
        resultIntent.putExtra(NOTE, notes)

        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}




// https://www.youtube.com/watch?v=y4npeX35B34 TOP VIDEOOOOOOOOOOOOOOOOOO, si ma per firebase
