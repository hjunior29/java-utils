# java-utils

A small, tested Java utility library. Each utility lives in its own source file and has automated tests.

## Requirements

JDK 17 or newer. No Maven or external runtime dependencies are needed.

## Build and test

```sh
sh scripts/format.sh
sh scripts/check.sh
```

Formatting uses the pinned Google Java Format 1.24.0 tool, downloaded once with a verified checksum. `curl` is required on first use. Checks reject formatting differences and all compiler lint warnings.

## Usage

```java
import io.github.hjunior29.utils.ReverseString;

String reversed = ReverseString.reverseString("hello"); // "olleh"
```

## Utilities

- `reverseString` reverses Unicode code points.
- `wordCount` counts whitespace-separated words.
- `clampInt` clamps an integer to inclusive bounds and rejects reversed bounds.

- `PadRight.padRight` pads to a Unicode code-point length without truncating.

## Adding utilities

Use English for code, comments, documentation, and tests. Add one utility per file with meaningful tests covering normal, empty, boundary, and invalid input where applicable. Do not add dependencies without review.

Run the complete build and test suite before submitting changes. Keep public exports synchronized when adding modules.

## License

MIT
