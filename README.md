[![Build Status](https://travis-ci.org/cesarlopezfab/mars-rover.svg?branch=master)](https://travis-ci.org/cesarlopezfab/mars-rover)
[![Coverage Status](https://coveralls.io/repos/github/cesarlopezfab/mars-rover/badge.svg?branch=master)](https://coveralls.io/github/cesarlopezfab/mars-rover?branch=master)

# mars-rover
Implementation of the mars rover kata


Rules:

- [x] You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
- [x] The rover receives a character array of commands.
- [x] Implement commands that move the rover forward/backward (f,b).
- [x] Implement commands that turn the rover left/right (l,r).
- [x] Implement wrapping from one edge of the grid to another. (planets are spheres after all)
- [ ] Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle.


Nice to have features:

- [ ] Rover is able to auto detect position on landing
- [ ] Add a map of the planet to MarsRover
- [ ] Mars Rover can work on its own researching the surface
- [ ] Research surface on each move
- [ ] Enter rest mode to reload batteries
- [ ] Avoid executing non basic commands when low battery
- [ ] Add some kind of sonar module
- [ ] Add commands at runtime
- [ ] Add "hardware" at runtime
- [ ] Have several planets
- [ ] Random events on planets (eclipses, solar flares...)
- [ ] Thrusters
- [ ] Movement on liquid

Technical issues:

- [ ] Rover mutates the position & direction
- [x] TravisCI integration
- [x] Coverage report
