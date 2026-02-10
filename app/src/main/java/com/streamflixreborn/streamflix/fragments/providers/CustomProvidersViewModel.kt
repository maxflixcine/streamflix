import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomProvidersViewModel : ViewModel() {
    private val _providersList = MutableLiveData<List<String>>()
    val providersList: LiveData<List<String>> get() = _providersList

    init {
        // Load initial providers or any startup logic
        _providersList.value = emptyList()
    }

    fun addProvider(provider: String) {
        val currentList = _providersList.value?.toMutableList() ?: mutableListOf()
        currentList.add(provider)
        _providersList.value = currentList
    }

    fun removeProvider(provider: String) {
        val currentList = _providersList.value?.toMutableList() ?: mutableListOf()
        currentList.remove(provider)
        _providersList.value = currentList
    }
}