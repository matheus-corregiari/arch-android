//[Android](../../../index.md)/[br.com.arch.toolkit.android.statemachine](../index.md)/[StateMachine](index.md)/[start](start.md)

# start

[android]\
fun [start](start.md)()

Starts the state machine. This must be called after all states are added and initial configuration is set.

#### Throws

| | |
|---|---|
| [IllegalStateException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-illegal-state-exception/index.html) | If the machine is already started or if the initial state is not found. |