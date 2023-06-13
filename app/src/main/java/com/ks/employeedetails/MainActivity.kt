package com.ks.employeedetails


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    private lateinit var employeeAdapter: EmployeeAdapter
    private lateinit var employeeViewModel: EmployeeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        employeeAdapter= EmployeeAdapter(emptyList())
        recyclerView.adapter = employeeAdapter

        employeeViewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)
        employeeViewModel.employeesLiveData.observe(this, Observer { employees ->
            employeeAdapter.employees = employees
            employeeAdapter.notifyDataSetChanged()
        })
        employeeViewModel.fetchEmployees()
    }
}