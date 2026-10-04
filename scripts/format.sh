#!/bin/sh
set -eu
cd "$(dirname "$0")/.."
jar=$(sh scripts/install-tools.sh)
case "${1:-}" in
  '') set -- --replace ;;
  --check) set -- --dry-run --set-exit-if-changed ;;
  *) printf 'Usage: sh scripts/format.sh [--check]\n' >&2; exit 2 ;;
esac
# Stabilize Javadoc spacing when expanding compact input.
for pass in 1 2; do
  java -jar "$jar" "$@" \
    src/main/java/io/github/hjunior29/utils/*.java \
    src/test/java/io/github/hjunior29/utils/*Test.java
  if [ "$1" = --dry-run ]; then
    break
  fi
done
