package com.surrus.galwaybus.domain.repository

import com.surrus.galwaybus.model.*

interface GalwayBusRepository {

    suspend fun getBusRoutes(): List<BusRoute>
    suspend fun saveBusRoutes(busRoutes: List<BusRoute>)
    suspend fun clearBusRoutes()

    suspend fun saveBusStops(busStops: List<BusStop>)
    suspend fun clearBusStops()


    suspend fun getNearestBusStops(location: Location): List<BusStop>
    suspend fun getBusStops(routeId: String): List<List<BusStop>>
    suspend fun getBusStopsByName(name: String) : List<BusStop>

    suspend fun getDepartures(stopRef: String): List<Departure>
    suspend fun getSchedules(): Map<String, RouteSchedule>
}