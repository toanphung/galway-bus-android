package com.surrus.galwaybus.remote

import com.surrus.galwaybus.model.BusRoute
import com.surrus.galwaybus.model.BusStop
import com.surrus.galwaybus.model.GetDeparturesResponse
import com.surrus.galwaybus.model.GetStopsResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GalwayBusService {

    @GET("/routes.json")
    fun getBusRoutes(): Flowable<LinkedHashMap<String, BusRoute>>

    @GET("/routes/{route_id}.json")
    fun getStops(@Path("route_id") routeId: String) : Flowable<GetStopsResponse>

    @GET("/stops.json")
    fun getAllStops() : Flowable<List<BusStop>>

    @GET("/stops/nearby.json")
    fun getNearestStops(@Query("latitude") latitude: Float, @Query("longitude") longitude: Float) : Flowable<List<BusStop>>

    @GET("/stops/{stop_ref}.json")
    fun getDepartures(@Path("stop_ref") stopRef: String) : Flowable<GetDeparturesResponse>
}