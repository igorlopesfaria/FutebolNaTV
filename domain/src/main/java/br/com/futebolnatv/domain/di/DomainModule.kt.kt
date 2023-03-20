package br.com.futebolnatv.domain.di

import br.com.futebolnatv.commons.model.UseCase
import br.com.futebolnatv.domain.match.FilterMatchByParamsUseCase
import br.com.futebolnatv.domain.match.FindAllMatchUseCase
import br.com.futebolnatv.domain.match.MakeChampionshipListUseCase
import br.com.futebolnatv.domain.match.MakeDateListUseCase
import br.com.futebolnatv.domain.match.MakeTeamListUseCase
import br.com.futebolnatv.domain.match.model.FilterMatchModel
import br.com.futebolnatv.domain.onboarding.FindFirstAccessUseCase
import br.com.futebolnatv.domain.onboarding.InsertFirstAccessUseCase
import br.com.futebolnatv.model.MatchModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.flow.Flow


@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideFilterMatchByParamsUseCase(useCase: FilterMatchByParamsUseCase): UseCase<FilterMatchModel, List<MatchModel>> = useCase

    @Provides
    fun provideAllMatchUseCase(useCase: FindAllMatchUseCase): UseCase<Void, Flow<List<MatchModel>>> = useCase

    @Provides
    fun provideMakeChampionshipListUseCase(useCase: MakeChampionshipListUseCase): UseCase<List<MatchModel>, List<String>> = useCase

    @Provides
    fun provideMakeDateListUseCase(useCase: MakeDateListUseCase): UseCase<List<MatchModel>, List<String>> = useCase

    @Provides
    fun provideMakeTeamListUseCase(useCase: MakeTeamListUseCase): UseCase<List<MatchModel>, List<String>> = useCase

    @Provides
    fun provideFindFirstAccessUseCase(useCase: FindFirstAccessUseCase): UseCase<Void, Flow<Boolean>> = useCase

    @Provides
    fun provideInsertFirstAccessUseCase(useCase: InsertFirstAccessUseCase): UseCase<Boolean, Flow<Boolean>> = useCase

}


