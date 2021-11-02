package com.example.teoproject

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.teoproject.managers.PatientsManager.patientsList

class PatientAdapter: RecyclerView.Adapter<PatientAdapter.ViewHolder>() {

     private var patientsName = arrayOf("Mario Rossi", "Alfonso Maisano","Vittoria Attolini","Lino Piso","Mario Rossi", "Alfonso Maisano","Vittoria Attolini","Lino Piso")
     private var patientsPhase = arrayOf("Phase1","Phase1","Phase2","Phase 1","Phase1","Phase1","Phase2","Phase 1")
     private var patientsItems = intArrayOf(R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user)


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
                popupmenus(it)
            }
        }

        // https://github.com/farida-techie/EditDeleteItem/blob/master/app/src/main/java/com/malkinfo/editingrecyclerview/view/UserAdapter.kt
        @SuppressLint("ResourceType")
        private fun popupmenus(v:View){
            val position = patientsList[adapterPosition]
            //TODO problema context
            val popupMenus = PopupMenu(this,v)
            popupMenus.inflate(R.layout.activity_add_patient)
            popupMenus.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.etName -> { val v = LayoutInflater.from(this).inflate(R.layout.activity_add_patient, null)
                        val name = v.findViewById<EditText>(R.id.etName)
                        // TODO prosegui con altre variabili
                        //val surname = v.findViewById<EditText>(R.id.etSurname)
                        AlertDialog.Builder(this)
                            .setView(v)
                            .setPositiveButton("Ok"){
                                    dialog,_->
                                position.name = name.text.toString()
                                //position.surname = number.text.toString()
                                notifyDataSetChanged()
                                Toast.makeText(this, "User Information is Edited", Toast.LENGTH_SHORT).show()
                                dialog.dismiss()

                            }
                            .setNegativeButton("Cancel"){
                                    dialog,_->
                                dialog.dismiss()

                            }
                            .create()
                            .show()
                        true
                    }
                    //TODO R.id.delete

                }
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