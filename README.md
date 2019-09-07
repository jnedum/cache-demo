# Introduction
This sample code shows an example utilizing HTTP standard client-size caching.

It has two components:
* cache-server: this API returns a simple String, but includes a pause that makes the request take several seconds.  It includes an HTTP _max-age_ header which the client can implement.
* cache-client: this API calls the cache-server APi.  It uses the [Apache Http Components](https://hc.apache.org/httpcomponents-client-ga/tutorial/html/caching.html) library to cache the request on the client side.

## Running the Demo
1. In a terminal window, run ./gradlew cache-server:bootRun
2. In a second terminal window, run ./gradlew cache-client:bootRun
3. The Cache Server is configured to run on port 8080, the client on 8081.
4. 