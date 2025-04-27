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


# Airport Tower Simulator

## Overview

This project demonstrates the Mediator design pattern by simulating an airport control tower that manages multiple aircraft sharing a single runway. Direct communication between aircraft is avoided to prevent chaos; instead, a ControlTower mediator handles all message exchange and runway scheduling.

## Key Features

- Decoupled Communication: Aircraft broadcast messages only via the ControlTower.

- Runway Queues: Separate FIFO queues for landing and takeoff requests.

- Emergency Handling: Aircraft can send "MAYDAY" to jump the landing queue and clear the runway immediately; all others are notified to hold position.

- Support for Multiple Aircraft Types: PassengerPlane, CargoPlane, and Helicopter each react differently to tower broadcasts.

- Simulation Driver: Spawns ten random aircraft, issues periodic runway requests or emergencies, and prints real-time decisions for 20 ticks.


# How It Works

- Mediator (ControlTower****):

- Receives broadcasts and runway requests.

- Maintains two queues: landingQueue and takeoffQueue.

- On MAYDAY, clears queues for the emergency plane, notifies others to hold, and grants landing.

- Grants runway access in FIFO order for normal requests.

- Colleagues (Aircraft**** and subclasses):

- Send messages and runway requests only via the mediator.

- Override receive(String msg) to log messages with type-specific tags.

- Simulation Driver:

- Randomly selects an aircraft each second to send a landing, takeoff, or emergency request.

- Prints queue status after each action.

# Why Mediator over Direct Communication?

- Centralized Coordination: Simplifies complex many-to-many relationships into a single hub.

- Easier Maintenance: Adding new aircraft types requires minimal changes to the tower.

- Flexibility: Emergency protocols and scheduling policies are managed in one place.

#  Potential Drawback

- Single Point of Control: The mediator can become a bottleneck or single point of failure if not designed responsibly.

# Stretch Goals

- Implement a RunwayScheduler strategy interface for different queue prioritization (fuelPriority, vipPriority).

- Add a JavaFX dashboard to visualize runway status and logs in real time.

- Use Java ServiceLoader to allow new Aircraft types to plug in without modifying ControlTower.

