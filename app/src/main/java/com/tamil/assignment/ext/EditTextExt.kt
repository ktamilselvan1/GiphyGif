package com.tamil.assignment.ext

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

private const val DEBOUNCE_PERIOD: Long = 1500

fun EditText.queryTextChangeStateFlow(): StateFlow<String> {
    val query = MutableStateFlow("")

    doAfterTextChanged {
        query.value = it.toString()
    }

    return query
}

@FlowPreview
fun EditText.performDelayedSearch(delay: Long = DEBOUNCE_PERIOD): Flow<String> {
    return queryTextChangeStateFlow()
        .debounce(delay)
        .filter { it.isNotEmpty() }
        .distinctUntilChanged()
        .flowOn(Dispatchers.Default)
}