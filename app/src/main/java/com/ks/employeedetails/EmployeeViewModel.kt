package com.ks.employeedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EmployeeViewModel:ViewModel() {
    private val _employeesLiveData = MutableLiveData<List<Employee>>()
    val employeesLiveData: LiveData<List<Employee>> = _employeesLiveData

    fun fetchEmployees(){
        val employees = listOf(
            Employee("Krishna","Software Engineer",R.drawable.softwareengineer,24,"7895643213"),
            Employee("Indu","Software Tester",R.drawable.tester,23,"8848835478"),
            Employee("Anandhu","Manager",R.drawable.manager,25,"9388267966"),
            Employee("Arya","Module Leader",R.drawable.moduleleader,44,"9876543210"),
            Employee("Vishnu","HR",R.drawable.hr,34,"78967564534")
        )
        _employeesLiveData.value=employees
    }
}