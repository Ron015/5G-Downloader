#!/usr/bin/env sh
# Text-only Gradle launcher for environments where binary wrapper jars cannot be stored.
# It prefers an installed Gradle and falls back to downloading the configured distribution.
set -eu

APP_HOME=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
GRADLE_VERSION="8.14.4"
GRADLE_USER_HOME="${GRADLE_USER_HOME:-$HOME/.gradle}"
GRADLE_DIST_DIR="$GRADLE_USER_HOME/network-monitor-pro/gradle-$GRADLE_VERSION"
GRADLE_BIN="$GRADLE_DIST_DIR/bin/gradle"

if command -v gradle >/dev/null 2>&1; then
  exec gradle "$@"
fi

if [ ! -x "$GRADLE_BIN" ]; then
  ZIP="$GRADLE_USER_HOME/network-monitor-pro/gradle-$GRADLE_VERSION-bin.zip"
  mkdir -p "$(dirname "$ZIP")"
  URL="https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip"
  if command -v curl >/dev/null 2>&1; then
    curl -fsSL "$URL" -o "$ZIP"
  elif command -v wget >/dev/null 2>&1; then
    wget -q "$URL" -O "$ZIP"
  else
    echo "Neither curl nor wget is available to download Gradle $GRADLE_VERSION." >&2
    exit 1
  fi
  if ! command -v unzip >/dev/null 2>&1; then
    echo "unzip is required to extract Gradle $GRADLE_VERSION." >&2
    exit 1
  fi
  rm -rf "$GRADLE_DIST_DIR"
  unzip -q "$ZIP" -d "$GRADLE_USER_HOME/network-monitor-pro"
fi

cd "$APP_HOME"
exec "$GRADLE_BIN" "$@"
