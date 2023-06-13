package com.ks.employeedetails

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity


class EmployeesDetails : ComponentActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees_details)

        val textNameDetails:TextView = findViewById(R.id.textNameDetails)
        val textDesignationDetails:TextView = findViewById(R.id.textDesignationDetails)
        val textAgeDetails:TextView = findViewById(R.id.textAgeDetails)
        val textNumberDetails:TextView = findViewById(R.id.textNumberDetails)
        val employeeImage:ImageView= findViewById(R.id.employeeImage)

        sharedPreferences = getSharedPreferences("employee_data", MODE_PRIVATE)
        val employeeName = sharedPreferences.getString("name","")
        val employeeDesignation = sharedPreferences.getString("designation","")
        val employeeAge = sharedPreferences.getString("age","")
        val employeeNumber = sharedPreferences.getString("number","")
        val employeePicture = sharedPreferences.getInt("image", 0)


        textNameDetails.text = employeeName
        textDesignationDetails.text = employeeDesignation
        textAgeDetails.text= employeeAge
        textNumberDetails.text = employeeNumber
        employeeImage.setImageResource(employeePicture)

    }
}

