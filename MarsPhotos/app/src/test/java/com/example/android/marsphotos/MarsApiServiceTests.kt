package com.example.android.marsphotos

import com.example.android.marsphotos.network.MarsApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import junit.framework.TestCase.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MarsApiServiceTests : BaseTest() {

    private lateinit var service : MarsApiService

    @Before
    fun setup(){
        //実際の API に対して実際のネットワーク リクエストを行わないようにする
        //MockWebServer は、作成したデータを返す疑似 API
        val url = mockWebServer.url("/")
        service = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create(
                Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
            ))
            .build()
            .create(MarsApiService::class.java)

    }

    //BaseTestのenqueue() 関数がテストリソースからファイルを取得して、疑似 API レスポンスに変換する
    @Test
    fun api_service(){
        enqueue("mars_photos.json")
        runBlocking {
            val apiResponse = service.getPhoto()

            assertNotNull(apiResponse)
            assertTrue("The list was empty", apiResponse.isNotEmpty())
            assertEquals("The IDs did not match", "424905", apiResponse[0].id)
        }
    }
}