package com.ks.employeedetails

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(var employees:List<Employee>) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {
    inner class EmployeeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       private val textName:TextView = itemView.findViewById(R.id.employeeName)
        private val textDesignation:TextView=itemView.findViewById(R.id.employeeDesignation)

        fun bind(employee: Employee){
            textName.text=employee.name
            textDesignation.text= employee.designation

            itemView.setOnClickListener {
                val context = itemView.context
                val sharedPreferences = context.getSharedPreferences("employee_data", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                val employee = employees[adapterPosition]
                editor.putString("name", employee.name)
                editor.putString("designation", employee.designation)
                editor.putString("age", employee.age.toString())
                editor.putString("number", employee.phoneNumber)
                editor.putInt("image", employee.picture)
                editor.apply()
                val intent = Intent(context, EmployeesDetails::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_employee,parent,false)
        return EmployeeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employees[position]
        holder.bind(employee)
    }

    override fun getItemCount(): Int {
        return employees.size
    }
}