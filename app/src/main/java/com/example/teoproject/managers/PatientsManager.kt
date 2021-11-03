package com.example.teoproject.managers

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.util.Log
import android.widget.Toast
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

    public var patientsList: ArrayList<Patient> = ArrayList()

    public fun addPatient(patient: Patient){
        patientsList.add(patient)
    }


    public fun createJson(patient: Patient) {
        val json = Json.encodeToString(patient)
        Log.d("This is the json data:", json) // LO STAMPA OK SUPER !

        /*
        val fos = FileOutputStream("t.tmp")
        val oos = ObjectOutputStream(fos)

        oos.writeObject("Today")
        oos.close()*/
    }

}