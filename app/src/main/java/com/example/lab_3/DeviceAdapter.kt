package com.example.lab_3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat

class DeviceAdapter(
    private val context: Context,
    private val dataSet: List<DeviceInfo>,
    private val onDeviceSelected: (DeviceInfo) -> Unit
) : RecyclerView.Adapter<DeviceAdapter.ViewHolder>() {

    private var selectedDevice: DeviceInfo? = null // Track the selected device

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.deviceName)
        val descriptionTextView: TextView = view.findViewById(R.id.deviceDescription)
        val versionTextView: TextView = view.findViewById(R.id.deviceVersion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.small_device_activity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.nameTextView.text = item.name
        holder.descriptionTextView.text = item.description
        holder.versionTextView.text = item.version

        // Check if this item is the selected device
        val backgroundColor = if (item == selectedDevice) {
            ContextCompat.getColor(context, R.color.selected_bg) // Selected background color
        } else {
            ContextCompat.getColor(context, R.color.default_bg) // Default background color
        }
        holder.itemView.setBackgroundColor(backgroundColor)

        // Set click listener to select the device
        holder.itemView.setOnClickListener {
            selectedDevice = if (selectedDevice == item) null else item
            onDeviceSelected(item)
            notifyDataSetChanged() // Refresh the list to reflect the change
        }
    }


    override fun getItemCount(): Int = dataSet.size
}
