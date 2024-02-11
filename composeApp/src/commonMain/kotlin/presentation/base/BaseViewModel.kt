package presentation.base

import kotlinx.coroutines.*
import ru.mail.channel.voiceservice.presentation.base.ViewEvent
import ru.mail.channel.voiceservice.presentation.base.ViewSideEffect
import ru.mail.channel.voiceservice.presentation.base.ViewState
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<Event : ViewEvent, UiState : ViewState, Effect : ViewSideEffect>(
    protected val poolDispatcher: PoolDispatcher
) {
    fun createMainScope(): CloseableCoroutineScope {
        return CloseableCoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    }
}

class CloseableCoroutineScope(context: CoroutineContext) : CoroutineScope {
    override val coroutineContext: CoroutineContext = context
}
