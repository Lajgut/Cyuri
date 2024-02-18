package presentation.home

import presentation.account.AccountContract
import presentation.base.BaseViewModel
import presentation.base.PoolDispatcher

class HomeViewModel(
    poolDispatcher: PoolDispatcher
): BaseViewModel<HomeContract.Event, HomeContract.UiState, HomeContract.SideEffect>(
    poolDispatcher = poolDispatcher
) {
    
}