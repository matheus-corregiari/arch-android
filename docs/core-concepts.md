# Core Concepts

For task ownership, lifecycle and Views/Compose/KMP choices, see the
[consumer guide](consumer-guide.md). These utilities belong to Android source sets.

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

## Expiring values

`ThresholdData` scopes a cached value by storage and key. Expiration uses
`kotlin.time.TimeSource.Monotonic`, so clock corrections cannot extend or shorten its lifetime.
Durations retain submillisecond precision; a negative duration expires immediately.
