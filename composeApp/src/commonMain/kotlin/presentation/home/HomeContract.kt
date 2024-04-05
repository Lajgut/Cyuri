package presentation.home

import ru.mail.channel.voiceservice.presentation.base.ViewEvent
import ru.mail.channel.voiceservice.presentation.base.ViewSideEffect
import ru.mail.channel.voiceservice.presentation.base.ViewState

class HomeContract {

    data class UiState(
        val screenState: String,
        //val assistantText: AssistantTextUiEntity,
        //val suggests: SuggestListUiEntity,
    ) : ViewState 

    sealed class Event : ViewEvent {
        data object HandleIntent : Event()
    }

    sealed class SideEffect : ViewSideEffect {
        data object ShowOnBoarding : SideEffect()
    }
}