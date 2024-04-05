package presentation.account

import presentation.base.BaseViewModel
import presentation.base.PoolDispatcher

class AccountViewModel(
    poolDispatcher: PoolDispatcher
): BaseViewModel<AccountContract.Event, AccountContract.UiState, AccountContract.SideEffect>(
    poolDispatcher = poolDispatcher
) {
    
}