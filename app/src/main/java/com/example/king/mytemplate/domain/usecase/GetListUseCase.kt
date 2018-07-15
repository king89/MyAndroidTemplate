package com.example.king.mytemplate.domain.usecase

import com.example.king.mytemplate.domain.repository.ItemRepository
import com.example.king.mytemplate.model.MyItem
import io.reactivex.Single

interface GetListUseCase {
    fun execute(): Single<List<MyItem>>
}

class GetListUseCaseImpl(val repository: ItemRepository) :
        GetListUseCase {
    override fun execute(): Single<List<MyItem>> {
        TODO()
    }

}