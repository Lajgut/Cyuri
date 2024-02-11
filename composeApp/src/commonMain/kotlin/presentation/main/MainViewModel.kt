package presentation.main

import presentation.base.BaseViewModel
import presentation.base.PoolDispatcher

class MainViewModel(
    poolDispatcher: PoolDispatcher
): BaseViewModel<MainContract.Event, MainContract.UiState, MainContract.SideEffect>(
    poolDispatcher = poolDispatcher
) {
    
}