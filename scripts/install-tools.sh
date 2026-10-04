#!/bin/sh
set -eu
version=1.24.0
checksum=812f805f58112460edf01bf202a8e61d0fd1f35c0d4fabd54220640776ec57a1
jar="${GOOGLE_JAVA_FORMAT_JAR:-$HOME/.cache/google-java-format/google-java-format-$version-all-deps.jar}"
if [ ! -f "$jar" ]; then
  mkdir -p "$(dirname "$jar")"
  temporary=$(mktemp "${jar}.XXXXXX")
  trap 'rm -f "$temporary"' EXIT HUP INT TERM
  curl --fail --location --silent --show-error --retry 3 --connect-timeout 10 --max-time 60 \
    "https://github.com/google/google-java-format/releases/download/v$version/google-java-format-$version-all-deps.jar" \
    --output "$temporary"
  if command -v sha256sum >/dev/null 2>&1; then
    actual=$(sha256sum "$temporary" | cut -d ' ' -f 1)
  else
    actual=$(shasum -a 256 "$temporary" | cut -d ' ' -f 1)
  fi
  if [ "$actual" != "$checksum" ]; then
    printf 'Formatter checksum mismatch\n' >&2
    exit 1
  fi
  mv "$temporary" "$jar"
fi
printf '%s\n' "$jar"
