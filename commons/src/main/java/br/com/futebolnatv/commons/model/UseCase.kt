package br.com.futebolnatv.commons.model

interface UseCase<Param, Return> {
    suspend operator fun invoke(param: Param? = null): Return
}
