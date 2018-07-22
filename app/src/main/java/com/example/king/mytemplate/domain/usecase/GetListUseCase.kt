package com.example.king.mytemplate.domain.usecase

import com.example.king.mytemplate.domain.repository.ItemRepository
import com.example.king.mytemplate.model.MyItem
import io.reactivex.Single
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Inject

interface GetListUseCase {
    fun execute(): Single<List<MyItem>>
}

class GetListUseCaseImpl @Inject constructor(val repository: ItemRepository) :
        GetListUseCase {
    override fun execute(): Single<List<MyItem>> {
//        val data = mutableListOf<MyItem>()
//        (1..10).forEach {
//            data.add(MyItem("title$it", "description description description description "))
//        }
//        return Single.just(data)
        return repository.getRemoteDataList()
                .delay(1, SECONDS)
                .onErrorResumeNext({
                    repository.getLocalDataList()
                })
                .doOnSuccess {
                    repository.cacheDataList(it).blockingGet()
                }
    }

}