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
3. All of my business-logic assumptions stay in comments in the code, where the assumption modified the implementation I
   needed to write.
4. I didn't use AI that much, bth because of time shortage and wanting to properly show how I work. With more time and a
   business logic I already knew I would use it more.
5. I didn't make it in the 2 hours (see git commit timestamps), but again, I put the best effort in it and this is the
   result, so you really know my timings and if it fits your expected performances. On the other side, I also know the
   expected performance now
