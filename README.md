# Iterator Pattern: Episodes on a Netflix-like Platform

## Problem
A TV series stores episodes in different ways. The UI team needs a unified way to iterate over episodes.

## Solution: Iterator
- **Interface** `EpisodeIterator` with `hasNext()`/`next()`.
- **Three iterators** for a single season:
- `SeasonIterator` (forward order).
- `ReverseSeasonIterator` (reverse).
- `ShuffleSeasonIterator` (random, with a fixed seed).
- **`Season`** implements `Iterable<Episode>` for `for-each`.
- **`BingeIterator`** iterates over episodes from all seasons in a row.

## Why it's better than `List<Episode>`
- Hides storage details.
- Single API for any collections.
- Easily change the traversal order without editing the client code.
- Support for `for-each` via `Iterable<Episode>`.
