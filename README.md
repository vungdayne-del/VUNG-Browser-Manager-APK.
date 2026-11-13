# VÙNG Browser Manager

Android starter project using Kotlin and Jetpack Compose.

## Build in GitHub Actions
1. Push this repository to the `main` branch.
2. Open the **Actions** tab.
3. Select **Build VUNG Browser Manager APK**.
4. Wait for the workflow to finish.
5. Download `VUNG-Browser-Manager-APK` from Artifacts.

The workflow installs JDK 17, Android SDK and Gradle 8.13, then runs `./gradlew assembleDebug`.

## Gradle launcher note
This package includes `gradle/wrapper/gradle-wrapper.properties`, `gradlew`, and `gradlew.bat`.
It intentionally does not include the binary `gradle-wrapper.jar`. The supplied launcher scripts delegate to the Gradle 8.13 installation made available by `gradle/actions/setup-gradle@v3` in CI. Therefore, the GitHub Actions workflow is the supported build path for this package. For a conventional local Gradle Wrapper, generate and commit the official wrapper JAR using Gradle's `wrapper` task.

## Current implementation
V0.1 is the application shell and navigation scaffold. Profile persistence, full browser features, proxy routing, account management, app locking and encrypted backup are not implemented in this starter.

This project is intended for transparent privacy, security and profile-data management. It does not implement anti-detection, device spoofing, or bypassing platform restrictions.
