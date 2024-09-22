# Rock, Paper, Scissors Game API

This API allows users to create players, start a Rock, Paper, Scissors game, make moves, terminate games, and view player statistics.

## Table of Contents
- [Base URL](#base-url)
- [Endpoints](#endpoints)
    - [Create Player](#create-player)
    - [Start Game](#start-game)
    - [Make Move](#make-move)
    - [Terminate Game](#terminate-game)
    - [Get Game Details](#get-game-details)
    - [Get Player Statistics](#get-player-statistics)
- [Models](#models)
    - [Player](#player)
    - [Game](#game)
    - [Move](#move)
    - [GameStatistics](#gamestatistics)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Postman Collection](#postman-collection)

---

## Base URL
http://localhost:8080/api/v1


## Endpoints

### 1. Create Player

- **URL**: `/players`
- **Method**: `POST`
- **Description**: Creates a new player with a username and email.
- **Parameters**:
    - `username` (String) – The player’s unique username (Required)
    - `email` (String) – The player’s email address (Required)
- **Response**:
    - Returns the newly created `Player` object.

#### Example Request:
```bash
POST /players?username=john_doe&email=john@example.com
  
#### Example Request:

POST /players?username=john_doe&email=john@example.com
```

### 2. Start Game

- **URL**: `/start-game`
- **Method**: `POST`
- **Description**: Starts a new Rock, Paper, Scissors game for the specified player.
- **Parameters**:
    - `username` (String) – The player’s username (Required)
- **Response**:
    - Returns a new Game object.

#### Example Request:
```bash
POST /start-game?username=john_doe
```
### 3. Make Move

- **URL**: `/make-move/{gameId}`
- **Method**: `POST`
- **Description**: Makes a move in the current game.
- **Path Parameters**:
    - `gameId` (String) – The ID of the game (Required)
- **Parameters**:
    - `playerMove` (String) – The player's move: ROCK, PAPER, or SCISSORS (Required)
- **Response**:
    - Returns the Move object, which includes the result of the move.

#### Example Request:
```bash
POST /make-move/game_123?playerMove=ROCK
```

### 4. Terminate Game

- **URL**: `/terminate-game/{gameId}`
- **Method**: `POST`
- **Description**: Terminates an active game.
- **Path Parameters**:
    - `gameId` (String) – The ID of the game to be terminated (Required)
- **Response**:
    - Returns the updated Game object with the status as TERMINATED.

#### Example Request:
```bash
POST /terminate-game/game_123
```
### 5. Get Game Details

- **URL**: `/games/{gameId}`
- **Method**: `GET`
- **Description**: Retrieves details of the specified game.
- **Path Parameters**:
    - `gameId` (String) – The ID of the game to retrieve (Required)
- **Response**:
    - Returns the Game object with the current status and details.

#### Example Request:
```bash
GET /games/game_123
```
### 6. Get Player Statistics

- **URL**: `/players/{username}/stats`
- **Method**: `GET`
- **Description**: Retrieves the game statistics for the specified player.
- **Path Parameters**:
    - `username` (String) – The player's username (Required)
- **Response**:
    - Returns the GameStatistics object, which includes the player's game history, wins, losses, and ties.

#### Example Request:
```bash
GET /players/john_doe/stats
```
## Models

### Player
- **Fields**:
    - `username` (String) – The player's unique username
    - `email` (String) – The player's email address

### Game
- **Fields**:
    - `id` (String) – The unique game ID
    - `playerId` (String) – The ID of the player in the game
    - `status` (String) – The current status of the game: `IN_PROGRESS`, `TERMINATED`

### Move
- **Fields**:
    - `gameId` (String) – The ID of the game
    - `playerMove` (String) – The move made by the player: `ROCK`, `PAPER`, `SCISSORS`
    - `result` (String) – The result of the move: `WIN`, `LOSS`, `TIE`

### GameStatistics
- **Fields**:
    - `playerId` (String) – The player's ID
    - `totalGames` (Integer) – Total games played by the player
    - `wins` (Integer) – Total wins by the player
    - `losses` (Integer) – Total losses by the player
    - `ties` (Integer) – Total ties by the player

---

## Technologies

- **Java 21**
- **Spring Boot**
- **MongoDB** (for data persistence)
- **KeyDB** (for caching)
- **Docker**

---

## Notes

- The game logic is based on traditional **Rock, Paper, Scissors** rules.
- This API is stateless and designed to be used in a distributed environment.
- Game statistics are cached using **KeyDB** for better performance.

## Getting Started

To run the application, use the following command:

```bash
docker compose up --build
```

## Postman Collection

You can import the Postman collection to test the API. The collection file is named `RCP GAME.postman_collection.json`. Use the following steps to import it:

1. Open Postman.
2. Click on the "Import" button in the top-left corner.
3. Select the `RCP GAME.postman_collection.json` file.
4. Run the APIs from the imported collection.