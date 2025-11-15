# SpaceX Dragon Rockets Repository

This project provides an implementation of the SpaceX Dragon Rockets repository as a simple Java library.

### Assumptions

1. I assume that the addNewX methods return the created object to the caller. The alternative would be to create the
   object, Rocket or Mission, and hold it internally returning only the id of that. This way of operating, which I
   usually use when handling complex big objects via API call, feels to me overengineering here because I should then
   implement:
    - a way to search for rockets, ideally an id in an hashmap
    - hold the collection of used ids somewhere to issue new ones withotu overriding the old ones
    - [most importantly] tests that inpsect the *internal* collections of rockets and missions of the
      DragonRocketsRepository, making therefore the hiding worthless
2. Coming to TDD and structuring the tests, since time is my main resource here, I don't use any library. I think it is
   not really needed here and the tests are simple methods that can bee called and either pass or throw and exception
   with a message explaining the difference between the actual and expected value. I throw an exception instead of
   printing to console to stop, on purpose, the execution of test just where they fail, avoiding the failed-test log to
   be lost in all tests logs. It's handier and faster: if the application needed to run in a CI/CD scenario, I would use
   Junit to properly integrate tests in pipelines.
