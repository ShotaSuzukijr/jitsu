package com.example.jitsu

class AddPhotoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PhotoRepository
    init {
        val photoDao = PhotoRoomDatabase.getPhotoDatabase(application).photoDao() repository = PhotoRepository(photoDao)
    }
    fun insert(photo: Photo) = viewModelScope.launch(Dispatchers.IO) { repository.insert(photo)
    }
}