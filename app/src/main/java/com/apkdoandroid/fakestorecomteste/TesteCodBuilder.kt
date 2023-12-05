import android.app.Dialog
import com.apkdoandroid.fakestorecomteste.domain.model.Usuario

fun main(){

    val usuario = Usuario
        .Builder("Elanilson","De Jesus")
        .setIdade(25)
        .build()
    println(usuario.toString())
}