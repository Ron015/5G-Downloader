# Network Monitor Pro

Production-oriented Java Android application for real-time network monitoring, smart alerts, and 5G-aware download queue management.

## Build

```bash
chmod +x gradlew
./gradlew lint assembleDebug
```

The project uses Material 3-compatible Material Components, MVVM, LiveData, Room, WorkManager, a foreground monitoring service, a boot receiver, and the Fetch dependency requested for download integration. The repository intentionally uses a text-only `gradlew` launcher instead of committing `gradle-wrapper.jar`, which keeps pull request diffs compatible with systems that reject binary files.
