package com.example.aplicacinkalun

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActividadPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Conectar la Activity con el layout XML
        setContentView(R.layout.activity_inicio)

        // Referencia al BottomNavigationView
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        // 2. Listener de navegación
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_inicio -> true
                R.id.nav_beneficios -> true
                R.id.nav_herramientas -> true
                R.id.nav_perfil -> true

                // IMPORTANTE
                R.id.nav_spacer -> false

                else -> false
            }
        }
    }
}
