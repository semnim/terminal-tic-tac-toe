# TerminalTicTacToe
Terminal implementation of tic tac toe with a minimax algorithm. Previously created for hyperskill academy - reboot of old project in order to practise code structure
and simplicity.

## How to play

The game begins with the prompt "Input command". Afterwards, enter two space seperated integers for "row column" to make a move.

Command options: "exit" or "start *player_type* *player_type*"

*player parameters for "start":*
  - "user"
  - AI
    - "easy"
    - "medium"
    - "hard"

Player 1 plays as 'X', Player 2 plays as 'O'.

### Examples:

**User vs User**

<img width="258" alt="Screenshot 2021-12-25 at 13 31 43" src="https://user-images.githubusercontent.com/82184629/147384878-1c1b8b8b-36a3-4104-8b7d-266b36939cf2.png">

**Medium AI vs User**

<img width="258" alt="Screenshot 2021-12-25 at 13 32 02" src="https://user-images.githubusercontent.com/82184629/147384882-088c4138-ab32-4047-8110-03682d33f523.png">


**Hard AI vs Hard AI**

<img width="258" alt="Screenshot 2021-12-25 at 13 34 37" src="https://user-images.githubusercontent.com/82184629/147384895-89dc4b01-d0d2-4b25-9e16-0a67e5a6483f.png">


**User vs Hard AI**

<img width="258" alt="Screenshot 2021-12-25 at 13 31 06" src="https://user-images.githubusercontent.com/82184629/147384856-e763dc4d-a9b9-4f6a-8e66-8280adb3add8.png">


### Description of difficulty levels:

- *Easy mode* places a move randomly on the board.

- *Medium mode* checks one step ahead - it will prevent an immediate loss or take an immediate winning chance.

- *Hard mode* will never lose - it will win whenever you blunder and play a draw whenever you play perfectly.
