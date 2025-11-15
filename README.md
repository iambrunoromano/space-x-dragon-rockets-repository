# SpaceX Dragon Rockets Repository

This project provides an implementation of the SpaceX Dragon Rockets repository as a simple Java library.

### Assumptions

1. I assume that the addNewX methods return the created object to the caller. The alternative would be to create the
   object, Rocket or Mission, and hold it internally returnin only the id of that. This way of operating, which I
   usually use when handling complex big objects via API call, feels to me overengineering here because I should then
   implement:
    - a way to search for rockets, ideally an id in an hashmap
    - hold the collection of used ids somewhere to issue new ones withotu overriding the old ones
    - [most importantly] tests that inpsect the *internal* collections of rockets and missions of the
      DragonRocketsRepository, making therefore the hiding worthless
2. 
