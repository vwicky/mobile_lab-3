package com.example.lab_3.databaseManagement.testers

import android.util.Log
import com.example.lab_3.databaseManagement.dao.ConnectionLogsDAO
import com.example.lab_3.databaseManagement.entities.ConnectionLogsEntity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ConnectionLogsTester(private val dao: ConnectionLogsDAO) {
    private val formatter = DateTimeFormatter.ISO_DATE_TIME

    private val log1 = ConnectionLogsEntity(1, 2, LocalDateTime.now().format(formatter))
    private val log2 = ConnectionLogsEntity(2, 2, LocalDateTime.now().minusDays(1).format(formatter))

    private fun writeMessage(message: String) {
        Log.d("TEST", message)
    }
    fun testDB() {
        testInsertLogs()
        testReadLogs()
        testDeleteLog()
        testInsertLogs()
    }
    private fun testInsertLogs() {
        writeMessage("Insert Connection Logs")
        dao.insert(log1)
        dao.insert(log2)
    }
    private fun testReadLogs() {
        writeMessage("Read Logs")
        val logs = dao.getAll()
        for (log in logs) {
            writeMessage("> $log")
        }
    }
    private fun testDeleteLog() {
        writeMessage("Delete Log")
        dao.delete(log1)
    }
}