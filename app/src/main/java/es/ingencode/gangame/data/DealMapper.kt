package es.ingencode.gangame.data

import es.ingencode.gangame.Deal

/**
 * Created by jesusmarvaz on 05/02/2018.
 */

//a safe way of keeping two pojos detached, the sdk one and the gangame one
object DealMapper {
    fun fromSdk(deal: es.ingencode.sdk.Deal): Deal{
        return Deal(deal.title,
                deal.salePrice,
                deal.normalPrice,
                deal.metacriticScore,
                deal.steamScore,
                deal.thumb)
    }
}