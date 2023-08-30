import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _resultLiveData = MutableLiveData<Boolean>()
    val resultLiveData: LiveData<Boolean>
        get() = _resultLiveData

    fun comparar(texto1: String, texto2: String) {
        val result = texto1 == texto2
        _resultLiveData.value = result
    }
}
