#!/bin/sh
set -eu
cd "$(dirname "$0")/.."
rm -rf build
mkdir -p build/classes build/test-classes
javac --release 17 -encoding UTF-8 -d build/classes src/main/java/io/github/hjunior29/utils/*.java
javac --release 17 -encoding UTF-8 -cp build/classes -d build/test-classes src/test/java/io/github/hjunior29/utils/*Test.java
for test_file in src/test/java/io/github/hjunior29/utils/*Test.java; do
 test_class=$(basename "$test_file" .java)
 java -cp build/classes:build/test-classes "io.github.hjunior29.utils.$test_class"
 printf 'PASS %s\n' "$test_class"
done
