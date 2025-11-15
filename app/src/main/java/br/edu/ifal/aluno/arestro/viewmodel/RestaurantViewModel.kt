package br.edu.ifal.aluno.arestro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifal.aluno.arestro.data.model.Restaurant
import br.edu.ifal.aluno.arestro.data.repository.RestaurantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RestaurantViewModel(private val repository: RestaurantRepository) : ViewModel() {

    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants

    private val _selectedRestaurant = MutableStateFlow<Restaurant?>(null)
    val selectedRestaurant: StateFlow<Restaurant?> = _selectedRestaurant

    fun loadRestaurants() {
        viewModelScope.launch {
            _restaurants.value = repository.getRestaurants()
        }
    }

    fun loadRestaurantDetails(id: Int) {
        viewModelScope.launch {
            _selectedRestaurant.value = repository.getRestaurantDetails(id)
        }
    }
}