package es.ingencode.gangame.data

import android.util.Log
import es.ingencode.gangame.Deal
import es.ingencode.gangame.TopGame
import es.ingencode.sdk.GangameApiService
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by jesusmarvaz on 05/02/2018.
 */
//like a singleton, it has no constuctor, it can't, it's forbidden
object GangameDataSource {
    val apiService = GangameApiService()
    fun getDeals(): Observable<ArrayList<Deal>> {
        return apiService.apiClient
                .getDealsObservable()
                .map { listDeal ->
                    val deals = listDeal.map { deal -> DealMapper.fromSdk(deal)}
                    val arrayList = arrayListOf<Deal>()
                    arrayList.addAll(deals)
                arrayList
                }.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

    fun getTopGames(): Observable<ArrayList<TopGame>> {
        return apiService.apiClient
                .getTopRatedGamesObservable()
                .map { listTopGame ->
                    val topGames = listTopGame.mapIndexed {index, topGame -> TopGameMapper.fromSdk(topGame, (index + 1))}
                    val arrayList = arrayListOf<TopGame>()
                    arrayList.addAll(topGames)
                    arrayList
                }.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

    fun getMostOwned(): Observable<ArrayList<TopGame>> {
        return apiService.apiClient
                .getMostOwnedGamesObservable()
                .map { listTopGame ->
                    val topGames = listTopGame.mapIndexed { index, topGame -> TopGameMapper.fromSdk(topGame, (index + 1))}
                    val arrayList = arrayListOf<TopGame>()
                    arrayList.addAll(topGames)
                    arrayList
                }.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}