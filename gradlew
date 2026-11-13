#!/usr/bin/env sh
#
# VÙNG Browser Manager bootstrap launcher.
# CI installs Gradle 8.13 with gradle/actions/setup-gradle before invoking this file.
# This is a lightweight launcher, not the standard Gradle Wrapper JAR launcher.
#
set -eu
if command -v gradle >/dev/null 2>&1; then
    exec gradle "$@"
fi
echo "Gradle is not installed. In GitHub Actions, run gradle/actions/setup-gradle first." >&2
echo "For local builds, install Gradle 8.13 or add the official Gradle Wrapper JAR." >&2
exit 127
