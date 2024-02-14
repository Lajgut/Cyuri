package presentation.account

import presentation.base.BaseViewModel
import presentation.base.PoolDispatcher

class AccountViewModel(
    poolDispatcher: PoolDispatcher
): BaseViewModel<HomeContract.Event, HomeContract.UiState, HomeContract.SideEffect>(
    poolDispatcher = poolDispatcher
) {
    
}