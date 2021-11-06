package com.example.teoproject

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.bluetooth.BluetoothGattCharacteristic
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.teoproject.managers.PatientsManager
import com.example.teoproject.model.Patient
import kotlinx.android.synthetic.main.activity_add_patient.view.*
import org.jetbrains.anko.layoutInflater

class PatientAdapter(
    private val items: ArrayList<Patient>,
    private val onClickListener: ((patient: Patient) -> Unit)
): RecyclerView.Adapter<PatientAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.context.layoutInflater.inflate(
            R.layout.activity_patient,
            parent,
            false
        )
        return ViewHolder(view, onClickListener)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ViewHolder(
        private val view: View,
        private val onClickListener: ((patient: Patient) -> Unit)
    ) : RecyclerView.ViewHolder(view) {

        fun bind(patient: Patient) {
            patient.name.also { view.etName.text }
            patient.surname.also { view.etSurname.text }

        }
    }
}

/* VERSIONE OK NON AUTOMATICA
     private var patientsName = arrayOf("Mario Rossi", "Alfonso Maisano","Vittoria Attolini","Lino Piso","Mario Rossi", "Alfonso Maisano","Vittoria Attolini","Lino Piso")
     private var patientsPhase = arrayOf("Phase1","Phase1","Phase2","Phase 1","Phase1","Phase1","Phase2","Phase 1")
     private var patientsItems = intArrayOf(R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user)

    //lateinit var patientsName: ArrayList<String>
    //lateinit var patientsSurname: ArrayList<String>
    //lateinit var patientsPhase: ArrayList<String>

     var patientList: MutableList<Patient> = PatientsManager.patientsList


    inner class ViewHolder(itemView: View ): RecyclerView.ViewHolder(itemView){
        // scopo: prendere oggetto dalla lista creata e mostrarlo al recycler view
        var itemImage: ImageView
        var itemName: TextView
        var itemPhase: TextView

        init{
            itemImage = itemView.findViewById(R.id.imageView)
            itemName = itemView.findViewById(R.id.PatientName)
            itemPhase = itemView.findViewById(R.id.PatientPhase)

            itemView.setOnClickListener{
                /*val position: Int = adapterPosition
                Toast.makeText(itemView.context, "you clicked on ${patientsName[position]} ", Toast.LENGTH_LONG).show()
                // codice che fa passare a profilo del paziente*/
                //popupmenus(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_patient, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: PatientAdapter.ViewHolder, position: Int) {
        holder.itemName.text = patientsName[position]
        holder.itemPhase.text = patientsPhase[position]
        holder.itemImage.setImageResource(patientsItems[position])
    }

    override fun getItemCount(): Int {
       return patientsName.size
    }
}
 VERSIONE OK NON AUTOMATICA */


/*
class PatientAdapter(private val onClick: (Patient) -> Unit) :
        RecyclerView.Adapter<PatientAdapter.PatientViewHolder>() {
        //ListAdapter<PatientAdapter.PatientViewHolder>(PatientDiffCallback) {

        /* ViewHolder for Flower, takes in the inflated view and the onClick behavior. */
        class PatientViewHolder(itemView: View, val onClick: (Patient) -> Unit) :
            RecyclerView.ViewHolder(itemView) {
            private val nameTextView: TextView = itemView.findViewById(R.id.etName)
            private var currentPatient: Patient? = null

            init {
                itemView.setOnClickListener {
                    currentPatient?.let {
                        onClick(it)
                    }
                }
            }

            /* Bind flower name and image. */
            fun bind(patient: Patient) {
                currentPatient = patient
                nameTextView.text = patient.name
            }
        }

        /* Creates and inflates view and return FlowerViewHolder. */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_add_patient, parent, false)
            return PatientViewHolder(view, onClick)
        }

        /* Gets current flower and uses it to bind view. */
        override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
            val patient: Patient = getItem(position)
            holder.bind(patient)
        }
    }

object PatientDiffCallback : DiffUtil.ItemCallback<Patient>() {
    override fun areItemsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.name == newItem.name
    }*/
