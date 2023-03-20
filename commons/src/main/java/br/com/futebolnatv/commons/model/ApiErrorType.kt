package br.com.futebolnatv.commons.model

sealed class ApiErrorType : Exception() {
    object Generic : ApiErrorType()
    object Network : ApiErrorType()
    object Unauthorized : ApiErrorType()
}
