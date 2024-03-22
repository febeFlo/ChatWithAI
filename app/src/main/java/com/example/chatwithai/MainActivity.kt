package com.example.chatwithai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.ai.client.generativeai.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eTPrompt = findViewById<EditText>(R.id.eTPrompt)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tVResult = findViewById<TextView>(R.id.tVResult)

        btnSubmit.setOnClickListener{
            val prompt = eTPrompt.text.toString()

            val generativeModel = GenerativeModel(
                modelName = "gemini-pro",
                apiKey = "APIKEY"
            )

            runBlocking {
                val response = generativeModel.generateContent(prompt)
                tVResult.text = response.text
            }
        }
    }
}