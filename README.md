# Java HydraHeads Game

Welcome to the Hydra Heads Game, a Java-based simulation inspired by the mythological Hydra! This game demonstrates recursive gameplay mechanics, where cutting off a Hydra's head spawns new ones, challenging players to "kill" the Hydra completely.

# Game Description
The Hydra Heads Game simulates the classic mythological challenge:
- Each Hydra head has a size, represented as an integer.
- Cutting off a head of size n spawns 2 or 3 heads of size n-1 (randomly determined).
- Heads of size 1 do not regenerate and are removed permanently.
- The game ends when all Hydra heads are eliminated.

# Game features:
- Randomized placement of Hydra heads on the game board.
- A slider to configure the initial size of heads (range: 2-6, default: 4).
- Gameplay controlled by Play and Reset buttons.
- Display of the total number of cuts required to "kill" the Hydra.

# Features
- Graphical Interface: Built with JavaFX.
- Dynamic Gameplay: Heads regenerate recursively, creating a challenging and visually engaging experience.
- Randomization: Heads appear in non-overlapping positions and regenerate unpredictably.
- Customizable Settings: Adjust the initial size of Hydra heads via a slider.

# How to Play
1. Launch the game.
2. Use the slider to set the initial size of the Hydra heads.
3. Click Play to start the game.
4. Observe the Hydra heads regenerate as you cut them off.
5. When all heads are eliminated, the game displays the total number of cuts made.
6. Click Reset to restart the game with new settings.

**Note**: I am yet to complete some of these features, but have the UI and basic functions up and running.
