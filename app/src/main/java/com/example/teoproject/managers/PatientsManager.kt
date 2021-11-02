package com.example.teoproject.managers

import android.content.Context.MODE_PRIVATE
import android.util.Log
import android.widget.Toast
import com.example.teoproject.model.Patient
import com.google.gson.Gson

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileOutputStream


object PatientsManager {
    public var patientsList: ArrayList<Patient> = ArrayList()

    public fun addPatient(patient: Patient){
        patientsList.add(patient)
    }

    public fun createJson(patient: Patient) {
        val json = Json.encodeToString(patient)
        Log.d("This is the json data:", json) // LO STAMPA OK SUPER !

        val file = File(System.getProperty("user.home"), "paziente.js")
        var fileName = "paziente.js"
        var fileDirectory = "/Users/saracaramaschi/SecondoAnnoM/"
        var filepath = "/Users/saracaramaschi/SecondoAnnoM/paziente.js"

        /*
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(filepath, MODE_PRIVATE) // sbagliato qui attenzione: filepath non è un path
            fileOutputStream.write(json.toByteArray())
            fileOutputStream.close()

        }catch (e: Exception){
            e.printStackTrace()
        }
        Toast.makeText(applicationContext,"data save",Toast.LENGTH_LONG).show()
        */
    }

}