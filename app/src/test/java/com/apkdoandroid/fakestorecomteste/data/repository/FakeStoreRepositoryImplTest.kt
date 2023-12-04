package com.apkdoandroid.fakestorecomteste.data.repository

import com.apkdoandroid.fakestorecomteste.data.dto.ProdutoResposta
import com.apkdoandroid.fakestorecomteste.data.remoto.FakeStoreAPI
import com.apkdoandroid.fakestorecomteste.data.remoto.RetrofitClient
import com.google.common.truth.Truth.assertThat

import kotlinx.coroutines.test.runTest


import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class FakeStoreRepositoryImplTest {

    @Mock
    private lateinit var fakeStoreAPI: FakeStoreAPI
    private lateinit var fakeStoreAPIFake: FakeStoreAPIFake

    @Before
    fun setUp() {

        fakeStoreAPIFake = FakeStoreAPIFake()
        MockitoAnnotations.openMocks(this);
    }

    @After
    fun tearDown() {
    }

    @Test
    fun recuperarProdutos() = runTest{
        Mockito.`when`(fakeStoreAPI.buscarProdutos()).thenReturn(
            Response.success(
                listOf(ProdutoResposta("Rafa",10.0))
            )
        )
        val fakeRepositorio = FakeStoreRepositoryImpl(fakeStoreAPI)
        val lista = fakeRepositorio.recuperarProdutos()

        assertThat(lista).isNotEmpty()
    }

    @Test
    fun teste_com_fake_recuperarProdutos() = runTest{

        val fakeRepositorio = FakeStoreRepositoryImpl(fakeStoreAPIFake)
        val lista = fakeRepositorio.recuperarProdutos()

        assertThat(lista).isNotEmpty()
    }
}