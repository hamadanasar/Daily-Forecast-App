package com.example.dailyforecastapp.Error

import androidx.lifecycle.MutableLiveData

class ErrorLiveData<T> : MutableLiveData<HandleError<T>>() {

    /**
     * Use this to put the Data on a ERROR DataStatus
     * @param throwable the error to be handled
     */
    fun postConnectionError() {
        postValue(HandleError<T>().connectionError())
    }

    fun postError(throwable: String?) {
        postValue(HandleError<T>().error(throwable!!))
    }

    /**
     * Use this to put the Data on a SUCCESS DataStatus
     * @param data
     */
    fun postSuccess(data: T?) {
        postValue(HandleError<T>().success(data))
    }

    fun postFailure(data: T?) {
        postValue(HandleError<T>().failure(data))
    }

}