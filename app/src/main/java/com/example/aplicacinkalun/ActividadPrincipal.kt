package com.example.aplicacinkalun

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import secciones.SeccionBeneficios
import secciones.SeccionBlog
import androidx.core.view.size
import androidx.core.view.get

class ActividadPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        // 1. PRIMERO declaramos todas las referencias (IDs)
        val contenedorSol = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.contenedorHijo)
        val contenedorFragmento = findViewById<FrameLayout>(R.id.contenedor_seccion)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val btnSolCentral = findViewById<ImageView>(R.id.btnSolCentral)

        // 2. Estado inicial: Mostramos el Home (sol) y ocultamos fragmentos
        contenedorSol.visibility = android.view.View.VISIBLE
        contenedorFragmento.visibility = android.view.View.GONE

        // 3. Programamos el clic del SOL CENTRAL (Blog)
        btnSolCentral.setOnClickListener {
            contenedorSol.visibility = android.view.View.GONE
            contenedorFragmento.visibility = android.view.View.VISIBLE

            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor_seccion, SeccionBlog())
                .commit()

            // Esto deselecciona los iconos del menú para que se note que estamos en el Blog
            bottomNavigation.menu.setGroupCheckable(0, true, false)
            for (i in 0 until bottomNavigation.menu.size) {
                bottomNavigation.menu[i].isChecked = false
            }
            bottomNavigation.menu.setGroupCheckable(0, true, true)
        }

        // 4. Programamos el resto del menú de navegación
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> {
                    contenedorSol.visibility = android.view.View.VISIBLE
                    contenedorFragmento.visibility = android.view.View.GONE
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

                R.id.nav_herramientas -> true
                R.id.nav_perfil -> true
                else -> false
            }
        }
    }
}
