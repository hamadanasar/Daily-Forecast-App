package com.example.dailyforecastapp.Error

import androidx.annotation.Nullable

class HandleError<T> {

    private var status: DataStatus? = null

    @Nullable
    private var data: T? = null

    @Nullable
    private var connectionError: String? = null
    private var error: String? = null

    fun success(data: T?): HandleError<T> {
        status = DataStatus.SUCCESS
        this.data = data
        return this
    }

    fun failure(data: T?): HandleError<T> {
        status = DataStatus.FAILURE
        this.data = data
        return this
    }

    fun connectionError(): HandleError<T> {
        status = DataStatus.CONNECTIONERROR
        this.error = null
        return this
    }
    fun error(error: String): HandleError<T> {
        status = DataStatus.ERROR
        this.error = error
        this.connectionError = null
        return this
    }

    @Nullable
    fun getData(): T? {
        return data
    }

    fun getStatus(): DataStatus {
        return status!!
    }

    enum class DataStatus {
        SUCCESS, CONNECTIONERROR, FAILURE, ERROR
    }
}