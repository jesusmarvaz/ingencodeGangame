package es.ingencode.sdk

import com.google.gson.annotations.SerializedName
/**
 * Created by jesusmarvaz on 04/02/2018.
 */
data class Deal(var title: String,
                var salePrice: Float,
                var normalPrice: Float,
                var metacriticScore: Int,
                //U got it??
                @SerializedName("steamRatingPercent") var steamScore: Int,
                var thumb: String)

data class TopGame(@SerializedName("name") var title: String,
                   var publisher: String,
                   var steamRating: Int,
                   var owners: Int,
                   var price: Float,
                   var thumb: String)