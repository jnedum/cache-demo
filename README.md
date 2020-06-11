# Introduction
This sample code shows an example using HTTP standard client-size caching.

It has two components:
* cache-server: this API returns a simple String, but includes a pause that makes the request take several seconds.  It includes an HTTP _max-age_ header which the client can implement.
* cache-client: this API calls the cache-server API.  It uses the [Apache Http Components](https://hc.apache.org/httpcomponents-client-ga/tutorial/html/caching.html) library to cache the request on the client side.

## Running the Demo
1. In a terminal window, run `./gradlew cache-server:bootRun` to start the cache-server.
2. In a second terminal window, run `./gradlew cache-client:bootRun` to start the cache-client.
3. The cache-server is configured to run on port 8080, the cache-client on 8081.
4. Call curl with the following command against the cache-client: `curl http://localhost:8081`.  Note that the request takes several seconds to return.
5. Call curl again with the same command `curl http://localhost:8081`.  Note that the request returns much more quickly as cache-client utilizes the local HTTP cache.
6. Keep calling curl, and note that every few seconds (based on the _max-age_ parameter) the request will be slow as the cache expires and it has to call the cache-server again.