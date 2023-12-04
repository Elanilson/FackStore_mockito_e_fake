package com.apkdoandroid.fakestorecomteste.domain.usecase

import com.apkdoandroid.fakestorecomteste.data.dto.ProdutoResposta
import com.apkdoandroid.fakestorecomteste.data.repository.FakeStoreRepositoryImpl
import com.apkdoandroid.fakestorecomteste.data.repository.FakeStoreRepositoryImplFake
import com.apkdoandroid.fakestorecomteste.domain.model.Produto
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

@RunWith(MockitoJUnitRunner::class)
class ProdutoUseCaseTest {

    @Mock
    private lateinit var repositoryImpl: FakeStoreRepositoryImpl
    private lateinit var repositoryImplFake: FakeStoreRepositoryImplFake

    private lateinit var produtoUseCase: ProdutoUseCase
    private lateinit var produtoUseCasefake: ProdutoUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        produtoUseCase = ProdutoUseCase(repositoryImpl)
        repositoryImplFake = FakeStoreRepositoryImplFake()
        produtoUseCasefake = ProdutoUseCase(repositoryImplFake)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun recuperarProdutos() = runTest {
        Mockito.`when`(repositoryImpl.recuperarProdutos()).thenReturn(
            listOf(Produto(1,""))
        )
        val produtos = produtoUseCase.recuperarProdutos()
        assertThat(produtos).isNotEmpty()
    }

    @Test
    fun com_fake_recuperarProdutos() = runTest {
        val produtos = produtoUseCasefake.recuperarProdutos()
        assertThat(produtos).isNotEmpty()
    }
}
