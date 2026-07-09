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

## Branching and Releases

- Target `master` for all pull requests.
- Use `feature/*`, `fix/*`, `bugfix/*`, `config/*`, `docs/*`, `chore/*`, or `dependabot/*` for normal work.
- Use `release/x.y.0[-rcN]` for major or minor releases.
- Use `hotfix/x.y.z[-rcN]` for patch releases, where `z >= 1`.
- Do not open mergeback pull requests. The repository does not use a long-lived `develop` branch.
- Release and hotfix merges into `master` are the only automatic publication trigger.
- The release workflow derives the tag from the branch name, publishes artifacts, creates the tag, and creates the GitHub Release.

## Pull Request Checklist

- [ ] Build passes.
- [ ] Lint passes.
- [ ] Tests and coverage verification pass.
- [ ] Documentation is updated when public behavior changes.
