# SpaceX Dragon Rockets Repository

This project provides an implementation of the SpaceX Dragon Rockets repository as a simple Java library.

### Assumptions

1. I started by assuming that all methods for creating and assigning resources return the created/edited object to the
   caller. That
   said, the getSummary() method requested needs the repo to keep an internal inventory of all the rockets and missions
   issued or assigned. Since my
   first idea for holding the objects internally would need to have ids, but I thnk there is no time for that, I would
   both give back the objects to the caller and hold an internal copy of everything in a structured manner. In such a
   way I could avoid spending time on ids handing while being able to provide a getSummary() functionality.
2. Coming to TDD and structuring the tests, since time is my main resource here, I don't use any library. I think it is
   not really needed here and the tests are simple methods that can bee called and either pass or throw and exception
   with a message explaining the difference between the actual and expected value. I throw an exception instead of
   printing to console to stop, on purpose, the execution of test just where they fail, avoiding the failed-test log to
   be lost in all tests logs. It's handier and faster: if the application needed to run in a CI/CD scenario, I would use
   Junit to properly integrate tests in pipelines.
