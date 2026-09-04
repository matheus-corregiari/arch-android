# Contributing to Arch Android

## Quick Start

1. Fork and clone the repository.
2. Use JDK 21.
3. Run the main checks:

```bash
./gradlew ciBuild ciCoverage
./gradlew ciLint ciDocs
python -m pip install -r .github/requirements-docs.txt
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

## Branching and Releases

Any work branch can target another development branch. PRs to `master` must use
`release/X.Y.Z` (next major/minor) or `hotfix/X.Y.Z` (next patch), optionally with `-rcN`.
CI rejects duplicate or historical remote versions. The validated master commit receives an
annotated tag; that tag triggers package publication.

See the [CI and release guide](ci.md) for required checks, runner conventions and recovery.
