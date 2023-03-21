package br.com.futebolnatv.data.match

import br.com.futebolnatv.commons.exceptions.GenericException
import br.com.futebolnatv.commons.exceptions.NetworkException
import br.com.futebolnatv.commons.exceptions.UnauthorizedException
import br.com.futebolnatv.data.match.datasource.MatchApiDataSource
import br.com.futebolnatv.data.match.mapper.MatchMapper
import br.com.futebolnatv.data.match.repository.MatchRepository
import br.com.futebolnatv.data.match.repository.MatchRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.net.HttpURLConnection
import java.util.concurrent.TimeoutException


@OptIn(ExperimentalCoroutinesApi::class)
class MatchRepositoryTest {

    @MockK
    private lateinit var dataSource: MatchApiDataSource
    @MockK
    private lateinit var matchMapper: MatchMapper

    private lateinit var repository: MatchRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(StandardTestDispatcher())
        repository = MatchRepositoryImpl(dataSource, matchMapper)
    }

    @Test
    fun `GIVEN call to getMatches WHEN ApiDataSource return success THEN return List of MatchModel converted`() = runTest {

        coEvery { dataSource.getMatches() } returns matchApiResponseMocked
        coEvery { matchMapper.mapToDomainModel(any()) } returns matchModelMocked

        repository.getMatches().collect { listRepositoryReturn ->
            assert(listRepositoryReturn == matchModelListMocked)
        }
    }

    @Test
    fun `GIVEN call to getMatches WHEN ApiDataSource response any exception related to network THEN throw custom exception NetworkException`() = runTest {
        coEvery { dataSource.getMatches() }.throws(TimeoutException())

        repository.getMatches().catch { throwable ->
            Assert.assertTrue(throwable is NetworkException)
        }.collect()
    }

    @Test
    fun `GIVEN call to getMatches WHEN ApiDataSource return httpCode 401 THEN throw custom exception UnauthorizedException`() = runTest {
        coEvery { dataSource.getMatches() }.throws(HttpException(
            Response.error<Any>(
                HttpURLConnection.HTTP_UNAUTHORIZED, ""
                    .toResponseBody("plain/text".toMediaTypeOrNull())
            )
        ))

        repository.getMatches().catch { throwable ->
            Assert.assertTrue(throwable is UnauthorizedException)
        }.collect()
    }

    @Test
    fun `GIVEN call to getMatches WHEN ApiDataSource return httpCode != 401 THEN throw custom exception GenericException`() = runTest {
        coEvery { dataSource.getMatches() }.throws(HttpException(
            Response.error<Any>(
                HttpURLConnection.HTTP_BAD_REQUEST, ""
                    .toResponseBody("plain/text".toMediaTypeOrNull())
            )
        ))

        repository.getMatches().catch { throwable ->
            Assert.assertTrue(throwable is GenericException)
        }.collect()
    }


    @Test
    fun `GIVEN call to getMatches WHEN ApiDataSource throw exception THEN return the same Exception`() = runTest {
        coEvery { dataSource.getMatches() }.throws(IndexOutOfBoundsException())

        repository.getMatches().catch { throwable ->
            Assert.assertTrue(throwable is GenericException)
        }.collect()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}