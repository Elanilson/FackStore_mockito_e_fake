package com.apkdoandroid.fakestorecomteste.view.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.apkdoandroid.fakestorecomteste.domain.model.Produto
import com.apkdoandroid.fakestorecomteste.domain.usecase.ProdutoUseCase
import com.apkdoandroid.fakestorecomteste.util.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest


import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var  produtoUseCase: ProdutoUseCase
    private lateinit var mainViewModel: MainViewModel

    private lateinit var  produtoUseCaseFake: ProdutoUseCaseFake
    private lateinit var mainViewModelFake: MainViewModelFake

    @Before
    fun setUp()  {
        MockitoAnnotations.openMocks(this)
        mainViewModel = MainViewModel(produtoUseCase)
        produtoUseCaseFake = ProdutoUseCaseFake()
        mainViewModelFake = MainViewModelFake(produtoUseCaseFake)

    }

    @After
    fun tearDown() {
    }

    @Test
    fun recuperarProdutos() = runTest{
        Mockito.`when`(produtoUseCase.recuperarProdutos()).thenReturn(
            listOf(Produto(1,""))
        )

        mainViewModel.recuperarProdutos()

        val livedata = mainViewModel.produtos.getOrAwaitValue()

        assertThat(livedata).isNotEmpty()
    }

    @Test
    fun com_fake_recuperarProdutos() = runTest{


        mainViewModelFake.recuperarProdutos()

        val livedata = mainViewModelFake.produtos.getOrAwaitValue()

        assertThat(livedata).isNotEmpty()
    }
}