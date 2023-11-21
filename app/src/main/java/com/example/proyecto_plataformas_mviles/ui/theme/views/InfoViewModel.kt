import androidx.lifecycle.ViewModel
import com.example.proyecto_plataformas_mviles.ui.theme.views.Infodb
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class InfoViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val userId: String? = auth.currentUser?.uid

    fun guardarDatosEnFirebase(info: Infodb) {
        userId?.let { uid ->
            // Crear una referencia a la colección del usuario actual
            val userCollectionRef = db.collection("users").document(uid).collection("info")

            // Crear un nuevo documento con los datos de la data class
            userCollectionRef.add(info)
                .addOnSuccessListener { documentReference ->
                    println("Documento agregado con ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    println("Error al agregar el documento: $e")
                }
        }
    }
}



