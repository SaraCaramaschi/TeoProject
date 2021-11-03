package com.example.teoproject.managers

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.teoproject.PatientAdapter
import com.example.teoproject.model.Patient
import com.google.gson.Gson

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectOutputStream


object PatientsManager {

    /*private fun writeObject(stream: ObjectOutputStream){
        throw IOException
        https://developer.android.com/reference/kotlin/java/io/ObjectOutputStream
    }*/

    public var patientsList: MutableList<Patient> = ArrayList()

    public fun addPatient(patient: Patient) {
        //patientsList.add(patient)
/*
        const val NOME = "name"
        const val COGNOME = "surname"
        const val TAX = "tax"
        const val COMPLE = "birth"
        const val NOTE = "notes"

 */

    }



    public fun createJson(patient: Patient) {
        val json = Json.encodeToString(patient)
        Log.d("This is the json data:", json)
    }

    public fun saveJson(json: String){
        /*
        val fos = FileOutputStream("t.tmp")
        val oos = ObjectOutputStream(fos)

        oos.writeObject("Today")
        oos.close()*/
    }



    public fun fillData() {}

}