package es.ingencode.sdk

import retrofit2.Retrofit

/**
 * Created by jesusmarvaz on 04/02/2018.
 */
interface GangameApiConfig {
    fun setupConfig(builder: Retrofit.Builder)
}