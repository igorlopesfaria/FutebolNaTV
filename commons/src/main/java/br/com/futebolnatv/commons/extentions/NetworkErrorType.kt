package br.com.futebolnatv.commons.extentions

import br.com.futebolnatv.commons.exceptions.GenericException
import br.com.futebolnatv.commons.exceptions.NetworkException
import br.com.futebolnatv.commons.exceptions.UnauthorizedException
import br.com.futebolnatv.commons.model.ApiErrorType
import com.squareup.moshi.Moshi
import retrofit2.HttpException
import java.net.UnknownHostException
import java.net.SocketTimeoutException
import java.net.SocketException
import java.net.ConnectException
import java.net.HttpURLConnection
import java.util.concurrent.TimeoutException

fun Throwable.toRequestThrowable(): Throwable {
    return when (this) {
        is UnknownHostException,
        is TimeoutException,
        is InterruptedException,
        is SocketTimeoutException,
        is SocketException,
        is ConnectException -> NetworkException()
        is HttpException -> parseHttpError()
        else -> this
    }
}

internal fun HttpException.parseHttpError(): Exception {
    return when (code()) {
        HttpURLConnection.HTTP_UNAUTHORIZED -> UnauthorizedException()
        else -> GenericException()
    }
}

fun Throwable.getApiErrorType(): ApiErrorType =
    when (this) {
        is UnauthorizedException -> ApiErrorType.Unauthorized
        is NetworkException -> ApiErrorType.Network
        else -> ApiErrorType.Generic
    }
