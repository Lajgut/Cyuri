package presentation.account

import ru.mail.channel.voiceservice.presentation.base.ViewEvent
import ru.mail.channel.voiceservice.presentation.base.ViewSideEffect
import ru.mail.channel.voiceservice.presentation.base.ViewState

class AccountContract {

    data class UiState(
        val screenState: String,
    ) : ViewState

    sealed class Event : ViewEvent {
        data object HandleIntent : Event()
    }

    sealed class SideEffect : ViewSideEffect {
        data object ShowOnBoarding : SideEffect()
    }
}