package com.apkdoandroid.fakestorecomteste.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.apkdoandroid.fakestorecomteste.data.remoto.RetrofitClient
import com.apkdoandroid.fakestorecomteste.data.repository.FakeStoreRepositoryImpl
import com.apkdoandroid.fakestorecomteste.databinding.ActivityMainBinding
import com.apkdoandroid.fakestorecomteste.domain.usecase.ProdutoUseCase
import com.apkdoandroid.fakestorecomteste.view.model.MainViewModel
import com.apkdoandroid.fakestorecomteste.view.model.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var  viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuracoes()

        viewModel.recuperarProdutos()

        observes()
    }

    private fun configuracoes(){
        val fakeStoreAPI = RetrofitClient.retrofitClient()
        val repository = FakeStoreRepositoryImpl(fakeStoreAPI)
        val produtoUseCase =  ProdutoUseCase(repository)

        viewModel = ViewModelProvider(this,ViewModelFactory(produtoUseCase)).get(MainViewModel::class.java)
    }

    private fun observes(){

        viewModel.produtos.observe(this){
            Log.d("meusProdutos",it.toString())
        }

    }
}