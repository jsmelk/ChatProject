package com.example.rc.chatproj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    val client = OkHttpClient()

    val FORM = MediaType.parse("application/x-www-form-urlencoded")

    fun httpPost(url: String,body: RequestBody, success: (response: Response) -> Unit, failure: () -> Unit) {
        val request = Request.Builder()
                .url(url)
                .addHeader("Accept", "application/json")
                .post(body)
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                failure()
                Log.v("INFO", "Failed")
            }

            override fun onResponse(call: Call?, response: Response) {
                success(response)
                Log.v("INFO", "Succeeded")
            }
        })
    }

    fun login(login: String, password: String){
        Toast.makeText(this, "dziala (" + login + ":" + password + ")", Toast.LENGTH_SHORT ).show()
        val url = "http://192.168.0.15:3000/login"
        val body = RequestBody.create(FORM, "session[login]=" + login + "&session[password]=" + password)

        httpPost(url, body,
                fun (response: Response) {
                    Log.v("INFO", "Succeeded")
                    val response_string = response.body()?.string()
                    val json = JSONObject(response_string)
                    if (json.has("message")){
                        this.runOnUiThread {
                            Toast.makeText(this, json["message"] as String, Toast.LENGTH_SHORT).show()
                        }
                    }
                    else if (json.has("token")){
                        this.runOnUiThread{
                            Toast.makeText(this, json["token"] as String, Toast.LENGTH_SHORT).show()
                            val intent = android.content.Intent(this, Main2Activity::class.java)
                            startActivity(intent)
                       }
                    }
                },
                fun() {
                    Log.v("INFO", "Failed")
                })

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (etLog.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }

        buttonLog.setOnClickListener{
            val login = etLog.text.toString()
            val password = etPass.text.toString()
            login(login,password)
        }

        tvReg.setOnClickListener{
            val regIntent = android.content.Intent (this, ActivityReg::class.java)
            startActivity(regIntent)
        }
    }
}
