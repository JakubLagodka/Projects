## Introduction
You are developing a microservice consisting of three layers:
- Persistence layer - a `dao` package responsible for retrieving data represented by `Item`, `Review` and `User` entities in the `model` package.
- Service layer - a `service` package responsible for business logic.
- Web layer - a `controller` package serving as a REST endpoint.

## Task definition
Please implement the following methods: 
- `ItemRepository` `List<Item> findItemsWithAverageRatingLowerThan(Double rating)` - the method should find all items that have a rating lower than the rating passed as an argument. Use the reviews associated with each item to calculate the item rating. 
If there are no reviews for an item, then its rating should be zero. Your implementation should make as few database round trips as possible.

- `ItemService` `List<String> getTitles(Double rating)` - the method should retrieve data using the `ItemRepository` and return only the titles of the items.

- `ItemController` `List<String> getTitles(Double rating)` - the method should provide a REST endpoint (GET method) under the '/titles' path and return titles from the `ItemService` in JSON format with UTF8 encoding.
