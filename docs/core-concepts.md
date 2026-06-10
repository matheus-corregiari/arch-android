# Core Concepts

## State machines

`StateMachine` coordinates state transitions. `ViewStateMachine` applies visibility and enabled
state changes to views, while `SceneStateMachine` coordinates Android scenes.

## Storage

The storage API exposes memory, regular SharedPreferences, and encrypted SharedPreferences
implementations behind one typed contract.

## Delegates

Delegates reduce repeated access code for persisted values, Activity or Fragment extras, views,
and ViewModels.

## RecyclerView

The adapter APIs provide reusable binders, item diffing, and sticky-header support without
requiring an application-specific base adapter.
