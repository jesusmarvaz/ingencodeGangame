package es.ingencode.sdk

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.junit.Assert
import org.junit.Test

/**
 * Created by jesusmarvaz on 05/02/2018.
 */
class RequestTest {
    @Test
    fun dealsRequest_success(){
        val apiService  = GangameApiService()
        val response    = apiService.apiClient.getDeals().execute()
        val deals       = response.body()

        val parser = JsonParser()
        val jsonresponse: JsonArray = parser.parse(MockResponses.DEALS_RESPONSE).asJsonArray


        Assert.assertTrue(response.isSuccessful)

        deals?.let {
            Assert.assertEquals(deals.size, jsonresponse.size())
            deals.zip(jsonresponse).forEach {(deal, jsonDeal) ->
                with(jsonDeal.asJsonObject){
                    Assert.assertEquals(deal.title, this["title"].asString)
                    Assert.assertEquals(deal.metacriticScore, this["metacriticScore"].asInt)
                    Assert.assertEquals(deal.steamScore, this["steamRatingPercent"].asInt)
                    Assert.assertEquals(deal.thumb, this["thumb"].asString)
                }

            }
        }
    }
    @Test
    fun topRatedRequest_success(){
        val apiService  = GangameApiService()
        val response    = apiService.apiClient.getTopRatedGames().execute()
        val games       = response.body()

        val parser = JsonParser()
        val jsonresponse: List<JsonObject> = parser.parse(MockResponses.TOP_100_GAMES)
                .asJsonObject
                .entrySet()
                .map { (_, json) ->
                    json.asJsonObject
                }

        Assert.assertTrue(response.isSuccessful)

        games?.let {
            Assert.assertEquals(games.size, jsonresponse.size)
            games.zip(jsonresponse).forEach {(game, jsonGame) ->
                with(jsonGame.asJsonObject){
                    Assert.assertEquals(game.title, this["name"].asString)
                    Assert.assertEquals(game.steamRating, this["score_rank"].asInt)
                    Assert.assertEquals(game.publisher, this["publisher"].asString)
                    Assert.assertEquals(game.owners, this["owners"].asInt)
                    Assert.assertEquals(game.thumb, "http://cdn.akamai.steamstatic.com/steam/apps/${this["appid"].asInt}/capsule_184x69.jpg")
                }

            }
        }
    }
}