# WodChecks
Needs checking.

## Premise
Lugging around a bag of dice or a deck of cards can be a pain when you're running or playing in a live game, especially
when players have constantly varying check pools, and all kinds of status effects that alter them. So why not build an
application to do all the heavy lifting for you? Enter WodChecks.

## Check Types

**Cup of Dice** \[ Not Currently Implemented \]
Simply put, the successes are calculated by picking a random number from 1-10 for each dot in the check pool, and
applying the feature logic to determine success.

**40 Card Draw**
The randomisation algorithm emulates a deck of 40 cards, and for each dot in the check pool, draws a card out. The deck
consists only of cards from 1-10 to approximate the results of a 10-sided die.

## Features
The application will eventually support whatever kinds of checks are required for a WoD game, whether it be live or
tabletop. Currently the application supports the following features:

**Cycles**
Due to differences of opinion in various live games, the 'cycles' option allows the user to set the number of
 reshuffles to perform when redrawing cards. If cycles are set to zero, all redraws simply add to the running number of
 draws remaining; if cycles are set to one, once the initial check pool is drawn, the deck is shuffled and redraws are
 then processed, with any redraws being added to the running total, as per cycles:0. If cycles are set to 2, then it
 reshuffles the deck after the first lot of redraws and any redraws from that get drawn then.
Only available and useful when using _40 Card Draw_.

**8-9-10 Again**
Supports redraws triggering on results of 8+, 9+ or 10+ depending on the user's preference.

**Rote Action**
Supports performing actions with the rote quality. All failures are considered redraws on the initial check if this
 feature is active.

**Chance Draw**  
Supports performing a chance draw if the check pool drops to zero. Reports the total as either 1 for drawing a 10, -1
 for drawing a 1, or 0 for drawing anything else.

**Extended Actions** \[ Not Currently Implemented \]
Allows for setting all the required difficulty and time requirements for an extended action, and calculating success or
failure for the whole action in one operation.