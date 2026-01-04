package com.example.aplicacinkalun

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import secciones.SeccionBeneficios

class ActividadPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_inicio)
        // Referencia al BottomNavigationView
        val contenedorSol = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.contenedorHijo)
        val contenedorFragmento = findViewById<FrameLayout>(R.id.contenedor_seccion)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        contenedorSol.visibility = android.view.View.VISIBLE
        contenedorFragmento.visibility = android.view.View.GONE

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> {
                    contenedorSol.visibility = android.view.View.VISIBLE
                    contenedorFragmento.visibility = android.view.View.GONE

                    // Opcional: Limpiar el fragmento de beneficios para liberar memoria
                    val fragmentoActual = supportFragmentManager.findFragmentById(R.id.contenedor_seccion)
                    if (fragmentoActual != null) {
                        supportFragmentManager.beginTransaction().remove(fragmentoActual).commit()
                    }
                    true
                }

                R.id.nav_beneficios -> {
                    contenedorSol.visibility = android.view.View.GONE
                    contenedorFragmento.visibility = android.view.View.VISIBLE

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contenedor_seccion, SeccionBeneficios())
                        .commit()
                    true
                }

                R.id.nav_herramientas -> {
                    // Aquí harás lo mismo cuando crees SeccionHerramientas
                    true
                }

                R.id.nav_perfil -> {
                    // Aquí harás lo mismo cuando crees SeccionPerfil
                    true
                }

                else -> false
            }
        }
    }
}
