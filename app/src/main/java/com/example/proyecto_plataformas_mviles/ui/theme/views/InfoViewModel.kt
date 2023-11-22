import androidx.lifecycle.ViewModel
import com.example.proyecto_plataformas_mviles.ui.theme.views.Infodb
import com.example.proyecto_plataformas_mviles.ui.theme.views.Infodb2
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class InfoViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    val userId: String? = auth.currentUser?.uid

    fun guardarDatosEnUltimaColeccion(info: Infodb) {
        val user = auth.currentUser
        user?.let { currentUser ->
            val userId = currentUser.uid

            // Obtener la última colección creada
            obtenerUltimaColeccion(userId).continueWith { task ->
                if (task.isSuccessful) {
                    val ultimaColeccion = task.result

                    // Chequear si ultimaColeccion no es null antes de proceder
                    if (ultimaColeccion != null) {
                        // Referencia a la última colección
                        val ultimaColeccionRef = db.collection("users").document(userId)
                            .collection("colecciones").document(ultimaColeccion)

                        // Crear un nuevo documento dentro de la última colección con los datos de info
                        ultimaColeccionRef.collection("items").add(info)
                            .addOnSuccessListener { documentReference ->
                                println("Info agregada con éxito a la última colección: ${documentReference.id}")
                            }
                            .addOnFailureListener { e ->
                                println("Error al agregar info a la última colección: $e")
                            }
                    } else {
                        // Manejar el caso en que no hay una última colección
                        println("No se encontró la última colección")
                        // Aquí podrías optar por crear una nueva colección si es necesario
                    }
                } else {
                    println("Error al obtener la última colección: ${task.exception}")
                    // Manejar otros tipos de errores aquí
                }
            }
        }
    }




    fun crearNuevaColeccion() {
        val user = auth.currentUser
        user?.let { currentUser ->
            val userId = currentUser.uid

            obtenerUltimaColeccion(userId).continueWith { task ->
                val ultimaColeccionNombre = task.result
                val nuevoNumero = (ultimaColeccionNombre?.toIntOrNull() ?: 0) + 1
                val nuevaColeccionNombre = "lista_$nuevoNumero"

                // Crear una colección de configuración o metadata para la nueva colección
                val configColeccion = hashMapOf(
                    "nombre" to nuevaColeccionNombre,
                    // Otros campos de configuración o metadata
                )

                // Crear la colección de configuración en la colección "colecciones" dentro del usuario
                db.collection("users").document(userId)
                    .collection("listas").document(nuevaColeccionNombre)
                    .set(configColeccion)
            }
        }
    }

    // Método para obtener el nombre de la última colección en la colección "colecciones" dentro del usuario
    private fun obtenerUltimaColeccion(userId: String) =
        db.collection("users").document(userId)
            .collection("listas")
            .orderBy("nombre", Query.Direction.DESCENDING)
            .limit(1)
            .get()
            .continueWith { task ->
                if (!task.result.isEmpty) {
                    val ultimaColeccion = task.result.documents[0].getString("nombre")
                    ultimaColeccion
                } else {
                    // No hay colecciones existentes, devuelve null
                    null
                }
            }
    suspend fun obtenerNombresDeColecciones(userId: String): List<String> {
        // Lista para almacenar los nombres de las colecciones
        val nombresColecciones = mutableListOf<String>()

        try {
            val querySnapshot = db.collection("users").document(userId)
                .collection("listas")
                .get()
                .await()

            // Iterar a través de los documentos y agregar los nombres a la lista
            for (documento in querySnapshot.documents) {
                documento.getString("nombre")?.let { nombre ->
                    nombresColecciones.add(nombre)
                }
            }
        } catch (e: Exception) {
            println("Error al obtener nombres de colecciones: $e")
        }

        return nombresColecciones
    }
    suspend fun obtenerDatosDeProductos(listName: String): List<Infodb2> = withContext(Dispatchers.IO) {
        val dataList = mutableListOf<Infodb2>()

        try {
            val querySnapshot = db.collection("users").document(userId!!)
                .collection("colecciones").document(listName)
                .collection("items")
                .get()
                .await()

            for (document in querySnapshot.documents) {
                document.toObject(Infodb2::class.java)?.let { infodb2 ->
                    dataList.add(infodb2)
                }
            }
        } catch (e: Exception) {
            println("Error al obtener los datos de productos: $e")
        }

        return@withContext dataList
    }






}








