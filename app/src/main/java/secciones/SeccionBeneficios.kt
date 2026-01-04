package secciones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aplicacinkalun.R
import androidx.fragment.app.Fragment

class SeccionBeneficios : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Aquí es donde le dices: "Esta clase controla el archivo fragment_beneficios"
        return inflater.inflate(R.layout.seccion_beneficios, container, false)
    }
}