package com.example.a28nov.repositori

import android.app.Application
import android.content.Context
import androidx.room.Database
import com.example.a28nov.room.DatabaseSiswa

interface ContainerApp{
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(private val context: Context):
    ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(
            DatabaseSiswa.getDatabase(context).siswaDao())
    }
}

class AplikasiSiswa : Application (){

    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(context = this)
    }
}