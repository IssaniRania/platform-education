package com.example.platform_education

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        val tableLayout = findViewById<TableLayout>(R.id.tablelayout) // Récupération du TableLayout depuis le XML

        val sharedPrefs = getSharedPreferences("MonFichier", Context.MODE_PRIVATE)
        val userCount = sharedPrefs.getInt("userCount", 0)

        for (i in 1..userCount) {
            val cin = sharedPrefs.getString("numero$i", "")
            val nomUtilisateur = sharedPrefs.getString("Name$i", "")
            val email = sharedPrefs.getString("email$i", "")

            val row = TableRow(this)

            val cinTextView = TextView(this, null, 0, R.style.MyTextViewStyle)
            cinTextView.text = cin

            val nomTextView = TextView(this, null, 0, R.style.MyTextViewStyle)
            nomTextView.text = nomUtilisateur

//            val emailTextView = TextView(this, null, 0, R.style.MyTextViewStyle)
//            emailTextView.text = email
            val button = Button(this)
            button.text="accept"

            row.addView(cinTextView)
            row.addView(nomTextView)
            //row.addView(emailTextView)
            row.addView(button)
            tableLayout.addView(row)
            button.setOnClickListener{
                val editor = sharedPrefs.edit()
                editor.putInt("etat",1)
                Toast.makeText(this@AdminActivity,"accepter", Toast.LENGTH_SHORT).show()

            }
        }
    }
}