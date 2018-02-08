package es.ingencode.gangame.data

import es.ingencode.gangame.TopGame

/**
 * Created by jesusmarvaz on 05/02/2018.
 */
object TopGameMapper {
    fun fromSdk(topGame: es.ingencode.sdk.TopGame, position: Int): TopGame{
        return TopGame(topGame.title,
                topGame.owners,
                topGame.steamRating,
                topGame.publisher,
                topGame.price,
                position,
                topGame.thumb)
    }
}