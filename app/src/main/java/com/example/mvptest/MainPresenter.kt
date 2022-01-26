package com.example.mvptest

class MainPresenter(val view: MainView) {

    private val model = CountersModel()

    fun counterClick(id: Buttons) {
        when (id) {
            Buttons.FIRST -> {
                val nextValue = model.next(0)
                view.setButtonText(0, nextValue.toString())
            }
            Buttons.SECOND -> {
                val nextValue = model.next(1)
                view.setButtonText(1, nextValue.toString())
            }
            Buttons.THIRD -> {
                val nextValue = model.next(2)
                view.setButtonText(2, nextValue.toString())
            }
        }
    }
}
