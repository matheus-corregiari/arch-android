# Contributing to Arch Android

## Quick Start

1. Fork and clone the repository.
2. Use JDK 21.
3. Run the main checks:

```bash
./gradlew ciBuild
./gradlew ciLint
./gradlew ciCoverage
python -m mkdocs build --strict
```

## Repository Layout

- `android/src/androidMain`: Android library implementation.
- `android/src/androidHostTest`: host-side Android tests.
- `build-logic`: shared Gradle convention plugins.
- `docs`: guides, changelogs, and generated API documentation.

## Development Rules

- Keep changes focused.
- Add or update tests when behavior changes.
- Keep KDoc and guides aligned with the public API.
- Prefer Android host tests when device behavior is not required.
- Do not commit generated build outputs or local Gradle caches.

## Pull Request Checklist

- [ ] Build passes.
- [ ] Lint passes.
- [ ] Tests and coverage verification pass.
- [ ] Documentation is updated when public behavior changes.
