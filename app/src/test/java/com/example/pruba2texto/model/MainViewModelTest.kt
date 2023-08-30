package com.example.pruba2texto.model

import MainViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test


internal class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }
    @Test
    fun testStringComparison() {
        viewModel.comparar("hola", "hola")
        Assert.assertEquals("Las cadenas son iguales", viewModel.resultLiveData.value)

        viewModel.comparar("Hola", "hola")
        Assert.assertEquals("Las cadenas son diferentes", viewModel.resultLiveData.value)
    }
}